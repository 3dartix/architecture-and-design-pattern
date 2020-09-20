package ru.geekbrains.atm.component;

import org.springframework.stereotype.Component;
import ru.geekbrains.atm.entity.Role;
import ru.geekbrains.atm.entity.User;

import java.util.Optional;

@Component
public class Database {
    public Optional<User> findUserByPin(String pin){
        return Optional.of(new User(1L, "Василий", "Пупкин", Role.ADMIN));
    }

    public Optional<User> findUserById(Long id){
        return Optional.of(new User(id, "Василий", "Пупкин", Role.ADMIN));
    }
}
