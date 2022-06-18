package com.se.iuh.web_candy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.se.iuh.web_candy.dao.TaiKhoanRespository;
import com.se.iuh.web_candy.dto.TaiKhoanDTO;
import com.se.iuh.web_candy.entity.KhachHang;
import com.se.iuh.web_candy.entity.TaiKhoan;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private TaiKhoanRespository taiKhoanRespository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = taiKhoanRespository.findByTenTK(username);
		if (taiKhoan == null) {
			System.out.println("User not found! " + taiKhoan);
			throw new UsernameNotFoundException("Không tìm thấy tài khoản này!");
		}
		return new CustomUserDetails(taiKhoan);
	}

	public TaiKhoan save(TaiKhoanDTO user) throws Exception {
		if (checkIfUserExist(user.getTenTK())) {
			throw new Exception("User already exists for this email");
		} else {
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setTenTK(user.getTenTK());
			taiKhoan.setMatKhau(passwordEncoder().encode(user.getMatKhau()));
			taiKhoan.setRole("USER");
			taiKhoan.setKhachHang(new KhachHang(user.getTenKH(), user.getSdt(), user.getDiaChi(), user.getEmail()));
			return taiKhoanRespository.save(taiKhoan);
		}
	}

	public boolean checkIfUserExist(String tenTK) {
		return taiKhoanRespository.findByTenTK(tenTK) != null ? true : false;
	}
}
