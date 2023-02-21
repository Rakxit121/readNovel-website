//package com.system.readnovel.controller;
//
//
//import ch.qos.logback.core.model.Model;
//import com.system.readnovel.entity.Novel;
//import com.system.readnovel.pojo.UserPojo;
//import com.system.readnovel.repo.NovelRepo;
//import com.system.readnovel.services.NovelService;
//import com.system.readnovel.services.UserService;
//import jakarta.validation.Valid;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//import java.util.List;
//
//@Controller
////@RequiredArgsConstructor
//@RequestMapping("")
//public class MainPageController {
//    private final UserService userService;
//    private final NovelService novelService;
//    private final NovelRepo novelRepo;
//
//
//    public MainPageController(UserService userService, NovelService novelService, NovelRepo novelRepo) {
//        this.userService = userService;
//        this.novelService = novelService;
//        this.novelRepo = novelRepo;
//    }
//
//    @GetMapping("/main")
//    public String getMainPage(Model model) {
////        // Fetch the list of novels from the database
//        List<Novel> novels = novelService.findAllNovel();
////
////        // Add the list of novels to the model
//        model.addAttribute("novels", novels);
//
//        // Return the name of the Thymeleaf template to use for the main page
//        return "mainpage";
//    }
//
//
//
//
////    @GetMapping("/novels")
////    public String displayNovels(Model model) {
////        List<Novel> novels = novelRepo.findAll();
////        List<PageData> pageDatas = new ArrayList<>();
////
////        for (Novel novel : novels) {
////            PageData pageData = new PageData();
////            pageData.setTitle(novel.getTitle());
////            pageData.setRating(novel.getRating());
////            pageData.setLink(novel.getLink());
////            // Set other properties as needed
////
////            pageDatas.add(pageData);
////        }
////
////        model.addAttribute("pageDatas", pageDatas);
////
////        return "novels";
////    }
//
//
//    @GetMapping("/novelSitePage")
//    public  String getNovelPage(Model model){
//        List<Novel> novels = novelService.fetchAllNovel();
//        model.addAttribute("novel", novels);
//        return "novelPage";
//    }
//
////    @GetMapping("/userComments")
////    public String getUserComments(org.springframework.ui.Model model){
////        List<Feedback> feedbacks = userService.fetchAllFeedback();
////        model.addAttribute("feedback", feedbacks);
////        return "AdminUserComment";
////    }
//
//
//
//
//    @GetMapping("/profile")
//    public String getUserProfile (Integer id, org.springframework.ui.Model model, Principal principal) {
////        User user= userService.getById(id);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//        model.addAttribute("update", new UserPojo());
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
//        return "user_profile";
//    }
//    @PostMapping("/updateUser")
//    public String updateUser(@Valid UserPojo userpojo) {
//        userService.save(userpojo);
//        return "redirect:/homepage/profile";
//    }
//
//}


package com.system.readnovel.controller;

        import com.system.readnovel.entity.Novel;
        import com.system.readnovel.pojo.UserPojo;
        import com.system.readnovel.repo.NovelRepo;
        import com.system.readnovel.services.NovelService;
        import com.system.readnovel.services.UserService;
        import jakarta.validation.Valid;
        import org.springframework.security.authentication.AnonymousAuthenticationToken;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.security.Principal;
        import java.util.List;

@Controller
@RequestMapping("")
public class MainPageController {
    private final UserService userService;
//    private final NovelService novelService;
    private final NovelRepo novelRepo;

    public MainPageController(UserService userService /*, NovelService novelService*/, NovelRepo novelRepo) {
        this.userService = userService;
//        this.novelService = novelService;
        this.novelRepo = novelRepo;
    }

    @GetMapping("/main")
    public String getMainPage(Model model) {
//        List<Novel> novels = novelService.findAllNovel();
//        model.addAttribute("novels", novels);
        return "mainpage";
    }

    @GetMapping("/novelSitePage")
    public String getNovelPage(Model model) {
//        List<Novel> novels = novelService.fetchAllNovel();
//        model.addAttribute("novels", novels);
        return "novelPage";
    }

    @GetMapping("/bookmarkPage")
    public String getBookmark(){
        return "Bookmark";
    }

    @GetMapping("/profile")
    public String getUserProfile(Integer id, Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("update", new UserPojo());
        model.addAttribute("info", userService.findByEmail(principal.getName()));
        return "user_profile";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:/homepage/profile";
    }
}
