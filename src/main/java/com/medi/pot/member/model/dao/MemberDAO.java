package com.medi.pot.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

public interface MemberDAO {
	
	/*아이디중복검사*/
	int duplicateMemIdCheck(SqlSessionTemplate sqlSession, String memberId);
	int checkId(SqlSessionTemplate sqlSession, String memberId);
	int checkHospitalId(SqlSessionTemplate sqlSession, String hospitalId);
	
	/*일반회원*/
	Member loginMemberCheck(SqlSessionTemplate sqlSession, String memberId);
	int insertMember(SqlSessionTemplate sqlSession, Member m);
	int memberPageUpdate(SqlSessionTemplate sqlSession, Member m);
	Member selectMember(SqlSessionTemplate sqlSession, String memberId);
	int memberPwUpdate(SqlSessionTemplate sqlSession, Map<String, String> idpw);
	List<Member> selectMemberList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);
	int selectCount(SqlSessionTemplate sqlSession);
	
	/*병원회원*/
	Hospital loginHospitalCheck(SqlSessionTemplate sqlSession, String userId);
	int insertHospital(SqlSessionTemplate sqlSession, Hospital h);
}
