package com.se.iuh.web_candy.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class TaiKhoanDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Tên tài khoản không được để trống!")
	private String tenTK;
	@NotEmpty(message = "First name can not be empty")
	private String matKhau;
	@NotEmpty(message = "First name can not be empty")
	private String xacNhanMatKhau;
	@NotEmpty(message = "First name can not be empty")
	private String role;
	@NotEmpty(message = "First name can not be empty")
	private String tenKH;
	@NotEmpty(message = "First name can not be empty")
	private String sdt;
	@NotEmpty(message = "First name can not be empty")
	private String diaChi;
	@NotEmpty(message = "First name can not be empty")
	private String email;
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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
	public String getXacNhanMatKhau() {
		return xacNhanMatKhau;
	}
	public void setXacNhanMatKhau(String xacNhanMatKhau) {
		this.xacNhanMatKhau = xacNhanMatKhau;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	
}
