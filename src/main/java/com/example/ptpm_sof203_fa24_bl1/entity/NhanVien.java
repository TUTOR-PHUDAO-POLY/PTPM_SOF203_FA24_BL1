package com.example.ptpm_sof203_fa24_bl1.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder // contructor tuy y tham so
public class NhanVien {
    // mapping
    private int id;

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private String gioiTinh;

    private Date ngaySinh;

    private String diaChi;

    private String sdt;

    private String matKhau;

    private int idCH;

    private int idCV;

    private int idGuiBC;

    private int trangThai;

}
