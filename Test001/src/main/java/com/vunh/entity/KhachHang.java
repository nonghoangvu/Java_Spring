package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhachHang", nullable = false)
    private Long id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenKhachHang", length = 50)
    private String tenKhachHang;

    @Column(name = "SinhNhat")
    private LocalDate sinhNhat;

    @Nationalized
    @Lob
    @Column(name = "DiaChi")
    private String diaChi;

    @Size(max = 15)
    @Column(name = "SoDienThoai", length = 15)
    private String soDienThoai;

    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Size(max = 15)
    @Column(name = "ChungMinhThu", length = 15)
    private String chungMinhThu;

    @Size(max = 15)
    @Column(name = "SoCanCuoc", length = 15)
    private String soCanCuoc;

    @Size(max = 50)
    @Column(name = "AnhDaiDien", length = 50)
    private String anhDaiDien;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ColumnDefault("0")
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy;

}