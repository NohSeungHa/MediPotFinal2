package com.medi.pot.helpZone.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.helpZone.vo.HelpZone;

public interface HelpZoneDao {

	int insertHelpZone(SqlSessionTemplate session, HelpZone helpzone);
}
