package com.medi.pot.member.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.member.model.dao.MemberDAO;
import com.medi.pot.member.model.vo.DoctorInfos;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.HospitalInfos;
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
	public String MemberFindId(Member m) {
		
		return dao.MemberFindId(sqlSession, m);
		
	}

	@Override
	public Member searchMemberName(String findname) {
		
		return dao.searchMemberName(sqlSession, findname);
		
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

	@Override
	public String selecthospitalName(int hospitalNum) {
		
		return dao.selecthospitalName(sqlSession, hospitalNum);
		
	}

	@Override
	public Hospital selectHospital(int hospitalNum) {
		
		return dao.selectHospital(sqlSession, hospitalNum);
		
	}

	@Override
	public int hospitalInfoinsert(HospitalInfos hospitalInfo) {
		
		return dao.hospitalInfoinsert(sqlSession, hospitalInfo);
		
	}

	@Override
	public HospitalInfos selectHospitalInfo(int hospitalNum) {
		
		return dao.selectHospitalInfo(sqlSession, hospitalNum);
		
	}

	@Override
	public int loadHospitalInfo(int hospitalNum) {
		
		return dao.loadHospitalInfo(sqlSession, hospitalNum);
		
	}

	@Override
	public List<DoctorInfos> selectDoctorInfo(int hospitalNum) {
		
		return dao.selectDoctorInfo(sqlSession, hospitalNum);
		
	}

	@Override
	public int doctorInfoInsert(DoctorInfos doctorInfo) {
		
		return dao.doctorInfoInsert(sqlSession, doctorInfo);
		
	}

	@Override
	public int updateHospitalInfo(HospitalInfos hospitalInfo) {
		
		return dao.updateHospitalInfo(sqlSession, hospitalInfo);
		
	}

	@Override
	public DoctorInfos selectDoctorPhoto(int doctorNum) {
		
		return dao.selectDoctorPhoto(sqlSession, doctorNum);
		
	}

	@Override
	public int updateDoctorInfo(DoctorInfos doctorInfo) {
		
		return dao.updateDoctorInfo(sqlSession, doctorInfo);
		
	}

	@Override
	public String DoctorsProfessional(int doctorNum) {
		
		return dao.DoctorsProfessional(sqlSession, doctorNum);
		
	}

	@Override
	public int hospitalUpdate(Hospital hospital) {
		
		return dao.hospitalUpdate(sqlSession, hospital);
		
	}

	@Override
	public int FindHosEmailCheck(String memberEmail) {
		
		return dao.FindHosEmailCheck(sqlSession, memberEmail);
		
	}

	@Override
	public int deleteMember(int memberNum) {
		
		return dao.deleteMember(sqlSession, memberNum);
		
	}

	@Override
	public String HospitalFindId(Hospital h) {
		
		return dao.HospitalFindId(sqlSession, h);
		
	}

	@Override
	public Hospital searchHospitalName(String findname) {
		
		return dao.searchHospitalName(sqlSession, findname);
		
	}

	@Override
	public String hospitalNameDoctorNum(int doctorNum) {
		
		return dao.hospitalNameDoctorNum(sqlSession, doctorNum);
		
	}

	@Override
	public Hospital selectFindHospital(String hospitalId) {
		
		return dao.selectFindHospital(sqlSession, hospitalId);
		
	}

	@Override
	public int deleteDoctors(int hospitalNo) {
		
		return dao.deleteDoctors(sqlSession, hospitalNo);
		
	}

	@Override
	public int deleteHospitalInfo(int hospitalInfoNum) {
		
		return dao.deleteHospitalInfo(sqlSession, hospitalInfoNum);
		
	}

	@Override
	public int updateHospital(int hospitalNum) {
		
		return dao.updateHospital(sqlSession, hospitalNum);
		
	}

	@Override
	public String selectHospitalProfessional(String user_id) {
		
		return dao.selectHospitalProfessional(sqlSession, user_id);
		
	}
	
	
}
