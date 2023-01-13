package com.system.readnovel.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {
    @GetMapping("/landing_page")
    public String getLandingPage() {
        return "landingpage";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "mainpage";
    }

//    @Autowired
//    private NovelService novelService;
//
//    @GetMapping("/home")
//    public String mainPage(Model model) {
//        List<Novel> latestNovels = novelService.getLatestNovels();
//        model.addAttribute("latestNovels", latestNovels);
//        return "mainpage";
//    }
}
