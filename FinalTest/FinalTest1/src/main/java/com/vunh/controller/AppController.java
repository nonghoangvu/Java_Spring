package com.vunh.controller;

import com.vunh.entity.DichVu;
import com.vunh.entity.LoaiDichVu;
import com.vunh.repository.DichVuRepository;
import com.vunh.repository.LoaiDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dich-vu")
public class AppController {
    @Autowired
    private LoaiDichVuRepository loaiDichVu;

    @Autowired
    private DichVuRepository dichVu;

    @ModelAttribute("dichVu")
    DichVu getDichVu() {
        return new DichVu();
    }

    @ModelAttribute("listDichVu")
    List<DichVu> getListDichVu() {
        return this.dichVu.findAllDichVu();
    }

    @ModelAttribute("loaiDichVu")
    List<LoaiDichVu> getLoaiDichVu() {
        return this.loaiDichVu.findAllDichVu();
    }

    @GetMapping("/hien-thi")
    public String hienThi() {
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dichVu") DichVu dichVu) {
        this.dichVu.save(dichVu);
        return "redirect:/dich-vu/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("dichVu", this.dichVu.findDichVuByIdNative(id));
        return "index";
    }
}
