package com.medi.pot.helpZone.dao;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;

public interface HelpZoneDao {

	int insertHelpZone(HelpZone helpZone);
	List<HelpZone> selectHelpZoneList(int cPage,int numPerPage);
	int selectCount();
}
