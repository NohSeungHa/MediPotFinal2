package com.medi.pot.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.member.model.vo.DoctorInfos;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.HospitalInfos;
import com.medi.pot.member.model.vo.Member;



public interface MemberDAO {
	
	/*아이디중복검사*/
	int duplicateMemIdCheck(SqlSessionTemplate sqlSession, String memberId);
	int checkId(SqlSessionTemplate sqlSession, String memberId);
	int checkHospitalId(SqlSessionTemplate sqlSession, String hospitalId);
	
	/* 이메일 중복검사 */
	int duplicateMemEmailCheck(SqlSessionTemplate sqlSession, String memberEmail);
	int checkEmail(SqlSessionTemplate sqlSession, String memberEmail); // 일반회원
	int checkHospitalEmail(SqlSessionTemplate sqlSession, String HospitalEmail);// 병원회원
	
	/*일반회원*/
	Member loginMemberCheck(SqlSessionTemplate sqlSession, String memberId);
	int insertMember(SqlSessionTemplate sqlSession, Member m);
	int memberPageUpdate(SqlSessionTemplate sqlSession, Member m);
	Member selectMember(SqlSessionTemplate sqlSession, String memberId);
	int memberPwUpdate(SqlSessionTemplate sqlSession, Map<String, String> idpw);
	List<Member> selectMemberList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);
	int selectCount(SqlSessionTemplate sqlSession);
	int deleteMember(SqlSessionTemplate sqlSession, int memberNum);
	
	/* 아이디 찾기 */
	int FindMemEmailCheck(SqlSessionTemplate sqlSession, String memberEmail);
	String MemberFindId(SqlSessionTemplate sqlSession, Member m);
	Member searchMemberName(SqlSessionTemplate sqlSession, String findname);
	
	int FindHosEmailCheck(SqlSessionTemplate sqlSession, String memberEmail);
	String HospitalFindId(SqlSessionTemplate sqlSession, Hospital h);
	Hospital searchHospitalName(SqlSessionTemplate sqlSession, String findname);
	
	/* 비밀번호 찾기 */
	Member searchID(SqlSessionTemplate sqlSession, String findid);
	int MemberUpdate(SqlSessionTemplate sqlSession, Member m);
	
	/*병원회원*/
	Hospital loginHospitalCheck(SqlSessionTemplate sqlSession, String memberId);
	int insertHospital(SqlSessionTemplate sqlSession, Hospital h);
	List<Hospital> selectHospitalList(SqlSessionTemplate sqlSession, int cPage, int numPerPage);
	int selectHospitalCount(SqlSessionTemplate sqlSession);
	int updateAdmission(SqlSessionTemplate sqlSession, int hospitalNum);
	int hospitalCount(SqlSessionTemplate sqlSession);
	String selecthospitalName(SqlSessionTemplate sqlSession, int hospitalNum);
	Hospital selectHospital(SqlSessionTemplate sqlSession, int hospitalNum);
	int hospitalUpdate(SqlSessionTemplate sqlSession, Hospital hospital);
	Hospital selectFindHospital(SqlSessionTemplate sqlSession, String hospitalId);
	int deleteDoctors(SqlSessionTemplate sqlSession, int hospitalNo);
	int deleteHospitalInfo(SqlSessionTemplate sqlSession, int hospitalInfoNum);
	int updateHospital(SqlSessionTemplate sqlSession, int hospitalNum);
	
	/* 병원정보 */
	int hospitalInfoinsert(SqlSessionTemplate sqlSession, HospitalInfos hospitalInfo);
	HospitalInfos selectHospitalInfo(SqlSessionTemplate sqlSession, int hospitalNum);
	int loadHospitalInfo(SqlSessionTemplate sqlSession, int hospitalNum);
	int updateHospitalInfo(SqlSessionTemplate sqlSession, HospitalInfos hospitalInfo);
	
	/* 의사정보 */
	List<DoctorInfos> selectDoctorInfo(SqlSessionTemplate sqlSession, int hospitalNum);
	int doctorInfoInsert(SqlSessionTemplate sqlSession, DoctorInfos doctorInfo);
	DoctorInfos selectDoctorPhoto(SqlSessionTemplate sqlSession, int doctorNum);
	int updateDoctorInfo(SqlSessionTemplate sqlSession, DoctorInfos doctorInfo);
	String DoctorsProfessional(SqlSessionTemplate sqlSession, int doctorNum);
	String hospitalNameDoctorNum(SqlSessionTemplate sqlSession, int doctorNum);
	
}
