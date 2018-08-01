package com.medi.pot.member.model.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

public interface MemberService {
	
	/* 아이디 중복검사*/
	int duplicateMemIdCheck(String memberId);
	int checkId(String memberId);
	int checkHospitalId(String hospitalId);
	
	/*일반회원*/
	Member loginMemberCheck(String memberId);
	int insertMember(Member m);
	int memberPageUpdate(Member m);
	Member selectMember(String memberId);
	int memberPwUpdate(Map<String, String> idpw);
	List<Member> selectMemberList(int cPage, int numPerPage);
	int selectCount();
	
	/*병원회원*/
	Hospital loginHospitalCheck(String userId);
	int insertHospital(Hospital h);
	List<Hospital> selectHospitalList(int cPage, int numPerPage);
	int selectHospitalCount();
	
}
