package com.se.iuh.web_candy.dao;

import java.util.List;
import java.util.Optional;

import com.se.iuh.web_candy.entity.HoaDonBanHang;

public interface HoaDonDAO {
	public List<HoaDonBanHang> findAll();
	public Optional<HoaDonBanHang> findById(int theId);
	public void save(HoaDonBanHang theHoaDon);
	public void deteleById(int theId);

}
