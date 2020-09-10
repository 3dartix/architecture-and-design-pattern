package ru.geekbrains.atm.service.paymentServices;

import ru.geekbrains.atm.service.paymentStrategy.PaymentStrategy;

import java.math.BigDecimal;

public abstract class PaymentConfig {
    protected PaymentStrategy paymentStrategy;
    public abstract void pay(BigDecimal amount);
}
