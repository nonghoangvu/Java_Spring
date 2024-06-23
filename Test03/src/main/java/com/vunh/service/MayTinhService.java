//package com.vunh.service;
//
//import com.vunh.entity.MayTinh;
//import com.vunh.repository.HangRepository;
//import com.vunh.repository.MayTinhRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MayTinhService {
//    @Autowired
//    private MayTinhRepository mayTinhRepository;
//
//    @Autowired
//    private HangRepository hangRepository;
//
//    public Page<MayTinh> getAllMayTinh(Pageable pageable) {
//        return this.mayTinhRepository.findAll(pageable);
//    }
//}
