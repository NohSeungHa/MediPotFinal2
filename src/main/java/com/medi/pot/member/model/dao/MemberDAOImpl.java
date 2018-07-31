package com.medi.pot.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public int checkHospitalId(SqlSessionTemplate sqlSession, String hospitalId) {
		return sqlSession.selectOne("hospital.checkId",hospitalId);
	}

	@Override
	public int insertHospital(SqlSessionTemplate sqlSession, Hospital h) {
		return sqlSession.insert("hospital.insertHospital",h);
	}

	@Override
	public List<Member> selectMemberList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("member.selectMemberList",null,rb);
	}

	@Override
	public int selectCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("member.selectCount");
	}
	
	
	
}
