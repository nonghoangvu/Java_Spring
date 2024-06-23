package com.vunh.repository;

import com.vunh.entity.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, Integer> {
    @Query(value = "SELECT * FROM dich_vu", nativeQuery = true)
    List<DichVu> findAllDichVu();

    @Query(value = "SELECT * FROM dich_vu where id = :id", nativeQuery = true)
    DichVu findDichVuByIdNative(@Param("id") Integer id);
}
