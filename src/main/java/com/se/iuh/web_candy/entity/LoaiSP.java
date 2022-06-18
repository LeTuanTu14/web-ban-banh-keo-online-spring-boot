package com.se.iuh.web_candy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc_san_pham")
public class LoaiSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_san_pham")
    private int maLoaiSP;

    @Column(name = "ten_loai_san_pham")
    private String tenLoaiSP;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    public LoaiSP() {
    }

    public LoaiSP(int maLoaiSP, String tenLoaiSP, String hinhAnh) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
        this.hinhAnh = hinhAnh;
    }

    public LoaiSP(int maLoaiSP, String tenLoaiSP) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
    }

    public LoaiSP(int maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public LoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public int getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(int maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "LoaiSP [hinhAnh=" + hinhAnh + ", maLoaiSP=" + maLoaiSP + ", tenLoaiSP=" + tenLoaiSP + "]";
    }

}
