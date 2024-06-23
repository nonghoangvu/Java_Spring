package com.vunh.demojava5.controller;

import com.vunh.demojava5.entity.Product;
import com.vunh.demojava5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam("p") Optional<Integer> p,
            @RequestParam("sortBy") Optional<String> sortBy,
            @RequestParam(value = "sort", defaultValue = "asc") String sort,
            @RequestParam("keyword") Optional<String> keyword
    ) {
        Sort.Direction handleSort;
        if (sort.contains("asc")) {
            handleSort = Sort.Direction.ASC;
        } else {
            handleSort = Sort.Direction.DESC;
        }
        Pageable pageable = PageRequest.of(p.orElse(0), 10, handleSort, sortBy.orElse("id"));
        model.addAttribute("sort", sort);
        model.addAttribute("products", productService.findAll(pageable, keyword.orElse("")));
        model.addAttribute("keyword", keyword.orElse(""));
        return "index";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", this.productService.getAllCategory());
        return "StoreProduct";
    }

    @PostMapping("/add")
    public String store(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", this.productService.getAllCategory());
            return "StoreProduct";
        }
//        this.productService.storeProduct(product);
        System.out.println(product.getCategory().getName());
        return "redirect:/";
    }
}
