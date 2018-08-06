package com.medi.pot.member.model.service;

import java.util.List;
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
	public Hospital loginHospitalCheck(String memberId) {
		
		return dao.loginHospitalCheck(sqlSession, memberId);
		
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

	@Override
	public int checkHospitalId(String hospitalId) {
		return dao.checkHospitalId(sqlSession, hospitalId);
	}

	@Override
	public int insertHospital(Hospital h) {
		return dao.insertHospital(sqlSession, h);
	}

	@Override
	public List<Member> selectMemberList(int cPage, int numPerPage) {
		return dao.selectMemberList(sqlSession,cPage,numPerPage);
	}

	@Override
	public int selectCount() {
		return dao.selectCount(sqlSession);
	}

	@Override
	public List<Hospital> selectHospitalList(int cPage, int numPerPage) {
		return dao.selectHospitalList(sqlSession, cPage, numPerPage);
	}

	@Override
	public int selectHospitalCount() {
		return dao.selectHospitalCount(sqlSession);
	}

	@Override
	public int updateAdmission(int hospitalNum) {
		return dao.updateAdmission(sqlSession, hospitalNum);
	}

	@Override
	public int duplicateMemEmailCheck(String memberEmail) {
		
		return dao.duplicateMemEmailCheck(sqlSession, memberEmail);
		
	}

	@Override
	public int checkEmail(String memberEmail) {
		
		return dao.checkEmail(sqlSession, memberEmail);
		
	}

	@Override
	public int FindMemEmailCheck(String memberEmail) {
		
		return dao.FindMemEmailCheck(sqlSession, memberEmail);
		
	}

	@Override
	public String FindId(Member m) {
		
		return dao.FindId(sqlSession, m);
		
	}

	@Override
	public Member searchName(String findname) {
		
		return dao.searchName(sqlSession, findname);
		
	}

	@Override
	public Member searchID(String findid) {
		
		return dao.searchID(sqlSession, findid);
		
	}

	@Override
	public int MemberUpdate(Member m) {
		
		return dao.MemberUpdate(sqlSession, m);
		
	}

	@Override
	public int checkHospitalEmail(String HospitalEmail) {
		
		return dao.checkHospitalEmail(sqlSession, HospitalEmail);
		
	}

	@Override
	public int hospitalCount() {
		
		return dao.hospitalCount(sqlSession);
		
	}
	
	
	
}
