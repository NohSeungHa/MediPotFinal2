package com.medi.pot.helpZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.helpZone.dao.HelpZoneDao;
import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneComment;
import com.medi.pot.member.model.vo.Member;

@Service
public class HelpZoneServiceImpl implements HelpZoneService {
	
	@Autowired
	private HelpZoneDao helpZoneDao; 
	

	//헬프존 입력하기
	@Override
	public int insertHelpZone(HelpZone helpZone) {
		return helpZoneDao.insertHelpZone(helpZone);
	}

	//헬프존 리스트 출력하기
	@Override
	public List<HelpZone> selectHelpZoneList(int cPage, int numPerPage) {
		return helpZoneDao.selectHelpZoneList(cPage, numPerPage);
	}
	
	@Override
	public int selectCount() {
		return helpZoneDao.selectCount();
	}

	@Override
	public HelpZone selectHelpZone(int helpZoneNum) {
		return helpZoneDao.selectHelpZone(helpZoneNum);
	}

	//글불러올 때, 작성자만 불러오는 메서드
	@Override
	public Member selectMember(int helpZoneQuestioner) {
		return helpZoneDao.selectMember(helpZoneQuestioner);
	}

	@Override
	public int deleteHelpZone(int num) {
		return helpZoneDao.deleteHelpZone(num);
	}

	@Override
	public int updateHelpZone(HelpZone helpZone) {
		return helpZoneDao.updateHelpZone(helpZone);
	}
	
	
	

	
}
