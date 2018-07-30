package com.medi.pot.reservation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.reservation.model.dao.ReservationDao;
import com.medi.pot.reservation.model.vo.HospitalInfo;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reserDAO;

	@Override
	public List<HospitalInfo> medisearchList(Map<String, String> map) {
		return reserDAO.medisearchList(map);
	}
	
	

}
