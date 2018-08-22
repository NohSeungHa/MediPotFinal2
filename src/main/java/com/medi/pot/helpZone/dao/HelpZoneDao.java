package com.medi.pot.helpZone.dao;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

public interface HelpZoneDao {

	int insertHelpZone(HelpZone helpZone);
	List<HelpZone> selectHelpZoneList(int cPage,int numPerPage);
	int selectCount();
	HelpZone selectHelpZone(int helpZoneNum);
	Member selectMember(int helpZoenQuestioner);
	int deleteHelpZone(int num);
	int updateHelpZone(HelpZone helpZone);
	int insertCommentMember(HelpZoneCommentMember hzMember);
	int insertCommentHospital(HelpZoneCommentHospital hzHospital);
	List<HelpZoneCommentMember> selectMemberCommentList(int cPage, int numPerPage, int no);
	List<HelpZoneCommentHospital> selectHospitalCommentList(int cPage, int numPerPage, int no);
	int helpZoneCommentCountM(int hzNumM);	//댓글 개수 불러오기(일반)
	int helpZoneCommentCountH(int hzNumH);	//댓글 개수 불러오기(병원)
	Hospital selectHospital(int hospitalNum);
	int helpZoneChoice(HelpZoneCommentHospital helpZoneCommentHospital);
	HelpZoneCommentHospital commentchoice(int helpZoneNum);
	int hospitalAddLike(HelpZoneCommentHospital helpZoneCommentHospital);
	int deleteHelpZoneCommentM(HelpZoneCommentMember helpZoneCommentMember);
	int deleteHelpZoneCommentH(HelpZoneCommentHospital helpZoneCommentHospital);
}
