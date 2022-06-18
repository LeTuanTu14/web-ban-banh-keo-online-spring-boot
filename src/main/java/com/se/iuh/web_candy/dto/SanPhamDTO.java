package com.se.iuh.web_candy.dto;

import org.springframework.web.multipart.MultipartFile;

import com.se.iuh.web_candy.entity.LoaiSP;

public class SanPhamDTO {
	
	private int maSP;
	private String tenSP;
	private int soLuong;
	private double donGia;
	private MultipartFile hinhAnh;
	private MultipartFile hinhAnh1;
	private MultipartFile hinhAnh2;
	private MultipartFile hinhAnh3;
	private double khuyenMai;
	private String thongTinSP;
	private int maLoaiSP;
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public MultipartFile getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(MultipartFile hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public MultipartFile getHinhAnh1() {
		return hinhAnh1;
	}
	public void setHinhAnh1(MultipartFile hinhAnh1) {
		this.hinhAnh1 = hinhAnh1;
	}
	public MultipartFile getHinhAnh2() {
		return hinhAnh2;
	}
	public void setHinhAnh2(MultipartFile hinhAnh2) {
		this.hinhAnh2 = hinhAnh2;
	}
	public MultipartFile getHinhAnh3() {
		return hinhAnh3;
	}
	public void setHinhAnh3(MultipartFile hinhAnh3) {
		this.hinhAnh3 = hinhAnh3;
	}
	public double getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(double khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public String getThongTinSP() {
		return thongTinSP;
	}
	public void setThongTinSP(String thongTinSP) {
		this.thongTinSP = thongTinSP;
	}
	public int getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	
	public SanPhamDTO(int maSP, String tenSP, int soLuong, double donGia, MultipartFile hinhAnh, MultipartFile hinhAnh1,
			MultipartFile hinhAnh2, MultipartFile hinhAnh3, double khuyenMai, String thongTinSP, int maLoaiSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.hinhAnh1 = hinhAnh1;
		this.hinhAnh2 = hinhAnh2;
		this.hinhAnh3 = hinhAnh3;
		this.khuyenMai = khuyenMai;
		this.thongTinSP = thongTinSP;
		this.maLoaiSP = maLoaiSP;
	}
	public SanPhamDTO() {
		super();
	}
	
	

}
