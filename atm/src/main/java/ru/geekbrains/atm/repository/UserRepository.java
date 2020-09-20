package ru.geekbrains.atm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.atm.component.Database;
import ru.geekbrains.atm.entity.User;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private Database bd;

    public BigDecimal getCurrBalance(){
        return new BigDecimal(20000);
    }
}
