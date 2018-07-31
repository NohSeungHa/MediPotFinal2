package com.medi.pot.notice.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.notice.vo.HospitalNotice;

@Repository
public class NoticeDAOImpl implements NoticeDAO {


	@Override
	public List<HospitalNotice> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("notice.hospitalNoticeList",null,rb);
	}
	@Override
	public int insertNotice(SqlSessionTemplate sqlsession, HospitalNotice notice) {
		System.out.println("2"+notice);
		System.out.println(notice.getHospitalNoticeRefile());
		return sqlsession.insert("notice.hospitalNoticeInsert",notice);
	}
	@Override
	public HospitalNotice selectOneNotice(SqlSessionTemplate sqlsession, int no) {
		return sqlsession.selectOne("notice.selectOneNotice", no);
	}
	
	@Override
	public void updateCount(SqlSessionTemplate sqlsession, int no) {
		sqlsession.update("notice.updateCount", no);
		
	}
	@Override
	public int selectCount(SqlSessionTemplate sqlsession) {
		return sqlsession.selectOne("notice.selectCount");
	}
	@Override
	public List selectNoticeNumber(SqlSessionTemplate sqlsession) {
		return sqlsession.selectList("notice.selectNoticeNumber");
	}

}
