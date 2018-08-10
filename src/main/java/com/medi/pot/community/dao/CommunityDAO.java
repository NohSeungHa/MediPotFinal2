package com.medi.pot.community.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.community.vo.Community;
import com.medi.pot.community.vo.CommunityComment;

public interface CommunityDAO {
	
	//자유게시판 List불러오기!
	List<Community> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage);
	
	//자유게시판 전체 갯수
	int selectCount(SqlSessionTemplate sqlsession);

	//자유게시판 글작성
	int insertCommunity(SqlSessionTemplate sqlsession,Community com);
	
	//자유게시판 조회수 증가
	void updateCount(SqlSessionTemplate sqlsession,int no);
	
	//자유게시판 view 불러오기
	Community selectOneCommunity(SqlSessionTemplate sqlsession,int no);
	
	//자유게시판 제목 검색
	List searchTitleNumber(SqlSessionTemplate sqlsession,String searchContent);
	
	//자유게시판 내용 검색
	List searchContentNumber(SqlSessionTemplate sqlsession,String searchContent);
	
	//자유게시판 작성자 검색
	List searchWriterNumber(SqlSessionTemplate sqlsession,String searchContent);
	
	//자유게시판 전체 번호
	List selectCommunityNumber(SqlSessionTemplate sqlsession);
	
	//자유게시판 글 삭제
	int deleteCommunity(SqlSessionTemplate sqlsession,int no);
	
	//자유게시판 글 수정
	int updateCommunity(SqlSessionTemplate sqlsession,Community com);
	
	//자유게시판 검색 title
	List<Community> selectTitleSearch(SqlSessionTemplate sqlsession, int cPage,int numPerPage,String searchContent);
		
	//자유게시판 검색 content
	List<Community> selectContentSearch(SqlSessionTemplate sqlsession, int cPage,int numPerPage,String searchContent);
		
	//자유게시판 검색 writer
	List<Community> selectWriterSearch(SqlSessionTemplate sqlsession, int cPage,int numPerPage,String searchContent);
		
	//자유게시판 검색 title count
	int selectTitleSearchCount(SqlSessionTemplate sqlsession, String searchContent);
		
	//자유게시판 검색 content count
	int selectContentSearchCount(SqlSessionTemplate sqlsession, String searchContent);
		
	//자유게시판 검색 writer count
	int selectWriterSearchCount(SqlSessionTemplate sqlsession, String searchContent);
	
	//자유게시판 댓글 insert
	int insertCommunityComment(SqlSessionTemplate sqlsession,CommunityComment cc1);
	
	//자유게시판 댓글 List
	List<CommunityComment> selectListCommunityComment(SqlSessionTemplate sqlsession,int cPage,int numPerPage,int no);
	
	//자유게시판 마지막 댓글
	CommunityComment selectOneCommunityComment(SqlSessionTemplate sqlsession);
	
	//자유게시판 댓글 갯수
	int communityCommentCount(SqlSessionTemplate sqlsession,int no);
	
	//자유게시판 삭제시 댓글 List 삭제
	void deleteCommunityCommentList(SqlSessionTemplate sqlsession,int no);
	
	//자유게시판 댓글 삭제
	int deleteComment(SqlSessionTemplate sqlsession,int num);
}


