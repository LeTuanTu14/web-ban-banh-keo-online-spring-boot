package com.se.iuh.web_candy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.TaiKhoanRespository;
import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	
	private TaiKhoanRespository taiKhoanRespository;

    @Autowired
    public TaiKhoanServiceImpl(TaiKhoanRespository theTaiKhoanRespository) {
        taiKhoanRespository = theTaiKhoanRespository;
    }

	@Override
	public List<TaiKhoan> getLoaiTaiKhoans() {
		// TODO Auto-generated method stub
		return taiKhoanRespository.findAll();
	}

	@Override
	public void saveTaiKhoan(TaiKhoan theTaiKhoan) {
		// TODO Auto-generated method stub
		taiKhoanRespository.save(theTaiKhoan);
	}

	@Override
	public TaiKhoan getTaiKhoanById(String id) {
		// TODO Auto-generated method stub
		return taiKhoanRespository.getById(id);
	}

	

	@Override
	public void deleteTaiKhoan(String id) {
		// TODO Auto-generated method stub
		taiKhoanRespository.deleteById(id);
	}

	@Override
	public TaiKhoan searchTaiKhoanByKhachHangs(KhachHang theKH) {
		// TODO Auto-generated method stub
		return taiKhoanRespository.findByKhachHang(theKH);
	}

	@Override
	public TaiKhoan getTaiKhoanByTenTK(String ten) {
		// TODO Auto-generated method stub
		return taiKhoanRespository.findByTenTK(ten);
	}

}
