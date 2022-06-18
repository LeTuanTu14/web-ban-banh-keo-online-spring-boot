package com.se.iuh.web_candy.restcontroller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.se.iuh.web_candy.dto.TaiKhoanDTO;
import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.CustomUserDetailsService;
import com.se.iuh.web_candy.service.LoaiSPService;
import com.se.iuh.web_candy.service.SanPhamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSPService loaiSPService;

	@Autowired
	private CustomUserDetailsService userService;

	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/home";
	}

	@GetMapping("/helo")
	public String showHelo(HttpSession session) {
		session.setAttribute("mysession", "value");
		return "hello";
	}

	@GetMapping("/home")
	public String showShopHome(Model model) {
		model.addAttribute("loaiSPS", loaiSPService.getLoaiSanPhams());
		return "index";
	}

	@GetMapping("/shop")
	public String showShop(Model model) {
		model.addAttribute("listProduct", sanPhamService.getTop12SanPhams());
		model.addAttribute("listLoaiSP", loaiSPService.getLoaiSanPhams());
		return "shop";
	}

	@GetMapping("/login")
	public String showFormLogin() {

		return "login";
	}

	@GetMapping("/sale")
	public String showShopSale(Model model) {
		model.addAttribute("listProduct", sanPhamService.getSanPhamsKM());
		model.addAttribute("listLoaiSP", loaiSPService.getLoaiSanPhams());
		return "/sale";
	}

	@GetMapping("/wisslist")
	public String showWissList(Model model) {

		return "wisslist";
	}

	@GetMapping("/cart")
	public String showCart(Model model) {
		return "shoping-cart";
	}

	@GetMapping("/contact")
	public String showContact(Model model) {
		return "contact";
	}

	@GetMapping("/checkout")
	public String showCheckout(Model model) {
		return "checkout";
	}

	@GetMapping("/sanpham/{id}")
	public String showProductDetails(Model model, @PathVariable int id) {
		SanPham sp = sanPhamService.getSanPhamById(id);
		model.addAttribute("productOne", sp);
		return "shop-details";
	}

	@GetMapping("/registration")
	public String createUser(Model model) {
		model.addAttribute("userData", new TaiKhoanDTO());
		return "form-user";
	}

	@GetMapping("/about.html")
	public String about() {
		return "about";
	}

	@PostMapping("/registration/save")
	public String registerUserAccount(@Valid TaiKhoanDTO userDto, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("registrationForm", userDto);
			return "/registration";
		}
		try {
			userService.save(userDto);
		} catch (Exception e) {
			bindingResult.rejectValue("tenTK", "userData.tenTK", "An account already exists for this name.");
			model.addAttribute("registrationForm", userDto);
			return "/registration";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {

			String message = "Hi! " + principal.getName() //
					+ "<br> Bạn không có quyền truy cập vào trang này! Vui lòng quay lại sau.";
			model.addAttribute("message", message);
		}
		return "admin/NguoiDung/403Page";
	}
}
