package com.se.iuh.web_candy.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.se.iuh.web_candy.entity.SanPham;
import com.se.iuh.web_candy.service.SanPhamService;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SanPhamDAOJpaImpl implements SanPhamDAO {
    private EntityManager entityManager;
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    public SanPhamDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void updateSanPhamQty(int maSP, int outQty) {
        SanPham sp = sanPhamService.getSanPhamById(maSP);
        int newQty = sp.getSoLuong() - outQty;
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession
                .createSQLQuery("UPDATE san_pham SET  so_luong = " + newQty + "  WHERE ma_san_pham =" + maSP + "");
        query.executeUpdate();
    }

}
