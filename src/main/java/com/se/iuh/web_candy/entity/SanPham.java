package com.se.iuh.web_candy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "san_pham")
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_san_pham")
	private int maSP;

	@Column(name = "ten_san_pham")
	private String tenSP;

	@Column(name = "so_luong")
	private int soLuong;

	@Column(name = "don_gia")
	private double donGia;

	@Column(name = "hinh_anh")
	private String hinhAnh;

	@Column(name = "hinh_anh1")
	private String hinhAnh1;

	@Column(name = "hinh_anh2")
	private String hinhAnh2;

	@Column(name = "hinh_anh3")
	private String hinhAnh3;

	@Column(name = "khuyen_mai")
	private double khuyenMai;

	@Column(name = "thong_tin_san_pham")
	private String thongTinSP;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_loai_san_pham")
	private LoaiSP maLoaiSP;

	public String getHinhAnh1() {
		return hinhAnh1;
	}

	public void setHinhAnh1(String hinhAnh1) {
		this.hinhAnh1 = hinhAnh1;
	}

	public String getHinhAnh2() {
		return hinhAnh2;
	}

	public void setHinhAnh2(String hinhAnh2) {
		this.hinhAnh2 = hinhAnh2;
	}

	public String getHinhAnh3() {
		return hinhAnh3;
	}

	public void setHinhAnh3(String hinhAnh3) {
		this.hinhAnh3 = hinhAnh3;
	}

	public LoaiSP getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(LoaiSP maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

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
		if(khuyenMai > 0) {
			return donGia * (1 - khuyenMai);
		}
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
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

	public SanPham(int maSP, String tenSP, int soLuong, double donGia, String hinhAnh, String hinhAnh1, String hinhAnh2,
			String hinhAnh3, double khuyenMai, String thongTinSP, LoaiSP maLoaiSP) {
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

	public SanPham() {
		super();
	}

	public SanPham(int maSP) {
		this.maSP = maSP;
	}

	@Override
	public String toString() {
		return "SanPham [donGia=" + donGia + ", hinhAnh=" + hinhAnh + ", hinhAnh1=" + hinhAnh1 + ", hinhAnh2="
				+ hinhAnh2 + ", hinhAnh3=" + hinhAnh3 + ", khuyenMai=" + khuyenMai + ", maLoaiSP=" + maLoaiSP
				+ ", maSP=" + maSP + ", soLuong=" + soLuong + ", tenSP=" + tenSP + ", thongTinSP=" + thongTinSP + "]";
	}

}
