package com.vunh.controller;

import com.vunh.entity.Student;
import com.vunh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    String index(Model model) {
        model.addAttribute("listStudent", this.studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    String create(Model model) {
        model.addAttribute("student", new Student());
        return "Student_Add";
    }

    @PostMapping("/add")
    String store(@Validated @ModelAttribute("student") Student student, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "Student_Add";
        }
        this.studentService.addOrUpdateStudent(student);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    String update(Model model, @PathVariable int id) {
        model.addAttribute("student", this.studentService.getStudentById(id));
        System.out.println(id);
        return "Student_Edit";
    }
    @PostMapping("/update")
    String update(@Validated @ModelAttribute("student") Student student, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "Student_Edit";
        }
        this.studentService.addOrUpdateStudent(student);
        return "redirect:/";
    }

    @GetMapping("{id}")
    String delte(@PathVariable int id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
