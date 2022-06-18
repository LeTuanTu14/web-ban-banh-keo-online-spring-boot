package com.se.iuh.web_candy.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.se.iuh.web_candy.dto.SanPhamDTO;

@Component
public class SanPhamDTOValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return SanPhamDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		SanPhamDTO spDTO= (SanPhamDTO) target;
		
		if (spDTO.getTenSP().trim().equals("")) {
			errors.rejectValue("tenSP", null, "Tên sản phẩm không được bỏ trống");
		}
		if (spDTO.getHinhAnh().getOriginalFilename().equals("")) {
			errors.rejectValue("hinhAnh", null, "Ảnh sản phẩm không được bỏ trống");
		}
//		if (spDTO.getHinhAnh1().getOriginalFilename().equals("")) {
//			errors.rejectValue("hinhAnh1", null, "Ảnh sản phẩm không được bỏ trống");
//		}
//		if (spDTO.getHinhAnh2().getOriginalFilename().equals("")) {
//			errors.rejectValue("hinhAnh2", null, "Ảnh sản phẩm không được bỏ trống");
//		}
//		if (spDTO.getHinhAnh3().getOriginalFilename().equals("")) {
//			errors.rejectValue("hinhAnh3", null, "Ảnh sản phẩm không được bỏ trống");
//		}
		if (spDTO.getThongTinSP().trim().equals("")) {
			errors.rejectValue("thongTinSP", null, "Thông tin sản phẩm không được bỏ trống");
		}
		if (spDTO.getDonGia() <= 0) {
			errors.rejectValue("donGia", null, "Đơn giá không hợp lệ");
		}
		if (spDTO.getSoLuong() <= 0) {
			errors.rejectValue("soLuong", null, "Số lượng không hợp lệ");
		}
		if (spDTO.getKhuyenMai() < 0) {
			errors.rejectValue("khuyenMai", null, "Khuyến mãi không hợp lệ");
		}
	}

}
