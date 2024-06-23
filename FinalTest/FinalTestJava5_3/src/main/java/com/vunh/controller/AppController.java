package com.vunh.controller;

import com.vunh.entity.DatPhong;
import com.vunh.entity.KhachHang;
import com.vunh.repository.DatPhongRepository;
import com.vunh.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dat-phong")
public class AppController {
    @Autowired
    private DatPhongRepository datPhongRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @ModelAttribute("listPhong")
    List<DatPhong> listPhong() {
        return this.datPhongRepository.findAll();
//        return new ArrayList<DatPhong>();
    }

    @ModelAttribute("phong")
    DatPhong phong() {
        return new DatPhong();
    }

    @ModelAttribute("listKhachHang")
    List<KhachHang> listKhachHang() {
        return this.khachHangRepository.findAll();
    }

    @GetMapping("/hien-thi")
    String index() {
        return "index";
    }

    @GetMapping("/view-update/{id}")
    String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("phong", this.datPhongRepository.findById(id).orElse(new DatPhong()));
        return "index";
    }

    @PostMapping("/update")
    String update(@Validated @ModelAttribute("phong") DatPhong phong, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phong", phong);
            return "index";
        }
        this.datPhongRepository.save(phong);
        return "redirect:/dat-phong/hien-thi";
    }

    @GetMapping("/search")
    String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("listPhong", this.datPhongRepository.findByKeyword(keyword));
        return "index";
    }
}
