package com.se.iuh.web_candy.entity;

public class Cart {
    public SanPham sanPham;
    public int qty;

    public Cart() {
    }

    public Cart(SanPham sanPham, int qty) {
        this.sanPham = sanPham;
        this.qty = qty;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Cart [qty=" + qty + ", sanPham=" + sanPham + "]";
    }

}
