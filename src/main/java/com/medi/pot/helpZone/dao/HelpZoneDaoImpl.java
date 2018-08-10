package com.medi.pot.helpZone.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.member.model.vo.Member;

@Repository
public class HelpZoneDaoImpl implements HelpZoneDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insertHelpZone(HelpZone helpZone) {
		return session.insert("helpZone.helpZoneInsert", helpZone);
	}

	@Override
	public List<HelpZone> selectHelpZoneList(int cPage, int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		return session.selectList("helpZone.helpZoneSelectList", null, rowBounds);
	}
	
	@Override
	public int selectCount() {
		return session.selectOne("helpZone.count");
	}

	@Override
	public HelpZone selectHelpZone(int helpZoneNum) {
		return session.selectOne("helpZone.selectHelpZone", helpZoneNum);
	}

	@Override
	public Member selectMember(int helpZoenQuestioner) {
		return session.selectOne("helpZone.selectMember", helpZoenQuestioner);
	}

	@Override
	public int deleteHelpZone(int num) {
		return session.delete("helpZone.deleteHelpZone", num);
	}

	@Override
	public int updateHelpZone(HelpZone helpZone) {
		
		return session.update("helpZone.updateHelpZone",helpZone);
	}
	
	
	
	
	
	

}
