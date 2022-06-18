package com.se.iuh.web_candy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.HoaDonRepository;
import com.se.iuh.web_candy.entity.HoaDonBanHang;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	private HoaDonRepository hoaDonRepository;

	public HoaDonServiceImpl(HoaDonRepository theHoaDonRepository) {
		hoaDonRepository = theHoaDonRepository;
	}

	@Override
	public List<HoaDonBanHang> getHoaDons() {
		return hoaDonRepository.findAll();
	}

	@Override
	public List<HoaDonBanHang> searchHoaDons(String keyword) {
		return hoaDonRepository.findByKeyword(keyword);
	}

	@Override
	public void saveHoaDon(HoaDonBanHang theHoaDon) {
		hoaDonRepository.save(theHoaDon);

	}

	@Override
	public HoaDonBanHang getHoaDon(int id) {

		return hoaDonRepository.getById(id);
	}

	@Override
	public void deleteKHoaDon(int id) {
		hoaDonRepository.deleteById(id);

	}

	@Override
	public HoaDonBanHang getHDNew() {
		// TODO Auto-generated method stub
		return hoaDonRepository.getHDNew();
	}

}
