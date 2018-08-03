package com.medi.pot.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.HospitalInfo;

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

	@Override
	public List<Hospital> selectHospitalList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("hospital.selectHospitalList",null,rb);
	}

	@Override
	public int selectHospitalCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("hospital.selectCount");
	}

	@Override
	public int updateAdmission(SqlSessionTemplate sqlSession, int hospitalNum) {
		return sqlSession.update("hospital.updateAdmission",hospitalNum);
	}

	@Override
	public int duplicateMemEmailCheck(SqlSessionTemplate sqlSession, String memberEmail) {
		System.out.println("duplicate Email : " + memberEmail);
		return sqlSession.selectOne("member.duplicateEmail", memberEmail);
		
	}
	
	@Override
	public int checkEmail(SqlSessionTemplate sqlSession, String memberEmail) {
		System.out.println("check Email : " + memberEmail);
		return sqlSession.selectOne("member.checkEmail",memberEmail);
		
	}

	@Override
	public int FindMemEmailCheck(SqlSessionTemplate sqlSession, String memberEmail) {
		
		return sqlSession.selectOne("member.FindEmail", memberEmail);
		
	}

	@Override
	public String FindId(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("member.FindId", m);
		
	}

	@Override
	public Member searchName(SqlSessionTemplate sqlSession, String findname) {
		
		return sqlSession.selectOne("member.searchName", findname);
		
	}

	@Override
	public Member searchID(SqlSessionTemplate sqlSession, String findid) {
		
		return sqlSession.selectOne("member.searchID", findid);
		
	}

	@Override
	public int MemberUpdate(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.update("member.MemberUpdate", m);
		
	}

	@Override
	public int HospitalSelectCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("hospital.HospitalSelectCount");
		
	}

	@Override
	public HospitalInfo selectHospitalInfo(SqlSessionTemplate sqlSession, int hospitalNum) {
		return sqlSession.selectOne("hospital.selectHospitalInfo",hospitalNum);
	}

	@Override
	public DoctorInfo selectDoctorInfo(SqlSessionTemplate sqlSession, int hospitalNum) {
		return sqlSession.selectOne("hospital.selectDoctorInfo",hospitalNum);
	}
	
	

	
}
