package com.vunh.repository;

import com.vunh.entity.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu, Integer> {
    @Query(value = "SELECT * FROM loai_dich_vu", nativeQuery = true)
    List<LoaiDichVu> findAllDichVu();
}
