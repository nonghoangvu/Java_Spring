package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    @Size(max = 255)
    @Column(name = "cccd")
    private String cccd;

    @Size(max = 255)
    @Column(name = "dia_chi")
    private String diaChi;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "ma_khach_hang")
    private String maKhachHang;

    @Size(max = 255)
    @Column(name = "quoc_tinh")
    private String quocTinh;

    @Size(max = 255)
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Size(max = 255)
    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

}