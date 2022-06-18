package com.se.iuh.web_candy.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.iuh.web_candy.entity.HoaDonBanHang;

@Repository
public class HoaDonDAOJpaImpl implements HoaDonDAO {
	private EntityManager entityManager;

	
	@Autowired
	public HoaDonDAOJpaImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}


	@Override
	@Transactional
	public List<HoaDonBanHang> findAll() {
		Query theQuery = (Query) entityManager.createQuery("from HoaDonBanHang");
		List<HoaDonBanHang> hoadons = theQuery.getResultList();
		return hoadons;
	}


	@Override
	@Transactional
	public Optional<HoaDonBanHang> findById(int theId) {
		return Optional.of(entityManager.find(HoaDonBanHang.class, theId));
	}


	@Override
	@Transactional
	public void save(HoaDonBanHang theHoaDon) {
		HoaDonBanHang dbHoaDon = entityManager.merge(theHoaDon);
		theHoaDon.setMaHD(dbHoaDon.getMaHD());
		
	}


	@Override
	@Transactional
	public void deteleById(int theId) {
		Query<HoaDonBanHang> theQuery = (Query<HoaDonBanHang>) entityManager.createQuery("delete from HoaDonBanHang where maHD=:hoadonId");
		theQuery.setParameter("hoadonId", theQuery);
		theQuery.executeUpdate();
		
	}
	
}
