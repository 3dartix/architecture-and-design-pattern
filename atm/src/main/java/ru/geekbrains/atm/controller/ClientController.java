package ru.geekbrains.atm.controller;

import org.springframework.ui.Model;

public interface ClientController {
    String withdrawCashStart();
    String withdrawCashFinish();
    String checkBalance(Model model);
    String depositStart();
    String depositFinish();
}
