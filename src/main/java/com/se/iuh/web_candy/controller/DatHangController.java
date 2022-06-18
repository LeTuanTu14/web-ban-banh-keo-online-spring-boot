package com.se.iuh.web_candy.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.iuh.web_candy.dao.CTHoaDonDAO;
import com.se.iuh.web_candy.dto.ChiTietHoaDonDTO;
import com.se.iuh.web_candy.dto.HoaDonDTO;
import com.se.iuh.web_candy.entity.ChiTietHDBanHang;
import com.se.iuh.web_candy.entity.HoaDonBanHang;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.entity.TaiKhoan;
import com.se.iuh.web_candy.service.CustomUserDetails;
import com.se.iuh.web_candy.service.HoaDonService;
import com.se.iuh.web_candy.service.KhachHangService;
import com.se.iuh.web_candy.service.SanPhamService;
import com.se.iuh.web_candy.service.TaiKhoanService;

@Controller
@RequestMapping("dathang")
public class DatHangController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private TaiKhoanService taiKhoanService;

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private CTHoaDonDAO chitiethoadonDAO;

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("")
	public String dathang(Model model, HttpSession httpSession) {
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("myCartItems");
		if (hoaDonDTO == null) {
			return "redirect:/shop";
		}
		List<ChiTietHoaDonDTO> mapCTHD = new ArrayList<ChiTietHoaDonDTO>();
		hoaDonDTO.getChiTietHoaDons().forEach(cthd -> {
			int maSP = cthd.getSanPham().getMaSP();
			SanPham sp = sanPhamService.getSanPhamById(maSP);

			mapCTHD.add(cthd);
		});

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user = ((CustomUserDetails) pricipal).getUsername();

		TaiKhoan tk = taiKhoanService.getTaiKhoanByTenTK(user);

		HoaDonBanHang hd = new HoaDonBanHang();
		hd.setNguoiNhan(tk.getKhachHang().getTenKH());
		hd.setSdtNguoiNhan(tk.getKhachHang().getSdt());
		model.addAttribute("hoadon", hd);
		model.addAttribute("hd", hoaDonDTO);
		model.addAttribute("map", mapCTHD);
		return "checkout";
	}

	@PostMapping("/dangky")
	public String dangky(@ModelAttribute("hoadon") HoaDonBanHang hdbh, Model model, HttpSession httpSession) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			return "redirect:/shop";
		}
		List<ChiTietHoaDonDTO> mapCTHD = new ArrayList<ChiTietHoaDonDTO>();
		hoaDonDTO.getChiTietHoaDons().forEach(cthd -> {
			mapCTHD.add(cthd);
		});

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user = ((CustomUserDetails) pricipal).getUsername();

		TaiKhoan tk = taiKhoanService.getTaiKhoanByTenTK(user);

		HoaDonBanHang hdon = new HoaDonBanHang();
		hdon.setKhachHang(tk.getKhachHang());
		hoaDonService.saveHoaDon(hdon);

		int vt = 0;
		int mhd = 0;
		List<HoaDonBanHang> lhd = hoaDonService.getHoaDons();
		for (int i = 0; i < lhd.size(); i++) {
			if (lhd.get(i).getTongSoLuong() == 0) {
				vt = i;
				mhd = lhd.get(i).getMaHD();
			}

		}

		for (int i = 0; i < mapCTHD.size(); i++) {

			SanPham sp = mapCTHD.get(i).getSanPham();
			if (sp.getSoLuong() < mapCTHD.get(i).getSoLuong())
				return "redirect:/shop";
			ChiTietHDBanHang ct = new ChiTietHDBanHang(mapCTHD.get(i).getSoLuong(), mapCTHD.get(i).getDonGia(),
					lhd.get(vt), sanPhamService.getSanPhamById(sp.getMaSP()));
			chitiethoadonDAO.save(ct);
			sp.setSoLuong(sp.getSoLuong() - ct.getSoLuong());
			sanPhamService.saveSanPham(sp);
		}

		HoaDonBanHang hdd = hoaDonService.getHoaDon(mhd);
		hdd.setGhiChu(hdbh.getGhiChu());
		hdd.setNgayLapDat(LocalDate.now());
		hdd.setNgayLapGiao(LocalDate.now());
		hdd.setNguoiNhan(hdbh.getNguoiNhan());
		hdd.setSdtNguoiNhan(hdbh.getSdtNguoiNhan());
		hdd.setTongSoLuong(hoaDonDTO.getTongSoLuong());
		hdd.setTongTien(hoaDonDTO.getTongTien());
		hdd.setTrangThai("Chờ xử lý");

		hoaDonService.saveHoaDon(hdd);

		httpSession.removeAttribute("hoaDonDTO");

		return "redirect:/shop";
	}

}
