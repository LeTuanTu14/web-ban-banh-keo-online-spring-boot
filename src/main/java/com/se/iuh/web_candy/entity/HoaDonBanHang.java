package com.se.iuh.web_candy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "hoa_don_ban_hang")
public class HoaDonBanHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_hoa_don")
	private int maHD;

	@Column(name = "ngay_lap_dat")
	private LocalDate ngayLapDat;

	@Column(name = "ngay_lap_giao")
	private LocalDate ngayLapGiao;

	@Column(name = "tong_so_luong")
	private int tongSoLuong;

	@Column(name = "sdt_nguoi_nhan")
	private String sdtNguoiNhan;

	@Column(name = "tong_tien")
	private double tongTien;

	@Column(name = "ghi_chu")
	private String ghiChu;

	@Column(name = "nguo_nhan")
	private String nguoiNhan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_khach_hang")
	private KhachHang khachHang;

	@Column(name = "trang_thai")
	private String trangThai;

	@OneToMany(mappedBy = "maHD", cascade = CascadeType.ALL)
	private List<ChiTietHDBanHang> chiTietHoaDons;

	public double tinhTongTien() {
		tongTien = 0;
		for (ChiTietHDBanHang chiTietHoaDon : chiTietHoaDons) {
			tongTien += chiTietHoaDon.tinhTien();
		}

		return tongTien;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayLapDat() {
		return ngayLapDat;
	}

	public void setNgayLapDat(LocalDate ngayLapDat) {
		this.ngayLapDat = ngayLapDat;
	}

	public LocalDate getNgayLapGiao() {
		return ngayLapGiao;
	}

	public void setNgayLapGiao(LocalDate ngayLapGiao) {
		this.ngayLapGiao = ngayLapGiao;
	}

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}

	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<ChiTietHDBanHang> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHDBanHang> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public HoaDonBanHang(int maHD, LocalDate ngayLapDat, LocalDate ngayLapGiao, int tongSoLuong, String sdtNguoiNhan,
			double tongTien, String ghiChu, String nguoiNhan, KhachHang khachHang, String trangThai,
			List<ChiTietHDBanHang> chiTietHoaDons) {
		super();
		this.maHD = maHD;
		this.ngayLapDat = ngayLapDat;
		this.ngayLapGiao = ngayLapGiao;
		this.tongSoLuong = tongSoLuong;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
		this.nguoiNhan = nguoiNhan;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public HoaDonBanHang() {
		super();
	}

}
