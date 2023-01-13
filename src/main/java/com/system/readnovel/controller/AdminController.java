//package com.system.readnovel.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private NovelService novelService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/book-list")
//    public String getNovelList(Model model) {
//        List<Novel> novelList = novelService.getNovels();
//        model.addAttribute("novelList", novelList);
//        return "addBook";
//    }
//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model) {
//        UploadNovel uploadnovel = userService.fetchById(id);
//        model.addAttribute("bookList", new BookingPojo(uploadnovel));
//        return "redirect: /admin/bookList";
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") Integer id) {
//        userService.deleteById(id);
//        return "redirect:/admin/book-list";
//    }
//
//    ;
//    @GetMapping("/list")
//    public String getUserList(Model model) {
//        List<User> bookings = userService.fetchAll();
//        model.addAttribute("bookinglist", bookings);
//        return "viewCustomerlist";
//    }
//
//}
