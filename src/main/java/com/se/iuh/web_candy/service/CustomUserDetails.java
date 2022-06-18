package com.se.iuh.web_candy.service;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.se.iuh.web_candy.entity.TaiKhoan;

public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaiKhoan taiKhoan;

	public CustomUserDetails(TaiKhoan theTaiKhoan) {
		super();
		this.taiKhoan = theTaiKhoan;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(taiKhoan.getRole()));
	}

	@Override
	public String getPassword() {
		return taiKhoan.getMatKhau();
	}

	@Override
	public String getUsername() {
		return taiKhoan.getTenTK();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
