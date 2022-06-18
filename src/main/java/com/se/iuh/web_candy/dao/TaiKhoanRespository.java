package com.se.iuh.web_candy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;

@Repository
public interface TaiKhoanRespository extends JpaRepository<TaiKhoan, String>{
	TaiKhoan findByKhachHang(KhachHang khachHang);
	
	TaiKhoan findByTenTK(String username);
}
