package ru.geekbrains.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.atm.component.BillAcceptor;
import ru.geekbrains.atm.repository.UserRepository;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements ClientService {

    private BillAcceptor billAcceptor;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BillAcceptor billAcceptor, UserRepository userRepository) {
        this.billAcceptor = billAcceptor;
        this.userRepository = userRepository;
    }

    @Override
    public void openBillAcceptor() {
        billAcceptor.open();
    }

    @Override
    public void closeBillAcceptor() {
        billAcceptor.close();
    }

    public BigDecimal getCurrBalance(){
        return userRepository.getCurrBalance();
    }
}
