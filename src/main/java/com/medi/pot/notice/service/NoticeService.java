package com.medi.pot.notice.service;

import java.util.List;

import com.medi.pot.notice.vo.HospitalNotice;

public interface NoticeService {
	
	List<HospitalNotice> selectList(int cPage, int numPerPage);
	int insertNotice(HospitalNotice notice);
	HospitalNotice selectOneNotice(int no);
	void updateCount(int no);
	int selectCount();
	List selectNoticeNumber();
	
}
