package ru.geekbrains.atm.principal;
import ru.geekbrains.atm.entity.User;

//класс где создается пользователь, если авторизая прошла успешно
public class Principal {
    private static User user = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Principal.user = user;
    }
}
