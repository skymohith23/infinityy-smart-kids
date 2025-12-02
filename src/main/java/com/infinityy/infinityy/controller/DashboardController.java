package com.infinityy.infinityy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth) {

        // Get role of user
        String role = auth.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        if (role.equals("ROLE_TEACHER")) {
            return "redirect:/teacher/home";
        } else if (role.equals("ROLE_PARENT")) {
            return "redirect:/parent/home";
        }

        return "redirect:/login";
    }
}
