package ru.geekbrains.atm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.atm.entity.User;
import ru.geekbrains.atm.principal.Principal;
import ru.geekbrains.atm.repository.AuthRepository;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository userRepository;

    public boolean authByPin(String pin){
        Optional<User> user = userRepository.findUserByPin(pin);
        if (user.isPresent()){
            //создаем пользователя, если авторизован
            Principal.setUser(user.get());
            return true;
        } else {
            return false;
        }
    }
}
