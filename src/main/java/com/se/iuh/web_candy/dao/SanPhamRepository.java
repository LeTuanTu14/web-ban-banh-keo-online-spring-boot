package com.se.iuh.web_candy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query("SELECT sp from SanPham sp where sp.maLoaiSP = ?1")
    List<SanPham> getSanPhamsByDanhMuc(LoaiSP idDM);

    @Query(value = "SELECT * from san_pham  ORDER BY ma_san_pham offset ?1 rows fetch next 12 rows ONLY", nativeQuery = true)
    List<SanPham> getMoreSanPhams(int amount);

    @Query(value = "SELECT top 12 * from [san_pham]  ORDER BY ma_san_pham", nativeQuery = true)
    List<SanPham> getTop12SanPhams();

    @Query(value = "SELECT * from [san_pham] where ten_san_pham like ?1 ORDER BY ma_san_pham", nativeQuery = true)
    List<SanPham> getSanPhamsByName(String name);

    @Query(value = "SELECT * from san_pham where khuyen_mai>0;", nativeQuery = true)
    List<SanPham> getSanPhamsKM();

    public List<SanPham> findByTenSP(String tenSP);

    public List<SanPham> findByMaLoaiSP(LoaiSP loaiSP);

    @Query(value = "UPDATE san_pham SET  so_luong = ?1  WHERE ma_san_pham = ?2", nativeQuery = true)
    public void updateSanPhamQty(int maSP, int outQty);
}
