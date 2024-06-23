package com.vunh.service;

import com.vunh.entity.NhanVien;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class EmployeeService {
    public List<NhanVien> employees;
    public EmployeeService() {
        this.employees = new ArrayList<NhanVien>();
        this.employees.add(new NhanVien("Nong Hoang Vu", "0123456780", "Vang", true));
        this.employees.add(new NhanVien("Hacker Vu", "0123456781", "Dong", false));
        this.employees.add(new NhanVien("Mr. Vuz", "0123456782", "Bac", true));
    }

    public void save(NhanVien nhanVien) {
        this.employees.add(nhanVien);
    }

    public NhanVien findById(String name) {
        return this.employees.stream().filter(s -> s.getSdt().equals(name)).findFirst().orElse(null);
    }
}
