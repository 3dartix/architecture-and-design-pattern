package ru.geekbrains.atm.service.paymentStrategy;

import java.math.BigDecimal;

public interface PaymentStrategy {
    void pay(BigDecimal amount);
}
