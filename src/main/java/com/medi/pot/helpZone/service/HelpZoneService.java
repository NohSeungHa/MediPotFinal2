package com.medi.pot.helpZone.service;

import java.util.List;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.member.model.vo.Member;

public interface HelpZoneService {
	
	int insertHelpZone(HelpZone helpZone);							//헬프존 입력하기
	List<HelpZone> selectHelpZoneList(int cPage, int numPerPage);	//헬프존 리스트 출력하기
	int selectCount();
	HelpZone selectHelpZone(int helpZoneNum);						//글 한개 가져오기
	Member selectMember(int helpZoneQuestioner);					//작성자 불러오기
	int deleteHelpZone(int num);									//글 삭제하기
	int updateHelpZone(HelpZone helpZone);							//글 업데이트 하기
	
}
