package com.vunh.repository;

import com.vunh.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
}
