package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.HoaDonBanHang;

public interface HoaDonService {
	public List<HoaDonBanHang> getHoaDons();

	public List<HoaDonBanHang> searchHoaDons(String theSearchSdt);

	public void saveHoaDon(HoaDonBanHang theHoaDon);

	public HoaDonBanHang getHoaDon(int id);

	public void deleteKHoaDon(int id);

	public HoaDonBanHang getHDNew();
}