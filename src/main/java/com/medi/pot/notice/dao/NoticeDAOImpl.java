package com.medi.pot.notice.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.notice.vo.HospitalNotice;
import com.medi.pot.notice.vo.MemberNotice;

@Repository
public class NoticeDAOImpl implements NoticeDAO {


	
	
	
	
	@Override
	public List<HospitalNotice> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("notice.hospitalNoticeList",null,rb);
	}
	@Override
	public int insertNotice(SqlSessionTemplate sqlsession, HospitalNotice notice) {
		System.out.println("2"+notice);
		System.out.println(notice.getHospitalNoticeRefile());
		return sqlsession.insert("notice.hospitalNoticeInsert",notice);
	}
	@Override
	public HospitalNotice selectOneNotice(SqlSessionTemplate sqlsession, int no) {
		return sqlsession.selectOne("notice.selectOneNotice", no);
	}
	
	@Override
	public void updateCount(SqlSessionTemplate sqlsession, int no) {
		sqlsession.update("notice.updateCount", no);
		
	}
	@Override
	public int selectCount(SqlSessionTemplate sqlsession) {
		return sqlsession.selectOne("notice.selectCount");
	}
	@Override
	public List selectNoticeNumber(SqlSessionTemplate sqlsession) {
		return sqlsession.selectList("notice.selectNoticeNumber");
	}
	//검색한 게시글 번호
	@Override
	public List searchTitleNumber(SqlSessionTemplate sqlsession,String searchContent) {
		return sqlsession.selectList("notice.searchTitleNumber",searchContent);
	}
	@Override
	public List searchContentNumber(SqlSessionTemplate sqlsession,String searchContent) {
		return sqlsession.selectList("notice.searchContentNumber",searchContent);
	}
	//게시글 삭제
	@Override
	public int deleteHospitalNotice(SqlSessionTemplate sqlSession, int no) {
		return sqlSession.delete("notice.deleteHospitalNotice",no);
	}
	//게시글 검색 1.제목 2.내용
	@Override
	public List<HospitalNotice> selectTitleSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("notice.selectTitleSearch",searchContent,rb);
	}
	@Override
	public List<HospitalNotice> selectContentSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("notice.selectContentSearch",searchContent,rb);
	}
	//게시글 검색 count
	@Override
	public int selectTitleSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("notice.selectTitleSearchCount",searchContent);
	}
	@Override
	public int selectContentSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("notice.selectContentSearchCount",searchContent);
	}
	//게시글 수정
	@Override
	public int updateNotice(SqlSessionTemplate sqlsession, HospitalNotice notice) {
		return sqlsession.update("notice.updateNotice", notice);
	}
	
	
	
	//여기서부턴 일반회원,비회원
	@Override
	public List<MemberNotice> selectMemberList(SqlSessionTemplate sqlsession, int cPage, int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("notice.memberNoticeList",null,rb);
	}
	@Override
	public int selectMemberCount(SqlSessionTemplate sqlsession) {
		return sqlsession.selectOne("notice.selectMemberCount");
	}
	@Override
	public MemberNotice selectOneMemberNotice(SqlSessionTemplate sqlSession, int no) {
		return sqlSession.selectOne("notice.selectOneMemberNotice", no);
	}
	@Override
	public List selectMemberNoticeNumber(SqlSessionTemplate sqlsession) {
		return sqlsession.selectList("notice.selectMemberNoticeNumber");
	}
	@Override
	public void updateMemberCount(SqlSessionTemplate sqlsession, int no) {
		System.out.println("여기"+no);
		sqlsession.update("notice.updateMemberCount", no);
	}
	//게시글 삭제
	@Override
	public int deleteMemberNotice(SqlSessionTemplate sqlSession, int no) {
		return sqlSession.delete("notice.deleteMemberNotice",no);
	}
	@Override
	public int insertMemberNotice(SqlSessionTemplate sqlsession, MemberNotice mNotice) {
		return sqlsession.insert("notice.insertMemberNotice", mNotice);
	}
	//게시글 검색 1.제목 2.내용
	@Override
	public List<MemberNotice> selectMtitleSearch(SqlSessionTemplate sqlSession, int cPage, int numPerPage,
			String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("notice.selectMtitleSearch",searchContent,rb);
	}
	@Override
	public List<MemberNotice> selectMcontentSearch(SqlSessionTemplate sqlSession, int cPage, int numPerPage,
			String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("notice.selectMcontentSearch",searchContent,rb);
	}
	//게시글 검색 count
	@Override
	public int selectMtitleSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("notice.selectMtitleSearchCount",searchContent);
	}
	@Override
	public int selectMcontentSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("notice.selectMcontentSearchCount",searchContent);
	}
	//검색한 게시글 번호
	@Override
	public List searchMtitleNumber(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectList("notice.searchMtitleNumber",searchContent);
	}
	@Override
	public List searchMcontentNumber(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectList("notice.searchMcontentNumber",searchContent);
	}
	//게시글 수정
	@Override
	public int updateMemberNotice(SqlSessionTemplate sqlsession, MemberNotice mNotice) {
		return sqlsession.update("notice.updateMemberNotice", mNotice);
	}
}
