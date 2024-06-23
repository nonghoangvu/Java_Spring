package com.vunh.controller;

import com.vunh.entity.NhanVien;
import com.vunh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/khach-hang")
public class AppController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("listEmp", this.employeeService.getEmployees());
        return "index";
    }

    @PostMapping
    String store(NhanVien nhanVien) {
        this.employeeService.save(nhanVien);
        return "redirect:/khach-hang";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("sdt") String std, Model model) {
        model.addAttribute("emp", this.employeeService.findById(std));
        return "detail";
    }
}
