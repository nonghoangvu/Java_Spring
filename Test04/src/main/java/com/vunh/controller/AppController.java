package com.vunh.controller;

import com.vunh.entity.MayTinh;
import com.vunh.service.MayTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private MayTinhService service;

    @GetMapping
    String index(Model model, @RequestParam("p")Optional<Integer> p, Optional<String> sortBy) {
        Pageable pageable = PageRequest.of(p.orElse(0), 3, Sort.Direction.ASC, sortBy.orElse("gia"));
        model.addAttribute("computers", this.service.getAllMayTinh(pageable));
        return "index";
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable int id) {
        this.service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable int id, Model model) {
        model.addAttribute("brands", this.service.getAllHang());
        model.addAttribute("computer", this.service.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    String update(@ModelAttribute MayTinh entity) {
        this.service.update(entity);
        return "redirect:/";
    }
}