package com.system.readnovel.controller;

import com.system.readnovel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;


    @GetMapping("")
    public String getAdminDashboard(){
        return "Dashboard";
    }

    @GetMapping("/novelList")
    public String getNovelList(){
        return "adminBookList";
    }



}
