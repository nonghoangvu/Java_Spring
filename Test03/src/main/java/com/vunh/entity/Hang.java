//package com.vunh.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.Nationalized;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "hang")
//public class Hang {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Size(max = 20)
//    @Column(name = "ma", length = 20)
//    private String ma;
//
//    @Size(max = 100)
//    @Nationalized
//    @Column(name = "ten_hang", length = 100)
//    private String tenHang;
//
//}