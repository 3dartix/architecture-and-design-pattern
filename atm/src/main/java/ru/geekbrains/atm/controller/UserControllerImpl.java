package ru.geekbrains.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.atm.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements ClientController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/withdraw/start")
    public String withdrawCashStart(){
        userService.openBillAcceptor();
        return "withdraw-page.html";
    }

    @PostMapping("/withdraw/finish")
    public String withdrawCashFinish(){
        userService.closeBillAcceptor();
        return "redirect:/user/check-balance";
    }

    @GetMapping("/check-balance")
    public String checkBalance(Model model){
        model.addAttribute("balance", userService.getCurrBalance());
        return "check-balance-page.html";
    }

    @GetMapping("/deposit/start")
    public String depositStart(){
        userService.openBillAcceptor();
        return "deposit-page.html";
    }

    @PostMapping("/deposit/finish")
    public String depositFinish(){
        userService.closeBillAcceptor();
        return "redirect:/user/check-balance";
    }
}
