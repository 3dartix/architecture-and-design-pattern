package ru.geekbrains.atm.service.paymentStrategy;

import lombok.extern.apachecommons.CommonsLog;

import java.math.BigDecimal;

@CommonsLog
public final class PaymentWithCard implements PaymentStrategy {
    private String phoneNumber;

    public PaymentWithCard(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(BigDecimal amount) {
        log.info("Оплатить картой");
    }
}
