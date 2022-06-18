package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;

public interface TaiKhoanService {
	public List<TaiKhoan> getLoaiTaiKhoans();
    public void saveTaiKhoan(TaiKhoan theTaiKhoan);
    public TaiKhoan getTaiKhoanById(String id);
    public TaiKhoan getTaiKhoanByTenTK(String ten);
    public TaiKhoan searchTaiKhoanByKhachHangs(KhachHang theKH);
    public void deleteTaiKhoan(String id);
}
