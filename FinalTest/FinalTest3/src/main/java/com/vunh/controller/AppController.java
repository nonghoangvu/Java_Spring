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

import java.util.List;

@Controller
@RequestMapping("/dat-phong")
public class AppController {
    @Autowired
    private DatPhongRepository datPhongRepository;

    @Autowired
    protected KhachHangRepository khachHangRepository;

    @ModelAttribute("datPhong")
    public List<DatPhong> getListDatPhong() {
        return datPhongRepository.findAll();
    }

    @ModelAttribute("khachHang")
    public List<KhachHang> getKhachHang() {
        return this.khachHangRepository.findAll();
    }

    @ModelAttribute("order")
    public DatPhong getDatPhong() {
        return new DatPhong();
    }

    @GetMapping("/hien-thi")
    public String index() {
        return "index";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable int id, Model model) {
        model.addAttribute("order", this.datPhongRepository.findById(id).orElse(null));
        return "index";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("order") DatPhong order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("order", order);
            return "index";
        }
        this.datPhongRepository.save(order);
        return "redirect:/dat-phong/hien-thi";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("maDatPhong") String maDatPhong) {
        model.addAttribute("datPhong", this.datPhongRepository.findByMaDatPhong(maDatPhong));
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        this.datPhongRepository.deleteById(id);
        return "redirect:/dat-phong/hien-thi";
    }
}
