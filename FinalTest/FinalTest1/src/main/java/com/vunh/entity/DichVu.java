package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "dich_vu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "don_gia", precision = 38, scale = 2)
    private BigDecimal donGia;

    @ManyToOne
    @JoinColumn(name = "id_loai_dich_vu")
    private LoaiDichVu idLoaiDichVu;

    @Size(max = 255)
    @Column(name = "don_vi_tien")
    private String donViTien;

    @Size(max = 255)
    @Column(name = "don_vi_tinh")
    private String donViTinh;

    @Size(max = 255)
    @Column(name = "mo_ta")
    private String moTa;

    @Size(max = 255)
    @Column(name = "ten_dich_vu")
    private String tenDichVu;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

}