package com.se.iuh.web_candy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "khach_hang")
public class KhachHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_khach_hang")
	private int maKH;

	@Column(name = "ten_khach_hang")
	private String tenKH;

	@Column(name = "sdt")
	private String sdt;

	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private List<HoaDonBanHang> hoaDons;

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<HoaDonBanHang> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDonBanHang> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public KhachHang(int maKH, String tenKH, String sdt, String diaChi, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
	}

	public KhachHang(String tenKH, String sdt, String diaChi, String email) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
	}

	public KhachHang() {
		super();
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + ", email="
				+ email + "]";
	}

}
