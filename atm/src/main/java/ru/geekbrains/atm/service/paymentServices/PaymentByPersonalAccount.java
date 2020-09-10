package ru.geekbrains.atm.service.paymentServices;

import ru.geekbrains.atm.service.paymentStrategy.PaymentStrategy;

import java.math.BigDecimal;

public class PaymentByPersonalAccount extends PaymentConfig {
    private String personalAccount;

    public PaymentByPersonalAccount(String personalAccount, PaymentStrategy paymentStrategy) {
        this.personalAccount = personalAccount;
        super.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(BigDecimal amount) {
        paymentStrategy.pay(amount);
    }
}
