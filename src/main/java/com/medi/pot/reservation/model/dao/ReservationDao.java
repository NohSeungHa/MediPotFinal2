package com.medi.pot.reservation.model.dao;

import java.util.List;
import java.util.Map;

import com.medi.pot.reservation.model.vo.HospitalInfo;

public interface ReservationDao {
	
	List<HospitalInfo> medisearchList(Map<String, String> map,int cPage,int numPerPage);
	int selectCount(Map<String, String> map);
	List<HospitalInfo> mediNameSearch(String hName);

}
