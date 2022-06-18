package com.se.iuh.web_candy.service;

import java.util.List;
import com.se.iuh.web_candy.entity.KhachHang;

public interface KhachHangService {
	public List<KhachHang> getKhachHangs();
	public List<KhachHang> searchKhachHangs(String theSearchSdt);
	public void saveKhachHang(KhachHang theKhachHang);
    public KhachHang getKhachHang(int id);
    public void deleteKhachHang(int id);
}
