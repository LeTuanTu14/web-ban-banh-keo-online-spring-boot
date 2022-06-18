package com.se.iuh.web_candy.dao;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiSPRepository extends JpaRepository<LoaiSP, Integer> {
    public List<LoaiSP> findByTenLoaiSP(String tenLSP);

}
