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

import com.se.iuh.web_candy.dao.HoaDonDAO;
import com.se.iuh.web_candy.entity.HoaDonBanHang;

// http://localhost:8080/api/employees
@RestController
@RequestMapping("api")
public class HoaDonRestController {
	private HoaDonDAO hoadonDAO;

	@Autowired
	public HoaDonRestController(@Qualifier("hoaDonDAOJpaImpl") HoaDonDAO thehoaDonDAO) {
		hoadonDAO = thehoaDonDAO;
	};

	@GetMapping("/hoadonbanhangs")
	public List<HoaDonBanHang> findAll() {
		return hoadonDAO.findAll();
	}

	@GetMapping("/hoadonbanhangs/{hoadonId}")
	public HoaDonBanHang getHoaDon(@PathVariable int hoadonId) {
		return hoadonDAO.findById(hoadonId)
				.orElseThrow(() -> new RuntimeException("Employee id not found - " + hoadonId));
	}

	
	@PostMapping("/hoadonbanhangs")
	public HoaDonBanHang addHoaDon(@RequestBody HoaDonBanHang theHoaDon) {
		theHoaDon.setMaHD(0);
		hoadonDAO.save(theHoaDon);
		return theHoaDon;
	}
	
	//add mapping for PUT /hoadon - update existing hoadon
	@PutMapping("/hoadonbanhangs")
	public HoaDonBanHang updateHoaDon(@RequestBody HoaDonBanHang theHoaDon) {
		hoadonDAO.save(theHoaDon);
		return theHoaDon;
	}
	
	
	//add mapping for DELETE /employee/{employeeId} - delete empolyess
		@DeleteMapping("/hoadonbanhangs/{hoadonId}")
		public void deteleHoaDon(@PathVariable int hoadonId) {
			hoadonDAO.findById(hoadonId)
					.map(order -> {
						hoadonDAO.deteleById(order.getMaHD());
						return order;
					})
					.orElseThrow(() -> new RuntimeException("Employee id not found - " + hoadonId));
		}
		
}
