//package com.vunh.controller;
//
//import com.vunh.service.MayTinhService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AppController {
//    @Autowired
//    private MayTinhService service;
//
//    @GetMapping
//    String index(Model model) {
////        Pageable pageable = PageRequest.of(0, 3);
////        model.addAttribute("computers", this.service.getAllMayTinh(pageable));
//        return "index";
//    }
//}
