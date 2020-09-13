package ru.geekbrains.atm.repo;

import ru.geekbrains.atm.entity.User;
import java.util.HashMap;
import java.util.Map;

public class UserIdentityMap {
    private static UserIdentityMap instance = new UserIdentityMap();
    private Map<String, User> users;

    public static UserIdentityMap getInstance(){
        return instance;
    }

    public UserIdentityMap() {
        this.users = new HashMap<>();
    }

    public void addUser(String cardCode, User user){
        users.put(cardCode, user);
    }

    public User findUserByCardCode(String cardCode){
        return users.get(cardCode);
    }

    public void deleteUserByCardCode(String cardCode){
        users.remove(cardCode);
    }
}
