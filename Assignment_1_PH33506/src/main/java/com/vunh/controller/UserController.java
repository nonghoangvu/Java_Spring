package com.vunh.controller;

import com.vunh.entity.User;
import com.vunh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    String index(Model model, @RequestParam(name = "q", required = false, defaultValue = "") String q) {
        model.addAttribute("q", q);
        model.addAttribute("fragment", "users/index.jsp");
        model.addAttribute("users", this.userService.findAll(q));
        return "index";
    }

    void setup(Model model, User user, String action, String title, Boolean type) {
        model.addAttribute("user", user);
        model.addAttribute("action", "/" + action);
        model.addAttribute("title", title);
        model.addAttribute("type", type);
        model.addAttribute("fragment", "users/user_action.jsp");
    }

    @GetMapping("/add")
    String add(Model model) {
        setup(model, new User(), "user/add", "New ", false);
        return "index";
    }

    @PostMapping("/add")
    String store(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            setup(model, user, "user/add", "New ", false);
            model.addAttribute("error", true);
            return "index";
        }
        this.userService.save(user);
        redirectAttributes.addFlashAttribute("new_user", true);
        return "redirect:/user";
    }

    @GetMapping("/edit/{username}")
    String edit(@PathVariable String username, Model model) {
        setup(model, this.userService.findByUsername(username), "user/edit", "Update ", true);
        return "index";
    }

    @PostMapping("/edit")
    String update(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            setup(model, user, "user/edit", "Update ", true);
            model.addAttribute("error", true);
            return "index";
        }
        this.userService.update(user);
        redirectAttributes.addFlashAttribute("new_update", true);
        return "redirect:/user";
    }

    @GetMapping("/{username}")
    String show(@PathVariable String username, RedirectAttributes redirectAttributes) {
        this.userService.deleteByUsername(username);
        redirectAttributes.addFlashAttribute("delete_success", true);
        return "redirect:/user";
    }
}
