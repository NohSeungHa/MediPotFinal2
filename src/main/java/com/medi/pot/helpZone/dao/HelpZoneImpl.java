package com.medi.pot.helpZone.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.helpZone.vo.HelpZone;

@Repository
public class HelpZoneImpl implements HelpZoneDao {

	@Override
	public int insertHelpZone(SqlSessionTemplate session, HelpZone helpzone) {
		return session.insert("helpzone.helpZoneInsert", helpzone);
	}

}
