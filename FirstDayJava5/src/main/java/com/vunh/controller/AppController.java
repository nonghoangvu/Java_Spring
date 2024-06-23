package com.vunh.controller;

import com.vunh.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    String index(Model model) {
        model.addAttribute("list", this.userAccountService.getUserAccounts());
        return "index";
    }
}
