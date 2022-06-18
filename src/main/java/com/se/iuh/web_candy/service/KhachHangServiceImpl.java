package com.se.iuh.web_candy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.KhachHangRepository;
import com.se.iuh.web_candy.entity.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	private KhachHangRepository khachHangRepository;

	@Autowired
	public KhachHangServiceImpl(KhachHangRepository theKhachHangRepository) {
		khachHangRepository = theKhachHangRepository;
	}
	@Override
	public List<KhachHang> getKhachHangs() {
		return khachHangRepository.findAll();
	}

	@Override
	public List<KhachHang> searchKhachHangs(String keyword) {
		return khachHangRepository.findByKeyword(keyword);
	}

	@Override
	public void saveKhachHang(KhachHang theKhachHang) {
		khachHangRepository.save(theKhachHang);
	}

	@Override
	public KhachHang getKhachHang(int id) {
		return khachHangRepository.getById(id);
	}

	@Override
	public void deleteKhachHang(int id) {
		khachHangRepository.deleteById(id);
	}

}
