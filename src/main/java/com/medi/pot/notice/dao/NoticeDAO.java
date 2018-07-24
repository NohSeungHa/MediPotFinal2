package com.medi.pot.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.notice.vo.HospitalNotice;

public interface NoticeDAO {
	
	List<HospitalNotice> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage);
	int insertNotice(SqlSessionTemplate sqlsession,HospitalNotice notice);
	HospitalNotice selectOneNotice(SqlSessionTemplate sqlsession,int no);
	void updateCount(SqlSessionTemplate sqlsession,int no);
	int selectCount(SqlSessionTemplate sqlsession);
	List selectNoticeNumber(SqlSessionTemplate sqlsession);
}
