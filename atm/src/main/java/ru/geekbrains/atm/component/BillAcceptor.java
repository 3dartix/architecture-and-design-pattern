package ru.geekbrains.atm.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BillAcceptor {
    public void open(){
        System.out.printf("Открыть купюроприемник");
    }

    public void close(){
        System.out.printf("Закрыть купюроприемник");
    }
}
