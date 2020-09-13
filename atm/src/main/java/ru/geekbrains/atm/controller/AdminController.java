package ru.geekbrains.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.atm.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/logs/show-all")
    public String showLogs(Model model){
        model.addAttribute("filesLog", adminService.getListLogs());
        return "logs-page.html";
    }

    @GetMapping("/logs/download/{name}")
    public String downloadLog(@PathVariable String name){
        String path = adminService.getLogByName(name);
        return "redirect:/logs/show-all";
    }

    @GetMapping("/logs/download-all")
    public String downloadAllLogs(){
        return "redirect:/logs/show-all";
    }


    @GetMapping("/show/camera-footage")
    public String downloadCameraFootage(){
        return "camera-footage-page.html";
    }
}
