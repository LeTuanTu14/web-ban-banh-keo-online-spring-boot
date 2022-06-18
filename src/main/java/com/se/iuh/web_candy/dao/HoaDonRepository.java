package com.se.iuh.web_candy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se.iuh.web_candy.entity.HoaDonBanHang;
import com.se.iuh.web_candy.entity.KhachHang;

public interface HoaDonRepository
		extends JpaRepository<HoaDonBanHang, Integer>, JpaSpecificationExecutor<HoaDonBanHang> {
	@Query(value = "select * from hoa_don_ban_hang s where s.nguoi_nhan like %:keyword% or s.sdt_nguoi_nhan like %:keyword%", nativeQuery = true)
	List<HoaDonBanHang> findByKeyword(@Param("keyword") String keyword);

	@Query(value = "SELECT top 1 * from hoa_don_ban_hang ORDER by ma_hoa_don DESC", nativeQuery = true)
	HoaDonBanHang getHDNew();
}