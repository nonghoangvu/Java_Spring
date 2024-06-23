package com.vunh.controller;

import com.vunh.entity.User;
import com.vunh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    String index(Model model, @RequestParam("name") Optional<String> name) {
        model.addAttribute("name", name.orElse("Empty"));
        return "index";
    }

    @GetMapping("/home")
    String home(Model model, @RequestParam("name") Optional<String> value) {
        model.addAttribute("value", value.orElse(""));
        model.addAttribute("listStudent", this.studentService.getStudents(value.orElse("")));
        return "home";
    }

    @GetMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    String handleLogin(@Validated @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "login";
        }
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/home";
    }

}
