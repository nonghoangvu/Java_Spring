package com.vunh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "may_tinh")
public class MayTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hang_id")
    private Hang hang;

    @Size(max = 20)
    @Column(name = "ma", length = 20)
    private String ma;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ten_may_tinh", length = 100)
    private String tenMayTinh;

    @Column(name = "gia")
    private Double gia;

    @Size(max = 50)
    @Column(name = "bo_nho", length = 50)
    private String boNho;

    @Size(max = 100)
    @Nationalized
    @Column(name = "mau_sac", length = 100)
    private String mauSac;

    @Size(max = 100)
    @Nationalized
    @Column(name = "mieu_ta", length = 100)
    private String mieuTa;

}