package com.medi.pot.helpZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.helpZone.dao.HelpZoneDao;
import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

@Service
public class HelpZoneServiceImpl implements HelpZoneService {
	
	@Autowired
	private HelpZoneDao helpZoneDao; 
	

	//헬프존 입력하기
	@Override
	public int insertHelpZone(HelpZone helpZone) {
		return helpZoneDao.insertHelpZone(helpZone);
	}

	//헬프존 리스트 출력하기
	@Override
	public List<HelpZone> selectHelpZoneList(int cPage, int numPerPage) {
		return helpZoneDao.selectHelpZoneList(cPage, numPerPage);
	}
	
	@Override
	public int selectCount() {
		return helpZoneDao.selectCount();
	}

	@Override
	public HelpZone selectHelpZone(int helpZoneNum) {
		return helpZoneDao.selectHelpZone(helpZoneNum);
	}

	//글불러올 때, 작성자만 불러오는 메서드
	@Override
	public Member selectMember(int helpZoneQuestioner) {
		return helpZoneDao.selectMember(helpZoneQuestioner);
	}

	@Override
	public int deleteHelpZone(int num) {
		return helpZoneDao.deleteHelpZone(num);
	}

	@Override
	public int updateHelpZone(HelpZone helpZone) {
		return helpZoneDao.updateHelpZone(helpZone);
	}

	@Override
	public int insertCommentMember(HelpZoneCommentMember hzMember) {
		return helpZoneDao.insertCommentMember(hzMember);
	}

	@Override
	public int insertCommentHospital(HelpZoneCommentHospital hzHospital) {
		return helpZoneDao.insertCommentHospital(hzHospital);
	}

	@Override
	public List<HelpZoneCommentMember> selectMemberCommentList(int cPage, int numPerPage, int no) {
		return helpZoneDao.selectMemberCommentList(cPage,numPerPage,no);
	}

	@Override
	public List<HelpZoneCommentHospital> selectHospitalCommentList(int cPage, int numPerPage, int no) {
		return helpZoneDao.selectHospitalCommentList(cPage,numPerPage,no);
	}

	//
	@Override
	public int helpZoneCommentCountM(int hzNumM) {
		return helpZoneDao.helpZoneCommentCountM(hzNumM);
	}
	
	@Override
	public int helpZoneCommentCountH(int hzNumH) {
		return helpZoneDao.helpZoneCommentCountH(hzNumH);
	}

	@Override
	public Hospital selectHospital(int hospitalNum) {
		return helpZoneDao.selectHospital(hospitalNum);
	}

	@Override
	public int helpZoneChoice(int hzCommentNumH) {
		return helpZoneDao.helpZoneChoice(hzCommentNumH);
	}

	@Override
	public int commentchoice(int helpZoneNum) {
		return helpZoneDao.commentchoice(helpZoneNum);
	}

	
}
