package com.se.iuh.web_candy.restcontroller;

import java.util.List;

import com.se.iuh.web_candy.entity.LoaiSP;
import com.se.iuh.web_candy.service.LoaiSPService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LoaiSPRestController {
    private LoaiSPService loaiSPService;

    @Autowired
    public LoaiSPRestController(LoaiSPService theloaiSPService) {
        loaiSPService = theloaiSPService;
    }

    @GetMapping("/loaisanphams")
    public List<LoaiSP> listLoaiSanPhams() {
        return loaiSPService.getLoaiSanPhams();
    }

    @GetMapping("/loaisanpham/{id}")
    public LoaiSP getLSPById(@PathVariable int id) throws Exception {
        LoaiSP lsp = loaiSPService.getLoaiSanPhamById(id);
        if ((id < 0) || lsp == null) {
            throw new RuntimeException("San Pham not found");
        }
        return lsp;
    }
}
