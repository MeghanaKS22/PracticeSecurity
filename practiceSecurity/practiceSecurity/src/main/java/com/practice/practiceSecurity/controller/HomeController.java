package com.practice.practiceSecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            String username = auth.getName();
            model.addAttribute("username", username);
            model.addAttribute("success", "Successfully authenticated by JWT token");
        }

        return "home";
    }


    @GetMapping("/form")
    public String showForm() {
        return "form";
    }


    @PostMapping("/view")
    public String viewData(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String course,
            @RequestParam String token,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("course", course);
        model.addAttribute("token",token);

        return "view";
    }

    @GetMapping("/view")
    public String viewPage() {

        return "/view";
    }
}
