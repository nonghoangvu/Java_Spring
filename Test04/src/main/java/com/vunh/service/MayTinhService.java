package com.vunh.service;

import com.vunh.entity.Hang;
import com.vunh.entity.MayTinh;
import com.vunh.repository.HangRepository;
import com.vunh.repository.MayTinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayTinhService {
    @Autowired
    private MayTinhRepository mayTinhRepository;

    @Autowired
    private HangRepository hangRepository;

    public Page<MayTinh> getAllMayTinh(Pageable pageable) {
        return this.mayTinhRepository.findAll(pageable);
    }

    public void delete(Integer id) {
        this.mayTinhRepository.deleteById(id);
    }

    public MayTinh findById(Integer id) {
        return this.mayTinhRepository.findById(id).orElse(null);
    }

    public List<Hang> getAllHang() {
        return this.hangRepository.findAll();
    }

    public void update(MayTinh mayTinh) {
        this.mayTinhRepository.save(mayTinh);
    }
}
