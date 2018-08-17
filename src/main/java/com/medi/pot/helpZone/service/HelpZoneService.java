package com.medi.pot.helpZone.service;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
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
	List<HelpZoneCommentHospital> selectHospitalList(int cPage, int numPerPage, int no);	//병원회원 댓글 리스트 불러오기
	
}
