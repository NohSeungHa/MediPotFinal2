package com.medi.pot.reservation.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.pot.reservation.model.vo.HospitalInfo;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<HospitalInfo> medisearchList(Map<String, String> map) {
		return session.selectList("reser.mediList", map);
	}
	
	

}
