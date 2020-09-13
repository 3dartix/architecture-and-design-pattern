package ru.geekbrains.atm.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.atm.entity.Role;
import ru.geekbrains.atm.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Configuration
public class UserMapper  {

    private Connection connection;

    @Autowired
    public UserMapper(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // помимо пинкода карты добавил еще уникальный id карты 16 цифр.
    // Так хранить пользователей в мепе эффективней, чем искать по пинкоду. Кроме того он еще может быть одинаковым.
    public Optional<User> findByPin(String cardCode, int pin){

        //достаем пользователя, если он уде был загружен в систему
        User user = UserIdentityMap.getInstance().findUserByCardCode(cardCode);
        if (user != null){
            return Optional.of(user);
        }

        //если пользователя в системе нет то тправляем запрос и создаем его
        Statement stmt;
        ResultSet rs;

        try {
            // ищем юзера по id
            user = new User();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(String.format("SELECT user.id as id, user.firstname as firstname, user.lastName as lastName, role.name as role  FROM user WHERE pin = %d INNER JOIN role on user.id = role.id", pin));
            while (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastName"));
                user.setRole(Role.valueOf(rs.getString("role")));
            }
            // если юзер не найден возвращаем пустоту
            if(user.getId() == 0 || user.getFirstName() == "" || user.getLastName() == "") {
                return Optional.empty();
            }

            //если все ок то возвращаем юзера и добавляем его в кэш
            UserIdentityMap.getInstance().addUser(cardCode, user);
            return Optional.of(user);

        } catch (SQLException e) {
            e.printStackTrace();
            //возвращаем пустоту
            return Optional.empty();
        }
    }
}
