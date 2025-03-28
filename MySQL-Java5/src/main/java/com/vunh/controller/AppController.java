package com.vunh.controller;

import com.vunh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String index() {
        return "index";
    }
}
