package com.se.iuh.web_candy.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.se.iuh.web_candy.entity.LoaiSP;

@Component
public class LoaiSPValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoaiSP.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		LoaiSP loaiSP= (LoaiSP) target;
		
		if (loaiSP.getTenLoaiSP().trim().equals("")) {
			errors.rejectValue("tenLoaiSP", null, "Tên loại sản phẩm không được bỏ trống");
		}
	}

}
