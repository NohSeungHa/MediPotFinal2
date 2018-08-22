package com.medi.pot.helpZone.service;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

public interface HelpZoneService {
	
	int insertHelpZone(HelpZone helpZone);							//헬프존 입력하기
	List<HelpZone> selectHelpZoneList(int cPage, int numPerPage);	//헬프존 리스트 출력하기
	int selectCount();
	HelpZone selectHelpZone(int helpZoneNum);						//글 한개 가져오기
	Member selectMember(int helpZoneQuestioner);					//작성자 불러오기
	int deleteHelpZone(int num);									//글 삭제하기
	int updateHelpZone(HelpZone helpZone);							//글 업데이트 하기
	int insertCommentMember(HelpZoneCommentMember hzMember);		//일반회원 댓글 등록
	int insertCommentHospital(HelpZoneCommentHospital hzHospital);	//병원회원 댓글 등록
	List<HelpZoneCommentMember> selectMemberCommentList(int cPage, int numPerPage, int no);	//일반회원 댓글 리스트 불러오기
	List<HelpZoneCommentHospital> selectHospitalCommentList(int cPage, int numPerPage, int no);	//병원회원 댓글 리스트 불러오기
	int helpZoneCommentCountM(int hzNumM);							//헬프존 댓글 갯수(일반)
	int helpZoneCommentCountH(int hzNumH);							//헬프존 댓글 갯수(병원)
	Hospital selectHospital(int hospitalNum);						// 작성자 불러오기
	int helpZoneChoice(HelpZoneCommentHospital helpZoneCommentHospital); // 업데이트로 채택하기
	int hospitalAddLike(HelpZoneCommentHospital helpZoneCommentHospital); // 채택 후 병원회원의 좋아요 추가
	HelpZoneCommentHospital commentchoice(int helpZoneNum);								// 채택불러오기
	int deleteHelpZoneCommentM(HelpZoneCommentMember helpZoneCommentMember);	// 일반회원 댓글 삭제
	int deleteHelpZoneCommentH(HelpZoneCommentHospital helpZoneCommentHospital);	// 병원회원 댓글 삭제
	
	
}
