package com.se.iuh.web_candy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ct_hoa_don_ban_hang")
public class ChiTietHDBanHang implements Serializable{
	
	@Column(name = "so_luong")
	private int soLuong;
	
	@Column(name = "don_gia")
	private double donGia;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_hoa_don")
	private HoaDonBanHang maHD;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_san_pham")
	private SanPham sanPham;
	
	
	public double tinhTien() {
		donGia= soLuong* sanPham.getDonGia() ;
		return donGia;
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


	public HoaDonBanHang getMaHD() {
		return maHD;
	}


	public void setMaHD(HoaDonBanHang maHD) {
		this.maHD = maHD;
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public ChiTietHDBanHang(int soLuong, double donGia, HoaDonBanHang maHD, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maHD = maHD;
		this.sanPham = sanPham;
	}


	public ChiTietHDBanHang() {
		super();
	}
	
	
}
