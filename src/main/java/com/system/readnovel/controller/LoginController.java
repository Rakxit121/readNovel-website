package com.system.readnovel.controller;

import com.system.readnovel.entity.User;
import com.system.readnovel.pojo.UserPojo;
import com.system.readnovel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginController {

    private final UserService userService;

//    @GetMapping("/homepage")
//    public  String getPage(){
//        return "landingpage";
//    }


    @GetMapping("/login")
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        //redirecting to page after the login is complete
        return "redirect:/main";
    }

}
