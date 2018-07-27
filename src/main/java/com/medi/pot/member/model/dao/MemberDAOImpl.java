package com.medi.pot.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Override
	public Member loginMemberCheck(SqlSessionTemplate sqlSession, String memberId) {
		System.out.println("dao에서 ID : " + memberId);
		
		return sqlSession.selectOne("member.loginMemberCheck", memberId);
	}

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.insert("member.insertMember", m);
		
	}

	@Override
	public Hospital loginHospitalCheck(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("hospital.loginCheck", userId);
		
	}

	@Override
	public int duplicateMemIdCheck(SqlSessionTemplate sqlSession, String memberId) {
		
		return sqlSession.selectOne("member.Memberduplicate", memberId);
		
	}

	@Override
	public int checkId(SqlSessionTemplate sqlSession, String memberId) {
		
		return sqlSession.selectOne("member.checkId", memberId);
		
	}

	@Override
	public int memberPageUpdate(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.update("member.mypageUpdate", m);
		
	}

	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, String memberId) {
		
		return sqlSession.selectOne("member.selectMember", memberId);
		
	}

	@Override
	public int memberPwUpdate(SqlSessionTemplate sqlSession, Map<String, String> idpw) {
		
		return sqlSession.update("member.newPwUpdate", idpw);
		
	}
	
	
}