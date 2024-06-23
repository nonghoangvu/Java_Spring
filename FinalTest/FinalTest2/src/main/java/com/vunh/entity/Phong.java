package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phong")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_co_so")
    private Integer idCoSo;

    @Column(name = "id_lau")
    private Integer idLau;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_loai_phong")
    private LoaiPhong idLoaiPhong;

    @NotBlank
    @Column(name = "ghi_chu")
    private String ghiChu;

    @NotBlank
    @Column(name = "so_luong_phong")
    private String soLuongPhong;

    @NotBlank
    @Column(name = "ten_phong")
    private String tenPhong;

    @NotBlank
    @Column(name = "trang_thai")
    private String trangThai;

}