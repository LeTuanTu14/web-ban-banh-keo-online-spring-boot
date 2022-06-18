package com.se.iuh.web_candy.service;

import java.util.List;
import java.util.Optional;

import com.se.iuh.web_candy.dao.LoaiSPRepository;
import com.se.iuh.web_candy.entity.LoaiSP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiSPServiceImpl implements LoaiSPService {

    private LoaiSPRepository loaiSPRespository;

    @Autowired
    public LoaiSPServiceImpl(LoaiSPRepository theloaiSPRespository) {
        loaiSPRespository = theloaiSPRespository;
    }

    @Override
    public List<LoaiSP> getLoaiSanPhams() {

        // TODO Auto-generated method stub
        return loaiSPRespository.findAll();
    }

    @Override
    public LoaiSP getLoaiSanPhamById(int id) {
        Optional<LoaiSP> opEm = loaiSPRespository.findById(id);
        LoaiSP lsp = null;
        if (opEm.isPresent()) {
            lsp = opEm.get();
        } else {
            throw new RuntimeException("Loai San Pham not found");
        }
        return lsp;
    }

    @Override
    public void saveLoaiSanPham(LoaiSP theLoaiSanPham) {
        loaiSPRespository.save(theLoaiSanPham);

    }

    @Override
    public List<LoaiSP> searchLoaiSanPhams(String theSearchName) {
        return loaiSPRespository.findByTenLoaiSP(theSearchName);
    }

    @Override
    public void deleteLoaiSanPham(int id) {
        loaiSPRespository.deleteById(id);

    }

}
