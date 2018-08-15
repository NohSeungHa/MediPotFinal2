package com.medi.pot.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.notice.vo.HospitalNotice;
import com.medi.pot.notice.vo.MemberNotice;

public interface NoticeDAO {
	
	//병원
	List<HospitalNotice> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage);
	int insertNotice(SqlSessionTemplate sqlsession,HospitalNotice notice);
	HospitalNotice selectOneNotice(SqlSessionTemplate sqlsession,int no);
	void updateCount(SqlSessionTemplate sqlsession,int no);
	int selectCount(SqlSessionTemplate sqlsession);
	List selectNoticeNumber(SqlSessionTemplate sqlsession);
	//검색한 게시글 번호
	List searchTitleNumber(SqlSessionTemplate sqlsession,String searchContent);
	List searchContentNumber(SqlSessionTemplate sqlsession,String searchContent);
	//게시글 삭제
	int deleteHospitalNotice(SqlSessionTemplate sqlSession,int no);
	//게시글 검색 1.제목  2.내용
	List<HospitalNotice> selectTitleSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent);
	List<HospitalNotice> selectContentSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent);
	//게시글 검색 count
	int selectTitleSearchCount(SqlSessionTemplate sqlsession,String searchContent);
	int selectContentSearchCount(SqlSessionTemplate sqlsession,String searchContent);
	//게시글 수정
	int updateNotice(SqlSessionTemplate sqlsession,HospitalNotice notice);
	
	
	//일반회원,비회원
	List<MemberNotice> selectMemberList(SqlSessionTemplate sqlsession,int cPage,int numPerPage);
	int insertMemberNotice(SqlSessionTemplate sqlsession,MemberNotice mNotice);
	int selectMemberCount(SqlSessionTemplate sqlsession);
	MemberNotice selectOneMemberNotice(SqlSessionTemplate sqlSession,int no);
	void updateMemberCount(SqlSessionTemplate sqlsession,int no);
	List selectMemberNoticeNumber(SqlSessionTemplate sqlsession);
	//검색한 게시글 번호
	List searchMtitleNumber(SqlSessionTemplate sqlsession,String searchContent);
	List searchMcontentNumber(SqlSessionTemplate sqlsession,String searchContent);
	//게시글 삭제
	int deleteMemberNotice(SqlSessionTemplate sqlSession,int no);
	//게시글 검색 1.제목  2.내용
	List<MemberNotice> selectMtitleSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent);
	List<MemberNotice> selectMcontentSearch(SqlSessionTemplate sqlSession,int cPage,int numPerPage,String searchContent);
	//게시글 검색 count
	int selectMtitleSearchCount(SqlSessionTemplate sqlsession,String searchContent);
	int selectMcontentSearchCount(SqlSessionTemplate sqlsession,String searchContent);
	//게시글 수정
	int updateMemberNotice(SqlSessionTemplate sqlsession,MemberNotice mNotice);
}
