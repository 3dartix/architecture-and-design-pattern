package ru.geekbrains.atm.service.paymentServices;

import ru.geekbrains.atm.service.paymentStrategy.PaymentStrategy;

import java.math.BigDecimal;

public class PaymentForTelephone extends PaymentConfig {
    private String numberPhone;

    public PaymentForTelephone(String numberPhone, PaymentStrategy paymentStrategy) {
        this.numberPhone = numberPhone;
        super.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(BigDecimal amount) {
        paymentStrategy.pay(amount);
    }
}
