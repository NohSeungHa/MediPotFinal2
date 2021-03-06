package com.medi.pot.reservation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.reservation.model.dao.ReservationDao;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reserDAO;

	@Override
	public List<HospitalInfo> medisearchList(Map<String, String> map,int cPage, int numPerPage) {
		return reserDAO.medisearchList(map,cPage,numPerPage);
	}

	@Override
	public int selectCount(Map<String, String> map) {
		return reserDAO.selectCount(map);
	}

	@Override
	public List<HospitalInfo> mediNameSearch(String hName) {
		return reserDAO.mediNameSearch(hName);
	}

	@Override
	public HospitalInfo mediInfo(int num) {
		return reserDAO.mediInfo(num);
	}

	@Override
	public List<DoctorInfo> selectDoctorList(int num) {
		return reserDAO.selectDoctorList(num);
	}

	@Override
	public DoctorInfo selectDoctor(int docNo) {
		return reserDAO.selectDoctor(docNo);
	}

	@Override
	public DoctorSchedule selectDocSche(int docNo) {
		return reserDAO.selectDocSche(docNo);
	}
	
	
	
	
	
	
	

}
