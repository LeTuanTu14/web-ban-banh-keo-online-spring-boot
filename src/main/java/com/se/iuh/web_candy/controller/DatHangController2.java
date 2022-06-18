package com.se.iuh.web_candy.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.se.iuh.web_candy.dao.CTHoaDonDAO;
import com.se.iuh.web_candy.dao.SanPhamDAO;
import com.se.iuh.web_candy.dto.ChiTietHoaDonDTO;
import com.se.iuh.web_candy.entity.Cart;
import com.se.iuh.web_candy.entity.ChiTietHDBanHang;
import com.se.iuh.web_candy.entity.HoaDonBanHang;
import com.se.iuh.web_candy.entity.TaiKhoan;
import com.se.iuh.web_candy.service.CustomUserDetails;
import com.se.iuh.web_candy.service.HoaDonService;
import com.se.iuh.web_candy.service.KhachHangService;
import com.se.iuh.web_candy.service.SanPhamService;
import com.se.iuh.web_candy.service.TaiKhoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatHangController2 {

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

    @Autowired
    private SanPhamDAO sanPhamDAO;

    public double totalPrice(HashMap<Integer, Cart> cartItems) {
        double count = 0;
        double price = 0;
        int qty = 0;
        double salePrice = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
            price = list.getValue().getSanPham().getDonGia();
            qty = list.getValue().getQty();

            count += price * qty;
        }
        return count;
    }

    @GetMapping("/order")
    public String dathang(HttpSession session) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        HoaDonBanHang hoaDon = new HoaDonBanHang();
        hoaDon.setGhiChu("");
        hoaDon.setNgayLapDat(LocalDate.now());
        hoaDon.setNgayLapGiao(LocalDate.now());
        hoaDon.setTrangThai("Chờ xử lý");
        hoaDon.setTongSoLuong(cartItems.size());
        hoaDon.setTongTien(totalPrice(cartItems));

        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = ((CustomUserDetails) pricipal).getUsername();

        TaiKhoan tk = taiKhoanService.getTaiKhoanByTenTK(user);
        hoaDon.setKhachHang(tk.getKhachHang());
        hoaDon.setNguoiNhan(tk.getKhachHang().getTenKH());
        hoaDon.setSdtNguoiNhan(tk.getKhachHang().getSdt());

        System.out.println("tk" + tk.getKhachHang().getTenKH());
        hoaDonService.saveHoaDon(hoaDon);
        HoaDonBanHang hoaDonNew = hoaDonService.getHDNew();
        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            ChiTietHDBanHang ct = new ChiTietHDBanHang();
            ct.setMaHD(hoaDonNew);
            ct.setSanPham(entry.getValue().getSanPham());
            ct.setSoLuong(entry.getValue().getQty());
            ct.setDonGia(entry.getValue().getSanPham().getDonGia());
            chitiethoadonDAO.save(ct);

            sanPhamDAO.updateSanPhamQty(entry.getValue().getSanPham().getMaSP(),
                    entry.getValue().getQty());

        }
        // List<ChiTietHoaDonDTO> mapCTHD = new ArrayList<ChiTietHoaDonDTO>();
        // hoaDonNew.getChiTietHoaDons().forEach(cthd -> {
        // mapCTHD.add(cthd);
        // });

        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        return "redirect:/shop";
    }

}
