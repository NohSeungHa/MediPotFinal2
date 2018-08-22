package com.medi.pot.member.model.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.member.model.vo.DoctorInfos;
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
	
	/* 일반회원 */
	Member loginMemberCheck(String memberId);
	int insertMember(Member m);
	int memberPageUpdate(Member m);
	Member selectMember(String memberId);
	int memberPwUpdate(Map<String, String> idpw);
	List<Member> selectMemberList(int cPage, int numPerPage);
	int selectCount();
	
	/* 일반회원 탈퇴 */
	List<Integer> selectNoticeNums(String memberId);
	int deleteMember(int memberNum);
	int deleteNoticeComment(int commentNo);
	List<String> selectNoticePhoto(String memberId);
	int deleteNotice(String memberId);
	int deleteInquiry(String memberId);
	
	/* 아이디찾기 */
	int FindMemEmailCheck(String memberEmail);
	String MemberFindId(Member m);
	Member searchMemberName(String findname);
	
	int FindHosEmailCheck(String memberEmail);
	String HospitalFindId(Hospital h);
	Hospital searchHospitalName(String findname);
	
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
	Hospital selectHospital(int hospitalNum);
	String selectHospitalProfessional(String user_id);
	int hospitalUpdate(Hospital hospital);
	Hospital selectFindHospital(String hospitalId);
	
	/* 병원회원 탈퇴 */
	int deleteDoctors(int hospitalNo);
	int deleteHospitalInfo(int hospitalInfoNum);
	int updateHospital(int hospitalNum);
	String selectDoctorPhoto(int hospitalNo);
	String selectHospitalInfoPhoto(int hospitalInfoNum);
	String selectHospitalLicense(int hospitalNum);
	
	/* 병원정보 */
	int hospitalInfoinsert(HospitalInfos hospitalInfo);
	HospitalInfos selectHospitalInfo(int hospitalNum);
	int loadHospitalInfo(int hospitalNum);
	int updateHospitalInfo(HospitalInfos hospitalInfo);
	
	/* 의사정보 */
	List<DoctorInfos> selectDoctorInfo(int hospitalNum); // 전체뽑기
	int doctorInfoInsert(DoctorInfos doctorInfo); // 등록
	DoctorInfos selectDoctorsPhoto(int doctorNum);
	int updateDoctorInfo(DoctorInfos doctorInfo);
	String DoctorsProfessional(int doctorNum);
	String hospitalNameDoctorNum(int doctorNum);
	
}
