package com.medi.pot.member.model.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.member.model.dao.MemberDAO;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member loginMemberCheck(String memberId) {
		
		return dao.loginMemberCheck(sqlSession, memberId);
		
	}

	@Override
	public int insertMember(Member m) {
		
		return dao.insertMember(sqlSession, m);
		
	}

	@Override
	public Hospital loginHospitalCheck(String userId) {
		
		return dao.loginHospitalCheck(sqlSession, userId);
		
	}

	@Override
	public int duplicateMemIdCheck(String memberId) {
		
		return dao.duplicateMemIdCheck(sqlSession, memberId);
		
	}

	@Override
	public int checkId(String memberId) {
		
		return dao.checkId(sqlSession, memberId);
		
	}

	@Override
	public int memberPageUpdate(Member m) {
		
		return dao.memberPageUpdate(sqlSession, m);
		
	}

	@Override
	public Member selectMember(String memberId) {
		
		return dao.selectMember(sqlSession, memberId);
		
	}

	@Override
	public int memberPwUpdate(Map<String, String> idpw) {
		
		return dao.memberPwUpdate(sqlSession, idpw);
		
	}
	
}
