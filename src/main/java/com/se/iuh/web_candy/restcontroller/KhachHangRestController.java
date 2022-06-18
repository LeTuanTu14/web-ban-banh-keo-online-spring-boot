package com.se.iuh.web_candy.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;
import com.se.iuh.web_candy.service.KhachHangService;
import com.se.iuh.web_candy.service.TaiKhoanService;

@RestController()
@RequestMapping("api")
public class KhachHangRestController {
	private TaiKhoanService tkService;
	private KhachHangService khachHangService;
	private List<KhachHang> theKhachHangs;
	@Autowired
	public KhachHangRestController(KhachHangService theKhachHangService,TaiKhoanService thetkService) {
		khachHangService = theKhachHangService;
		tkService=thetkService;
	}
	@GetMapping("/khachhangs")
	public List<KhachHang> listKhachHang(){
		return khachHangService.getKhachHangs();
	}
	@GetMapping("/khachhangs/{ten}")
	public List<KhachHang> listKhachHang(@PathVariable String ten){
		return khachHangService.searchKhachHangs(ten);
	}
	
	@GetMapping("/khachhangs/taikhoan")
	public TaiKhoan listKhachHangg(){
		KhachHang kh= khachHangService.getKhachHang(1);
		return tkService.searchTaiKhoanByKhachHangs(kh);
	}
}
