package com.vunh.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGioHang", nullable = false)
    private Long id;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayCapNhap")
    private LocalDate ngayCapNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang nguoiSoHuu;

    @Nationalized
    @Lob
    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

}