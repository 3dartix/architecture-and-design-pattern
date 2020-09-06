package ru.geekbrains.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.atm.service.GuestServiceImpl;

@Controller
@RequestMapping("/guest")
public class GuestControllerImpl implements ClientController {

    @Autowired
    private GuestServiceImpl guestService;

    @GetMapping("/withdraw/start")
    public String withdrawCashStart(){
        guestService.openBillAcceptor();
        return "withdraw-page.html";
    }

    @PostMapping("/withdraw/finish")
    public String withdrawCashFinish() {
        guestService.closeBillAcceptor();
        return "redirect:/guest/check-balance";
    }

    @GetMapping("/check-balance")
    public String checkBalance(Model model){
        model.addAttribute("balance", guestService.getCurrBalance());
        return "check-balance-page.html";
    }

    @GetMapping("/deposit/start")
    public String depositStart(){
        guestService.openBillAcceptor();
        return "deposit-page.html";
    }

    @PostMapping("/deposit/finish")
    public String depositFinish(){
        guestService.closeBillAcceptor();
        return "redirect:/guest/check-balance";
    }
}
