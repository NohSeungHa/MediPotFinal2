package com.medi.pot.helpZone.dao;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.member.model.vo.Member;

public interface HelpZoneDao {

	int insertHelpZone(HelpZone helpZone);
	List<HelpZone> selectHelpZoneList(int cPage,int numPerPage);
	int selectCount();
	HelpZone selectHelpZone(int helpZoneNum);
	Member selectMember(int helpZoenQuestioner);
	int deleteHelpZone(int num);
	int updateHelpZone(HelpZone helpZone);
}
