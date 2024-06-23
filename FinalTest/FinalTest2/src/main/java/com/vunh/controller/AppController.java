package com.vunh.controller;

import com.vunh.entity.LoaiPhong;
import com.vunh.entity.Phong;
import com.vunh.repository.LoaPhongRepositroy;
import com.vunh.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/phong")
public class AppController {
    @Autowired
    private LoaPhongRepositroy loaPhongRepositroy;
    @Autowired
    private PhongRepository phongRepository;

    @ModelAttribute("listLoaiPhong")
    public List<LoaiPhong> listLoaiPhong() {
        return this.loaPhongRepositroy.findAll();
    }

    @ModelAttribute("listPhong")
    public Page<Phong> listPhong() {
        Pageable pageable = PageRequest.of(0, 20);
        return this.phongRepository.findAll(pageable);
    }

    @ModelAttribute("phong")
    public Phong phong() {
        return new Phong();
    }

    @GetMapping("/hien-thi")
    String hienthi() {
        return "index";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable int id, Model model) {
        model.addAttribute("phong", phongRepository.findById(id).orElse(new Phong()));
        return "index";
    }

    @PostMapping("/add")
    String add(@Validated @ModelAttribute("phong") Phong phong, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phong", phong);
            return "index";
        }
        this.phongRepository.save(phong);
        return "redirect:/phong/hien-thi";
    }

    @GetMapping("/paging")
    String paging(Model model, @RequestParam("p") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("listPhong", phongRepository.findAll(pageable));
        return "index";
    }
}
