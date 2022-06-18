package com.se.iuh.web_candy.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quyen")
public class Quyen implements Serializable{
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	private TaiKhoan tenTaiKhoan;
	
	@Column(name="role")
	private String role;

	

	public TaiKhoan getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(TaiKhoan tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Quyen(TaiKhoan tenTaiKhoan, String role) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.role = role;
	}

	public Quyen() {
		super();
	}
	
	
	
}
