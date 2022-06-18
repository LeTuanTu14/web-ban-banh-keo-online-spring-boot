package com.se.iuh.web_candy.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.se.iuh.web_candy.entity.Cart;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CartRestController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("addCart/{id}")
    public Map<Integer, Double> addCartaddToCart(ModelMap mm, HttpSession session,
            @PathVariable("id") int idSP, String type) {
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
                System.out.println("vo");
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
        System.out.println(cartItems);
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(cartItems.size(), totalPrice(cartItems));
        System.out.println(map);

        return map;

    }

    @GetMapping("/remove/{id}")
    public HttpStatus cartRemove(ModelMap mm, HttpSession session, @PathVariable("id") int idSP) {
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
        return HttpStatus.OK;
    }

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

}
