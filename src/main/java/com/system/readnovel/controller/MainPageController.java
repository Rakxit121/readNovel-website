package com.system.readnovel.controller;


import com.system.readnovel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class MainPageController {
    private final UserService userService;

    @GetMapping("/main")
    public String geMainPage() {
//        model.addAttribute("feedback", new FeedbackPojo());

        return ("mainpage");
    }






}
