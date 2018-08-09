package com.medi.pot.reservation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.reservation.model.dao.ReservationDao;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;
import com.medi.pot.reservation.model.vo.MemberReservation;
import com.medi.pot.reservation.model.vo.ReserList;

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
	public List<DoctorSchedule> selectDocSche(int docNo) {
		return reserDAO.selectDocSche(docNo);
	}


	@Override
	public List<MemberReservation> selectReser(Map<String, Object> map) {
		return reserDAO.selectReser(map);
	}

	@Override
	public int insertReser(MemberReservation mr) {
		return reserDAO.insertReser(mr);
	}

	@Override
	public List<ReserList> reserList(int userNum,int cPage,int numPerPage) {
		return reserDAO.reserList(userNum,cPage,numPerPage);
	}

	@Override
	public int reserDelete(int chNum) {
		return reserDAO.reserDelete(chNum);
	}

	@Override
	public int reserCount(int num) {
		return reserDAO.reserCount(num);
	}

	@Override
	public int insertBlock(Map<String, Object> map) {
		return reserDAO.insertBlock(map);
	}
	
	
	
	
	
	
	
	
	

}
