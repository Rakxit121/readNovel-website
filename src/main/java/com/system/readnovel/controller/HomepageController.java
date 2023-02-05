package com.system.readnovel.controller;

import com.system.readnovel.pojo.FeedbackPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {

    @GetMapping("")
    public String geHomepage(Model model) {
        model.addAttribute("feedback", new FeedbackPojo());

        return ("landingpage");
    }

//    @GetMapping("/landing_page")
//    public String getLandingPage() {
//        return "landingpage";
//    }

    @GetMapping("/home")
    public String getMainPage(){
        return "mainpage";
    }

    @GetMapping("/register")
    public  String getRegister(){
        return "register_user";
    }

    @GetMapping("/user_profile")
    public String getUserProfile(){return "user_profile";}

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
