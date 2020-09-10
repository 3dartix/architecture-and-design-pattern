package ru.geekbrains.atm.service.paymentStrategy;

import lombok.extern.apachecommons.CommonsLog;

import java.math.BigDecimal;

@CommonsLog
public class PaymentWithPayPal implements PaymentStrategy {
    private String mail;
    private String token;

    public PaymentWithPayPal(String mail, String token) {
        this.mail = mail;
        this.token = token;
    }

    @Override
    public void pay(BigDecimal amount) {
        log.info("Оплатить через пайпал");
    }
}
