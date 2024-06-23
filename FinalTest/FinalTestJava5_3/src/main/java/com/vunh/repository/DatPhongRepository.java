package com.vunh.repository;

import com.vunh.entity.DatPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatPhongRepository extends JpaRepository<DatPhong, Integer> {
    @Query("FROM DatPhong WHERE maDatPhong LIKE %:keyword%")
    List<DatPhong> findByKeyword(@Param("keyword") String keyword);
}
