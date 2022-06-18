package com.se.iuh.web_candy.service;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;

public interface SanPhamService {
	public List<SanPham> getSanPhams();

	public SanPham getSanPhamById(int id);

	public List<SanPham> getSanPhamsByDanhMuc(LoaiSP idDM);

	public List<SanPham> getMoreSanPhams(int amount);

	public List<SanPham> getTop12SanPhams();

	public List<SanPham> getSanPhamsByName(String name);

	public List<SanPham> getSanPhamsKM();

	public List<SanPham> searchSanPhams(String theSearchName);

	public void saveSanPham(SanPham theSanPham);

	public void deleteSanPham(int id);

	public List<SanPham> searchByLoaiSanPhams(LoaiSP loaiSP);

	public void updateSanPhamQty(int maSP, int outQty);

}
