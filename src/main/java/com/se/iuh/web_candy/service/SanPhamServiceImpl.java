package com.se.iuh.web_candy.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.SanPhamRepository;
import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	private SanPhamRepository sanPhamRespository;

	@Autowired
	public SanPhamServiceImpl(SanPhamRepository theSanPhamRespository) {
		sanPhamRespository = theSanPhamRespository;
	}

	@Override
	public List<SanPham> getSanPhams() {
		// TODO Auto-generated method stub
		return sanPhamRespository.findAll();
	}

	@Override
	public SanPham getSanPhamById(int id) {
		Optional<SanPham> opEm = sanPhamRespository.findById(id);
		SanPham sp = null;
		if (opEm.isPresent()) {
			sp = opEm.get();
		} else {
			throw new RuntimeException("San Pham not found");
		}
		return sp;
	}

	@Override
	public List<SanPham> getSanPhamsByDanhMuc(LoaiSP idDM) {
		return sanPhamRespository.getSanPhamsByDanhMuc(idDM);
	}

	@Override
	public List<SanPham> getMoreSanPhams(int amount) {
		return sanPhamRespository.getMoreSanPhams(amount);
	}

	@Override
	public List<SanPham> getTop12SanPhams() {
		return sanPhamRespository.getTop12SanPhams();
	}

	@Override
	public List<SanPham> getSanPhamsByName(String name) {
		return sanPhamRespository.getSanPhamsByName(name);
	}

	@Override
	public List<SanPham> getSanPhamsKM() {
		// TODO Auto-generated method stub
		return sanPhamRespository.getSanPhamsKM();
	}

	@Override
	public List<SanPham> searchSanPhams(String theSearchName) {
		return sanPhamRespository.findByTenSP(theSearchName);
	}

	@Override
	public void saveSanPham(SanPham theSanPham) {
		sanPhamRespository.save(theSanPham);

	}

	@Override
	public void deleteSanPham(int id) {
		sanPhamRespository.deleteById(id);

	}

	@Override
	public List<SanPham> searchByLoaiSanPhams(LoaiSP loaiSP) {
		return sanPhamRespository.findByMaLoaiSP(loaiSP);
	}

	@Override
	@Transactional
	public void updateSanPhamQty(int maSP, int outQty) {
		SanPham sp = getSanPhamById(maSP);
		int newQty = sp.getSoLuong() - outQty;
		sanPhamRespository.updateSanPhamQty(newQty, maSP);
	}

}
