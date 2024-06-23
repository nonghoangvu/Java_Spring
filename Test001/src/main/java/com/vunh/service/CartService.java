package com.vunh.service;

import com.vunh.entity.GioHang;
import com.vunh.entity.KhachHang;
import com.vunh.repository.GioHangRepository;
import com.vunh.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private GioHangRepository gioHangRepository;

    public List<KhachHang> getKhachHang() {
        return khachHangRepository.findAll();
    }

    public List<GioHang> getAllGioHang() {
        return this.gioHangRepository.findAll();
    }
}
