package ru.geekbrains.atm.service.paymentStrategy;

import lombok.extern.apachecommons.CommonsLog;

import java.math.BigDecimal;

@CommonsLog
public class PaymentWithCash implements PaymentStrategy {

    @Override
    public void pay(BigDecimal amount) {
        log.info("Оплатить наличными");
    }
}
