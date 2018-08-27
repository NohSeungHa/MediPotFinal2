package com.medi.pot.helpZone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

@Repository
public class HelpZoneDaoImpl implements HelpZoneDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int insertHelpZone(HelpZone helpZone) {
		return session.insert("helpZone.helpZoneInsert", helpZone);
	}

	@Override
	public List<HelpZone> selectHelpZoneList(int cPage, int numPerPage) {
		RowBounds rowBounds=new RowBounds(((cPage-1)*numPerPage),numPerPage);
		// 댓글 수 확인
		List<Integer> listNo = session.selectList("helpZone.listNo");
		if(listNo.size() != 0) {
			for(int i=0; i<listNo.size(); i++) {
				int number = listNo.get(i);
				int commentCountM = session.selectOne("helpZone.commentCountM", number);
				int commentCountH = session.selectOne("helpZone.commentCountH", number);
				int totalCount = commentCountH + commentCountM;
				Map<String, Integer> map = new HashMap();
				map.put("number", number);
				map.put("totalCount", totalCount);
				session.update("helpZone.commentCountUpdate", map);
			}
		}
		return session.selectList("helpZone.helpZoneSelectList", null, rowBounds);
	}
	
	@Override
	public int selectCount() {
		return session.selectOne("helpZone.count");
	}

	@Override
	public HelpZone selectHelpZone(int helpZoneNum) {
		return session.selectOne("helpZone.selectHelpZone", helpZoneNum);
	}

	@Override
	public Member selectMember(int helpZoenQuestioner) {
		return session.selectOne("helpZone.selectMember", helpZoenQuestioner);
	}

	@Override
	public int deleteHelpZone(int num) {
		return session.delete("helpZone.deleteHelpZone", num);
	}

	@Override
	public int updateHelpZone(HelpZone helpZone) {		
		return session.update("helpZone.updateHelpZone",helpZone);
	}
	
	//일반회원 댓글 insert
	@Override
	public int insertCommentMember(HelpZoneCommentMember hzMember) {
		return session.insert("helpZone.insertCommentMember", hzMember);
	}
	
	//병원회원 댓글 insert
	@Override
	public int insertCommentHospital(HelpZoneCommentHospital hzHospital) {
		return session.insert("helpZone.insertCommentHospital", hzHospital);
	}

	@Override
	public List<HelpZoneCommentMember> selectMemberCommentList(int cPage, int numPerPage, int no) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("helpZone.selectMemberCommentList", no, rb);
	}

	@Override
	public List<HelpZoneCommentHospital> selectHospitalCommentList(int cPage, int numPerPage, int no) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("helpZone.selectHospitalCommentList", no, rb);
	}

	//댓글 개수
	@Override
	public int helpZoneCommentCountM(int hzNumM) {
		return session.selectOne("helpZone.helpZoneCommentCountM", hzNumM);
	}
	
	//댓글 개수
		@Override
		public int helpZoneCommentCountH(int hzNumH) {
			return session.selectOne("helpZone.helpZoneCommentCountH", hzNumH);
		}

	@Override
	public Hospital selectHospital(int hospitalNum) {
		return session.selectOne("helpZone.selectHospital", hospitalNum);
	}

	@Override
	public int helpZoneChoice(HelpZoneCommentHospital helpZoneCommentHospital) {
		return session.update("helpZone.helpZoneChoice", helpZoneCommentHospital);
	}

	@Override
	public HelpZoneCommentHospital commentchoice(int helpZoneNum) {
		return session.selectOne("helpZone.commentchoice", helpZoneNum);
	}

	@Override
	public int hospitalAddLike(HelpZoneCommentHospital helpZoneCommentHospital) {
		return session.update("helpZone.hospitalAddLike", helpZoneCommentHospital);
	}

	@Override
	public int deleteHelpZoneCommentM(HelpZoneCommentMember helpZoneCommentMember) {
		return session.delete("helpZone.deleteHelpZoneCommentM", helpZoneCommentMember);
	}

	@Override
	public int deleteHelpZoneCommentH(HelpZoneCommentHospital helpZoneCommentHospital) {
		return session.delete("helpZone.deleteHelpZoneCommentH", helpZoneCommentHospital);
	}

	@Override
	public int selectTitleSearchCount(String searchContent) {
		return session.selectOne("helpZone.selectTitleSearchCount", searchContent);
	}

	@Override
	public int selectContentSearchCount(String searchContent) {
		return session.selectOne("helpZone.selectContentSearchCount", searchContent);
	}

	@Override
	public List<HelpZone> selectHelpZoneTitleList(int cPage, int numPerPage, String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("helpZone.selectHelpZoneTitleList", searchContent, rb);
	}

	@Override
	public List<HelpZone> selectHelpZoneContentList(int cPage, int numPerPage, String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return session.selectList("helpZone.selectHelpZoneContentList", searchContent, rb);
	}
	

}
