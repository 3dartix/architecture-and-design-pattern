package ru.geekbrains.atm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.atm.component.Database;
import ru.geekbrains.atm.entity.User;

import java.util.Optional;

@Repository
public class AuthRepository {
    @Autowired
    private Database bd;

    public Optional<User> findUserByPin(String pin){
        return bd.findUserByPin(pin);
    }
}
