package com.medi.pot.reservation.model.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;
import com.medi.pot.reservation.model.vo.MemberReservation;
import com.medi.pot.reservation.model.vo.ReserList;

public interface ReservationService {
	List<HospitalInfo> medisearchList(Map<String, String> map,int cPage,int numPerPage);
	int selectCount(Map<String, String> map);
	List<HospitalInfo> mediNameSearch(String hName);
	HospitalInfo mediInfo(int num);
	List<DoctorInfo> selectDoctorList(int num);
	DoctorInfo selectDoctor(int docNo);
	List<DoctorSchedule> selectDocSche(int docNo);
	List<MemberReservation> selectReser(Map<String, Object> map);
	int insertReser(MemberReservation mr);
	List<ReserList> reserList(int userNum,int cPage,int numPerPage);
	int reserDelete(int chNum);
	int reserCount(int num);
}
