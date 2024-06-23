package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "loai_phong")
public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "don_gia_qua_dem", precision = 38, scale = 2)
    private BigDecimal donGiaQuaDem;

    @Column(name = "don_gia_theo_gio", precision = 38, scale = 2)
    private BigDecimal donGiaTheoGio;

    @Size(max = 255)
    @Nationalized
    @Column(name = "ho_ten_nguoi_dai_dien")
    private String hoTenNguoiDaiDien;

    @Column(name = "tien_qua_gio", precision = 38, scale = 2)
    private BigDecimal tienQuaGio;

    @Size(max = 255)
    @Column(name = "ghi_chu")
    private String ghiChu;

    @Size(max = 255)
    @Column(name = "so_nguoi")
    private String soNguoi;

    @Size(max = 255)
    @Column(name = "ten_loai_phong")
    private String tenLoaiPhong;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

}