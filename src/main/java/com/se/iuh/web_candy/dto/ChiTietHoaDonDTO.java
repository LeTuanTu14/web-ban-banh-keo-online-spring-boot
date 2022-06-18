package com.se.iuh.web_candy.dto;

import com.se.iuh.web_candy.entity.SanPham;

public class ChiTietHoaDonDTO {
	private int soLuong;
	private double donGia;
	private int maHD;
	private SanPham sanPham;
	
	
	
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
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public ChiTietHoaDonDTO(int soLuong, double donGia, int maHD, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maHD = maHD;
		this.sanPham = sanPham;
	}
	public ChiTietHoaDonDTO() {
		super();
	}
	
	public double tinhTien() {
		donGia=soLuong * sanPham.getDonGia();
		return donGia;
	}

}
