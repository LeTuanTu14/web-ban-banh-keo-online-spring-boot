package com.se.iuh.web_candy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.iuh.web_candy.dto.ChiTietHoaDonDTO;
import com.se.iuh.web_candy.dto.HoaDonDTO;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

@Controller
@RequestMapping("giohang")
public class GioHangController {

	@Autowired
	private SanPhamService sanPhamService;

	@GetMapping("")
	public String showGioHang(Model model, HttpSession httpSession) {
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		List<ChiTietHoaDonDTO> mapCTHD = new ArrayList<ChiTietHoaDonDTO>();
		hoaDonDTO.getChiTietHoaDons().forEach(cthd -> {
			int maSP = cthd.getSanPham().getMaSP();
			SanPham sp = sanPhamService.getSanPhamById(maSP);

			mapCTHD.add(cthd);
		});
		model.addAttribute("hd", hoaDonDTO);
		model.addAttribute("map", mapCTHD);
		return "shopingcart";
	}

	@GetMapping("/themvaogiohang")
	public String themVaoGioHang(@RequestParam("maSP") int ma, @RequestParam("sl") int sl, HttpSession httpSession) {
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		SanPham sp = sanPhamService.getSanPhamById(ma);
		if (sl <= sp.getSoLuong())
			hoaDonDTO.themChiTietHoaDonDTO(sp, sl);
		hoaDonDTO.setTongTien(hoaDonDTO.tinhTongTien());
		hoaDonDTO.setTongSoLuong(hoaDonDTO.getChiTietHoaDons().size());
		return "redirect:/giohang";
	}

	@GetMapping("/themvaogiohang1")
	public String themVaoGioHang1(@RequestParam("maSP") int ma, HttpSession httpSession) {
		int sl = 1;
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		SanPham sp = sanPhamService.getSanPhamById(ma);
		if (sl <= sp.getSoLuong())
			hoaDonDTO.themChiTietHoaDonDTO(sp, sl);
		hoaDonDTO.setTongTien(hoaDonDTO.tinhTongTien());
		hoaDonDTO.setTongSoLuong(hoaDonDTO.getChiTietHoaDons().size());
		return "redirect:/giohang";
	}

	@GetMapping("/xoasanphamkhoigiohang")
	public String xoaSanPhamKhoiGioHang(@RequestParam("maSP") int ma, HttpSession httpSession) {
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		SanPham sp = sanPhamService.getSanPhamById(ma);
		hoaDonDTO.xoaChiTietHoaDon(sp);
		hoaDonDTO.setTongTien(hoaDonDTO.tinhTongTien());
		return "redirect:/giohang";
	}

}
