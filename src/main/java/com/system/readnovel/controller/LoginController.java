package com.system.readnovel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/homepage")
    public  String getPage(){
        return "landingpage";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegister(){
        return "register_user";
    }

    @GetMapping("/admin-dashboard")
    public String getAdminDashboard(){
        return "Dashboard";
    }

}
