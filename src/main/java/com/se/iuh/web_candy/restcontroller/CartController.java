package com.se.iuh.web_candy.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.se.iuh.web_candy.entity.Cart;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class CartController {
    @Autowired
    private SanPhamService sanPhamService;

    // @RequestMapping(value = "addCart/{id}", method = RequestMethod.GET)
    @GetMapping("addCart/{id}")
    public String addToCart(ModelMap mm, HttpServletRequest request, HttpSession session,
            @PathVariable("id") int idSP) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<Integer, Cart>();
            System.out.println("null");
        }
        SanPham sp = sanPhamService.getSanPhamById(idSP);
        System.out.println(sp);
        if (sp != null) {
            if (cartItems.containsKey(idSP)) {
                Cart item = cartItems.get(idSP);
                item.setSanPham(sp);
                item.setQty(item.getQty() + 1);
                cartItems.put(idSP, item);
            } else {
                Cart item = new Cart();
                item.setSanPham(sp);
                item.setQty(1);
                cartItems.put(idSP, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/shop";
    }

    @GetMapping("update/{id}/{qty}")
    public String cartUpdate(ModelMap mm, HttpSession session, @PathVariable("id") int idSP,
            @PathVariable("qty") int qty) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        SanPham sp = sanPhamService.getSanPhamById(idSP);
        System.out.println(sp);
        if (sp != null) {
            if (cartItems.containsKey(idSP)) {
                Cart item = cartItems.get(idSP);
                item.setSanPham(sp);
                item.setQty(qty);
                cartItems.put(idSP, item);
            } else {
                Cart item = new Cart();
                item.setSanPham(sp);
                item.setQty(1);
                cartItems.put(idSP, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        return "redirect:/cart";
    }

    @GetMapping("remove/{id}")
    public String cartRemove(ModelMap mm, HttpSession session, @PathVariable("id") int idSP) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(idSP)) {
            cartItems.remove(idSP);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/cart";
    }

    public double totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        double price = 0;
        int qty = 0;
        double salePrice = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
            price = list.getValue().getSanPham().getDonGia();
            qty = list.getValue().getQty();
            salePrice = list.getValue().getSanPham().getKhuyenMai();
            if (list.getValue().getSanPham().getKhuyenMai() == 0) {
                count += price * qty;
            } else {
                count += (price - price * salePrice) * qty;
            }
        }
        return count;
    }

}
