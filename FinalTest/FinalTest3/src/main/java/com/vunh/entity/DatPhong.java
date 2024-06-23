package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "dat_phong")
public class DatPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "ghi_chu")
    private String ghiChu;

    @NotBlank
    @Size(max = 255)
    @Column(name = "ma_dat_phong")
    private String maDatPhong;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_gio_dat")
    private Date ngayGioDat;

    @NotNull
    @Column(name = "so_luong_khach")
    private Integer soLuongKhach;

    @NotNull
    @Column(name = "so_luong_phong_dat")
    private Integer soLuongPhongDat;

    @Column(name = "thoi_gian_luu_tru")
    private Integer thoiGianLuuTru;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang idKhachHang;

    @Column(name = "id_loai_phong")
    private Integer idLoaiPhong;

}