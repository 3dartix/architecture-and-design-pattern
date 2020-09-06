package ru.geekbrains.atm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.atm.component.Database;

import java.math.BigDecimal;

@Repository
public class GuestRepository {
    @Autowired
    private Database bd;

    public BigDecimal getCurrBalance(){
        return new BigDecimal(20000);
    }
}
