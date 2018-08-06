package com.medi.pot.reservation.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;
import com.medi.pot.reservation.model.vo.MemberReservation;
import com.medi.pot.reservation.model.vo.ReserList;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<HospitalInfo> medisearchList(Map<String, String> map,int cPage,int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		return session.selectList("reser.mediList", map, rowBounds);
	}

	@Override
	public int selectCount(Map<String, String> map) {
		return session.selectOne("reser.selectCount", map);
	}

	@Override
	public List<HospitalInfo> mediNameSearch(String hName) {
		return session.selectList("reser.selectName", hName);
	}

	@Override
	public HospitalInfo mediInfo(int num) {
		return session.selectOne("reser.selectMedi", num);
	}

	@Override
	public List<DoctorInfo> selectDoctorList(int num) {
		return session.selectList("reser.selectDoctor", num);
	}

	@Override
	public DoctorInfo selectDoctor(int docNo) {
		return session.selectOne("reser.selectDoc", docNo);
	}

	@Override
	public DoctorSchedule selectDocSche(int docNo) {
		return session.selectOne("reser.selectDocSche", docNo);
	}


	@Override
	public List<MemberReservation> selectReser(Map<String, Object> map) {
		return session.selectList("reser.selectReser", map);
	}

	@Override
	public int insertReser(MemberReservation mr) {
		return session.insert("reser.insertReser", mr);
	}

	@Override
	public List<ReserList> reserList(int userNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
