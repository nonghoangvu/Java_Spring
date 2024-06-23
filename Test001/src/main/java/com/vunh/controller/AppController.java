package com.vunh.controller;

import com.vunh.entity.GioHang;
import com.vunh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cart", new GioHang());
        model.addAttribute("customers", this.cartService.getKhachHang());
        model.addAttribute("carts", this.cartService.getAllGioHang());
        return "index";
    }

    @PostMapping
    public String store(@ModelAttribute GioHang gioHang) {
        System.out.println(gioHang);
        return "redirect:/";
    }
}
