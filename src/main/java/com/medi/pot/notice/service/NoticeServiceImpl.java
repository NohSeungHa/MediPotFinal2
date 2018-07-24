package com.medi.pot.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.notice.dao.NoticeDAO;
import com.medi.pot.notice.vo.HospitalNotice;

@Service
public class NoticeServiceImpl implements NoticeService {
	


	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<HospitalNotice> selectList(int cPage, int numPerPage) {
		return noticeDAO.selectList(sqlsession,cPage,numPerPage);
	}
	@Override
	public int insertNotice(HospitalNotice notice) {
		System.out.println("1"+notice);
		return noticeDAO.insertNotice(sqlsession,notice);
	}
	@Override
	public HospitalNotice selectOneNotice(int no) {
		return noticeDAO.selectOneNotice(sqlsession,no);
	}
	@Override
	public void updateCount(int no) {
		noticeDAO.updateCount(sqlsession,no);
	}
	@Override
	public int selectCount() {
		return noticeDAO.selectCount(sqlsession);
	}
	@Override
	public List selectNoticeNumber() {
		return noticeDAO.selectNoticeNumber(sqlsession);
	}
	
}
