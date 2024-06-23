package com.vunh.repository;

import com.vunh.entity.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaPhongRepositroy extends JpaRepository<LoaiPhong, Integer> {
}
