package com.medi.pot.member.model.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.HospitalInfos;
import com.medi.pot.member.model.vo.Member;

public interface MemberService {
	
	/* 아이디 중복검사*/
	int duplicateMemIdCheck(String memberId);
	int checkId(String memberId);
	int checkHospitalId(String hospitalId);
	
	/* 이메일 중복검사 */
	int duplicateMemEmailCheck(String memberEmail);
	int checkEmail(String memberEmail); // 일반회원
	int checkHospitalEmail(String HospitalEmail); // 병원회원
	
	/*일반회원*/
	Member loginMemberCheck(String memberId);
	int insertMember(Member m);
	int memberPageUpdate(Member m);
	Member selectMember(String memberId);
	int memberPwUpdate(Map<String, String> idpw);
	List<Member> selectMemberList(int cPage, int numPerPage);
	int selectCount();
	
	/* 아이디찾기 */
	int FindMemEmailCheck(String memberEmail);
	String FindId(Member m);
	Member searchName(String findname);
	
	/* 비밀번호 찾기 */
	Member searchID(String findid);
	int MemberUpdate(Member m);
	
	/*병원회원*/
	Hospital loginHospitalCheck(String memberId);
	int insertHospital(Hospital h);
	List<Hospital> selectHospitalList(int cPage, int numPerPage);
	int selectHospitalCount();
	int updateAdmission(int hospitalNum);
	int hospitalCount();
	String selecthospitalName(int hospitalNum);
	int hospitalInfoinsert(HospitalInfos hospitalInfo);
	HospitalInfos selectHospitalInfo(int hospitalNum);
}
