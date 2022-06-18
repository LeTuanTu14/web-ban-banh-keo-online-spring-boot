package com.se.iuh.web_candy.dao;

import java.util.List;
import java.util.Optional;

import com.se.iuh.web_candy.entity.ChiTietHDBanHang;
public interface CTHoaDonDAO {
	public List<ChiTietHDBanHang> findAll();
	public Optional<ChiTietHDBanHang> findById(int theId);
	public void save(ChiTietHDBanHang theCTHoaDon);
	public void deteleById(int theId);
}
