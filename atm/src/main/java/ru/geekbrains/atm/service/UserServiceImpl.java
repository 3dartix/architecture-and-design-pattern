package ru.geekbrains.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.atm.component.BillAcceptor;
import ru.geekbrains.atm.repository.UserRepository;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements ClientService {

    private BillAcceptor billAcceptor;
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(BillAcceptor billAcceptor, UserRepository repository) {
        this.billAcceptor = billAcceptor;
        this.repository = repository;
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
        return repository.getCurrBalance();
    }
}
