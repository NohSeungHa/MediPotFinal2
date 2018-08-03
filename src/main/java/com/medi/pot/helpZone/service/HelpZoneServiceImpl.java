package com.medi.pot.helpZone.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.helpZone.dao.HelpZoneDao;
import com.medi.pot.helpZone.vo.HelpZone;

@Service
public class HelpZoneServiceImpl implements HelpZoneService {
	
	@Autowired
	private HelpZoneDao helpZoneDao; 
	
	@Autowired
	private SqlSessionTemplate session;
	
	//헬프존 입력하기
	@Override
	public int insertHelpZone(HelpZone helpzone) {
		return helpZoneDao.insertHelpZone(session, helpzone);
	}
	

	
}
