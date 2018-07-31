package com.medi.pot.reservation.model.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.reservation.model.vo.HospitalInfo;

public interface ReservationService {
	List<HospitalInfo> medisearchList(Map<String, String> map,int cPage,int numPerPage);
	int selectCount(Map<String, String> map);
	List<HospitalInfo> mediNameSearch(String hName);
	HospitalInfo mediInfo(int num);
}
