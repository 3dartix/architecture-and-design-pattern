package ru.geekbrains.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.atm.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    public AuthService authService;

    //получаем пинкод пользователя из представления c помощью thymeleaf или аналогичного шаблонизатора
    @PostMapping
    public String auth(String pin){
        if(authService.authByPin(pin)){
            return "menu.html";
        } else {
            return "login-page.html";
        }
    }
}
