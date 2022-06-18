package com.se.iuh.web_candy.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

@RestController
@RequestMapping("api")
public class SanPhamRestController {

	private SanPhamService sanPhamService;

	@Autowired
	public SanPhamRestController(SanPhamService theSanPhamService) {
		sanPhamService = theSanPhamService;
	}

	@GetMapping("/sanphams")
	public List<SanPham> listSanPhams() {
		return sanPhamService.getSanPhams();
	}

	@GetMapping("/sale")
	public List<SanPham> listSle() {
		return sanPhamService.getSanPhamsKM();
	}

	@GetMapping("/sanpham/{id}")
	public SanPham getSPById(@PathVariable int id) throws Exception {
		SanPham sp = sanPhamService.getSanPhamById(id);
		if ((id < 0) || sp == null) {
			throw new RuntimeException("San Pham not found");
		}
		return sp;
	}

	@GetMapping("/sanphamsDM/{id}")
	public List<SanPham> listSanPhamWithDM(@PathVariable LoaiSP id) throws Exception {
		List<SanPham> listsp = new ArrayList<>();
		listsp = sanPhamService.getSanPhamsByDanhMuc(id);
		return listsp;
	}

	@GetMapping("/moresanphams/{amount}")
	public List<SanPham> listMoresanPhams(@PathVariable int amount) throws Exception {
		List<SanPham> listMoresp = new ArrayList<>();
		listMoresp = sanPhamService.getMoreSanPhams(amount);
		return listMoresp;
	}

	@GetMapping("/top12sanphams")
	public List<SanPham> listTop12sanPhams() throws Exception {
		List<SanPham> listTop12sp = new ArrayList<>();
		listTop12sp = sanPhamService.getTop12SanPhams();
		return listTop12sp;
	}

	@GetMapping("/sanphamsName/{name}")
	public List<SanPham> listSanPhamsByName(@PathVariable String name) throws Exception {
		List<SanPham> listsp = new ArrayList<>();
		listsp = sanPhamService.getSanPhamsByName("%" + name + "%");
		return listsp;
	}

}
