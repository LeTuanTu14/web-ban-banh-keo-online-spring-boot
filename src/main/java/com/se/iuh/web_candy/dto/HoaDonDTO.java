package com.se.iuh.web_candy.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.se.iuh.web_candy.entity.SanPham;


public class HoaDonDTO {
	
	private int maHD;
	private LocalDate ngayLapDat;
	private LocalDate ngayLapGiao;
	private int tongSoLuong;
	private String sdtNguoiNhan;
	private double tongTien;
	private String ghiChu;
	private String nguoiNhan;
	private String trangThai;
	private List<ChiTietHoaDonDTO> chiTietHoaDons;
	
	
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public LocalDate getNgayLapDat() {
		return ngayLapDat;
	}
	public void setNgayLapDat(LocalDate ngayLapDat) {
		this.ngayLapDat = ngayLapDat;
	}
	public LocalDate getNgayLapGiao() {
		return ngayLapGiao;
	}
	public void setNgayLapGiao(LocalDate ngayLapGiao) {
		this.ngayLapGiao = ngayLapGiao;
	}
	public int getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}
	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNguoiNhan() {
		return nguoiNhan;
	}
	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<ChiTietHoaDonDTO> getChiTietHoaDons() {
		return chiTietHoaDons;
	}
	public void setChiTietHoaDons(List<ChiTietHoaDonDTO> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}
	public HoaDonDTO() {
		super();
		this.chiTietHoaDons = new ArrayList<ChiTietHoaDonDTO>();
	}
	public HoaDonDTO(int maHD, LocalDate ngayLapDat, LocalDate ngayLapGiao, int tongSoLuong, String sdtNguoiNhan,
			double tongTien, String ghiChu, String nguoiNhan, String trangThai, List<ChiTietHoaDonDTO> chiTietHoaDons) {
		super();
		this.maHD = maHD;
		this.ngayLapDat = ngayLapDat;
		this.ngayLapGiao = ngayLapGiao;
		this.tongSoLuong = tongSoLuong;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
		this.nguoiNhan = nguoiNhan;
		this.trangThai = trangThai;
		this.chiTietHoaDons = chiTietHoaDons;
	}
	public boolean themChiTietHoaDonDTO(SanPham sanPham,int sl) {
		int result=0;
		if(sl == 0)
			return false;
		
		for (ChiTietHoaDonDTO chiTietHoaDon : chiTietHoaDons) {
			
			// nếu đã có trong giỏ hàng
			if (chiTietHoaDon.getSanPham().getMaSP()==sanPham.getMaSP()) {

				if (chiTietHoaDon.getSoLuong() > sanPham.getSoLuong())
					return false;
				result=1;
				chiTietHoaDon.setSoLuong(chiTietHoaDon.getSoLuong() + sl);
				chiTietHoaDon.setDonGia(chiTietHoaDon.getSanPham().getDonGia()*chiTietHoaDon.getSoLuong());
				return true;
			}
			
		}
		if(result==0) {
		// chưa có trong giỏ hàng
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
		chiTietHoaDonDTO.setMaHD(this.maHD);
		chiTietHoaDonDTO.setSoLuong(sl);
		chiTietHoaDonDTO.setSanPham(sanPham);
		chiTietHoaDonDTO.setDonGia(sanPham.getDonGia()*sl);
		chiTietHoaDons.add(chiTietHoaDonDTO);
		}
		return true;
		
	}
	
	public boolean xoaChiTietHoaDon(SanPham sanPham) {
		int index = -1;
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDons) {
			if (chiTietHoaDonDTO.getSanPham().getMaSP()==sanPham.getMaSP()) {
				index = chiTietHoaDons.indexOf(chiTietHoaDonDTO);
				break;
			}
		}
		if(index != -1) {
			chiTietHoaDons.remove(index);
			this.setTongTien(this.tinhTongTien());
			this.setTongSoLuong(this.chiTietHoaDons.size());
			return true;
		}else {
			return false;
		}
		
	}
	
	public double tinhTongTien() {
		tongTien=0;
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDons) {
			tongTien +=chiTietHoaDonDTO.getDonGia();
		}
		return tongTien;
	}

	

}
