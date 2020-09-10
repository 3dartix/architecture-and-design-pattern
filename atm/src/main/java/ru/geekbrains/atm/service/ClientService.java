package ru.geekbrains.atm.service;
import java.math.BigDecimal;

public interface ClientService {
    void openBillAcceptor();
    void closeBillAcceptor();
    BigDecimal getCurrBalance();
}
