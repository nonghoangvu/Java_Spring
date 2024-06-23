package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_dich_vu")
public class LoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "mo_ta")
    private String moTa;

    @Size(max = 255)
    @Column(name = "ten_loai_dich_vu")
    private String tenLoaiDichVu;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

}