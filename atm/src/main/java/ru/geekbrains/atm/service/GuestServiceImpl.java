package ru.geekbrains.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.atm.component.BillAcceptor;
import ru.geekbrains.atm.repository.GuestRepository;

import java.math.BigDecimal;

@Service
public class GuestServiceImpl implements ClientService {

    private BillAcceptor billAcceptor;
    private GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(BillAcceptor billAcceptor, GuestRepository guestRepository) {
        this.billAcceptor = billAcceptor;
        this.guestRepository = guestRepository;
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
        return guestRepository.getCurrBalance();
    }
}
