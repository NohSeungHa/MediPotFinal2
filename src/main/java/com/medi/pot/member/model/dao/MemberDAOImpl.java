package com.medi.pot.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.member.model.vo.DoctorInfos;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.HospitalInfos;
import com.medi.pot.member.model.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Override
	public Member loginMemberCheck(SqlSessionTemplate sqlSession, String memberId) {
		System.out.println("Member의 dao에서 ID : " + memberId);
		
		return sqlSession.selectOne("member.loginMemberCheck", memberId);
	}

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.insert("member.insertMember", m);
		
	}

	@Override
	public Hospital loginHospitalCheck(SqlSessionTemplate sqlSession, String memberId) {
		
		System.out.println("Hospital의 DAO ID : " + memberId);
		return sqlSession.selectOne("hospital.loginCheck", memberId);
		
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
	public String MemberFindId(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("member.FindId", m);
		
	}

	@Override
	public Member searchMemberName(SqlSessionTemplate sqlSession, String findname) {
		
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
	public int checkHospitalEmail(SqlSessionTemplate sqlSession, String HospitalEmail) {
		
		System.out.println("check Email : " + HospitalEmail);
		return sqlSession.selectOne("hospital.checkhospitalEmail",HospitalEmail);
		
	}

	@Override
	public int hospitalCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("hospital.hoscnt");
		
	}

	@Override
	public String selecthospitalName(SqlSessionTemplate sqlSession, int hospitalNum) {
		
		return sqlSession.selectOne("hospital.hospitalNameinput", hospitalNum);
		
	}

	@Override
	public Hospital selectHospital(SqlSessionTemplate sqlSession, int hospitalNum) {
		
		return sqlSession.selectOne("hospital.selectHospital", hospitalNum);
		
	}

	@Override
	public int hospitalInfoinsert(SqlSessionTemplate sqlSession, HospitalInfos hospitalInfo) {
		
		return sqlSession.insert("hospital.hospitalInfoinsert", hospitalInfo);
		
	}

	@Override
	public HospitalInfos selectHospitalInfo(SqlSessionTemplate sqlSession, int hospitalNum) {
		
		return sqlSession.selectOne("hospital.selectHospitalInfo", hospitalNum);
		
	}

	@Override
	public int loadHospitalInfo(SqlSessionTemplate sqlSession, int hospitalNum) {
		
		return sqlSession.selectOne("hospital.loadHospitalInfo", hospitalNum);
		
	}

	@Override
	public List<DoctorInfos> selectDoctorInfo(SqlSessionTemplate sqlSession, int hospitalNum) {
		
		return sqlSession.selectList("hospital.selectDoctorInfo", hospitalNum);
		
	}

	@Override
	public int doctorInfoInsert(SqlSessionTemplate sqlSession, DoctorInfos doctorInfo) {
		
		return sqlSession.insert("hospital.doctorinfoinsert", doctorInfo);
		
	}

	@Override
	public int updateHospitalInfo(SqlSessionTemplate sqlSession, HospitalInfos hospitalInfo) {
		
		return sqlSession.update("hospital.updateHospitalInfo", hospitalInfo);
		
	}

	@Override
	public DoctorInfos selectDoctorPhoto(SqlSessionTemplate sqlSession, int doctorNum) {
		
		return sqlSession.selectOne("hospital.selectDoctorPhoto", doctorNum);
		
	}

	@Override
	public int updateDoctorInfo(SqlSessionTemplate sqlSession, DoctorInfos doctorInfo) {
		
		return sqlSession.update("hospital.updateDoctorInfo", doctorInfo);
		
	}

	@Override
	public String DoctorsProfessional(SqlSessionTemplate sqlSession, int doctorNum) {
		
		return sqlSession.selectOne("hospital.DoctorsProfessional", doctorNum);
		
	}

	@Override
	public int hospitalUpdate(SqlSessionTemplate sqlSession, Hospital hospital) {
		
		return sqlSession.update("hospital.hospitalUpdate", hospital);
		
	}

	@Override
	public int FindHosEmailCheck(SqlSessionTemplate sqlSession, String memberEmail) {
		
		return sqlSession.selectOne("hospital.EmailCheck", memberEmail);
		
	}

	@Override
	public int deleteMember(SqlSessionTemplate sqlSession, int memberNum) {
		
		return sqlSession.delete("member.deleteMember", memberNum);
		
	}

	@Override
	public String HospitalFindId(SqlSessionTemplate sqlSession, Hospital h) {
		
		return sqlSession.selectOne("hospital.HospitalFindId", h);
		
	}

	@Override
	public Hospital searchHospitalName(SqlSessionTemplate sqlSession, String findname) {
		
		return sqlSession.selectOne("hospital.searchHospitalName", findname);
		
	}

	@Override
	public String hospitalNameDoctorNum(SqlSessionTemplate sqlSession, int doctorNum) {
		
		return sqlSession.selectOne("hospital.hospitalNameDoctorNum", doctorNum);
		
	}

	
}
