package com.vunh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private String hoTen;
    private String sdt;
    private String hang;
    private Boolean trangThai;
}
