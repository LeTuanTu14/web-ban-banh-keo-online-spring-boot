package com.se.iuh.web_candy.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.iuh.web_candy.dao.CTHoaDonDAO;
import com.se.iuh.web_candy.entity.ChiTietHDBanHang;

@RestController
@RequestMapping("api")
public class CTHoaDonRestController {
	private CTHoaDonDAO chitiethoadonDAO;

	@Autowired
	public CTHoaDonRestController(CTHoaDonDAO theCThoaDonDAO) {
		chitiethoadonDAO = theCThoaDonDAO;
	};

	@GetMapping("/chitiethoadons")
	public List<ChiTietHDBanHang> findAll() {
		return chitiethoadonDAO.findAll();
	}

//	@GetMapping("/chitiethoadons/{chitiethoadonId}")
//	public ChiTietHDBanHang getCTHoaDon(@PathVariable int chitiethoadonId) {
//		return chitiethoadonDAO.
//				.orElseThrow(() -> new RuntimeException("Employee id not found - " + chitiethoadonId));
//	}

	
//	@PostMapping("/chitiethoadons")
//	public ChiTietHDBanHang addHoaDon(@RequestBody ChiTietHDBanHang theCTHoaDon) {
//		theCTHoaDon.setMaHD(null);
//		chitiethoadonDAO.save(theCTHoaDon);
//		return theCTHoaDon;
//	}
//	
//	//add mapping for PUT /hoadon - update existing hoadon
//	@PutMapping("/chitiethoadons")
//	public ChiTietHDBanHang updateCTHoaDon(@RequestBody ChiTietHDBanHang theHoaDon) {
//		chitiethoadonDAO.save(theHoaDon);
//		return theHoaDon;
//	}
	
	
	
	//add mapping for DELETE /employee/{employeeId} - delete empolyess
//		@DeleteMapping("/hoadonbanhangs/{chitiethoadonId}")
//		public void deteleCTHoaDon(@PathVariable int chitiethoadonId) {
//			chitiethoadonDAO.findById(chitiethoadonId)
//					.map(order -> {
//						chitiethoadonDAO.deteleById(chitiethoadonId);//deteleById(order.getMaHD());
//						return order;
//					})
//					.orElseThrow(() -> new RuntimeException("Employee id not found - " + chitiethoadonId));
//		}
		
}
