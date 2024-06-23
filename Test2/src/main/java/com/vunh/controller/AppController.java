package com.vunh.controller;

import com.vunh.entity.Invoice;
import com.vunh.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("customer", this.invoiceService.getCustomers());
        return "index";
    }
    @PostMapping
    public String save(@Validated @ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", this.invoiceService.getCustomers());
            return "index";
        }
        System.out.println(invoice);
        return "redirect:/?success";
    }
}
