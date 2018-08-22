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
import com.medi.pot.reservation.model.vo.SearchReserList;

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
	public List<DoctorSchedule> selectDocSche(int docNo) {
		return session.selectList("reser.selectDocSche", docNo);
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
	public List<ReserList> reserList(int userNum,int cPage,int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		return session.selectList("reser.selectReserList", userNum, rowBounds);
	}

	@Override
	public int reserDelete(int chNum) {
		return session.delete("reser.deleteReser", chNum);
	}

	@Override
	public int reserCount(int num) {
		return session.selectOne("reser.selectReserCount", num);
	}

	@Override
	public int insertBlock(Map<String, Object> map) {
		return session.insert("reser.insertBlock", map);
	}

	@Override
	public int hDeleteReser(Map<String, Object> map) {
		return session.delete("reser.deletehReser", map);
	}

	@Override
	public int bDeleteReser(Map<String, Object> map) {
		return session.delete("reser.deletebReser",map);
	}

	@Override
	public int hBlockDate(Map<String, Object> map) {
		return session.insert("reser.insertBlockH",map);
	}

	@Override
	public int deleteDateCan(Map<String, Object> map) {
		return session.delete("reser.deleteDateCan",map);
	}

	@Override
	public List<SearchReserList> searchReserM(Map<String, Object> map,int cPage,int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		return session.selectList("reser.selectReserListM", map,rowBounds);
	}

	@Override
	public int searchReserCount(Map<String, Object> map) {
		return session.selectOne("reser.searchReserCount", map);
	}

	@Override
	public int deleteSearchReser(int num) {
		return session.delete("reser.deleteSearchReser", num);
	}

	@Override
	public List<SearchReserList> searchReserMem(Map<String, Object> map, int cPage, int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		return session.selectList("reser.selectListSearchMem", map, rowBounds);
	}

	@Override
	public int searchReserMemCount(Map<String, Object> map) {
		return session.selectOne("reser.selectCountReserMem", map);
	}

	@Override
	public int deleteSearchReserMember(int num) {
		return session.delete("reser.deleteSearchReserMember", num);
	}

	@Override
	public List<HospitalInfo> selectHosList() {
		return session.selectList("reser.selectHos");
	}

	@Override
	public List<HospitalInfo> selectAll() {
		return session.selectList("reser.selectAll");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
