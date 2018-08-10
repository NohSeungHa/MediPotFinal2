package com.medi.pot.community.service;

import java.util.List;

import com.medi.pot.community.vo.Community;
import com.medi.pot.community.vo.CommunityComment;

public interface CommunityService {
	
	//자유게시판 List불러오기!
	List<Community> selectList(int cPage,int numPerPage);
	
	//자유게시판 전체 갯수
	int selectCount();
	
	//자유게시판 글작성
	int insertCommunity(Community com);
	
	//자유게시판 조회수 증가
	void updateCount(int no);
	
	//자유게시판 view 불러오기
	Community selectOneCommunity(int no);
	
	//자유게시판 제목으로 검색후 번호
	List searchTitleNumber(String searchContent);
	
	//자유게시판 내용으로 검색후 번호
	List searchContentNumber(String searchContent);
	
	//자유게시판 작성자로 검색후 번호
	List searchWriterNumber(String searchContent);
	
	//자유게시판 전체 번호
	List selectCommunityNumber();
	
	//자유게시판 글 삭제
	int deleteCommunity(int no);
	
	//자유게시판 글 수정
	int updateCommunity(Community com);
	
	//자유게시판 검색 title
	List<Community> selectTitleSearch(int cPage,int numPerPage,String searchContent);
	
	//자유게시판 검색 content
	List<Community> selectContentSearch(int cPage,int numPerPage,String searchContent);
	
	//자유게시판 검색 writer
	List<Community> selectWriterSearch(int cPage,int numPerPage,String searchContent);
	
	//자유게시판 검색 title count
	int selectTitleSearchCount(String searchContent);
	
	//자유게시판 검색 content count
	int selectContentSearchCount(String searchContent);
	
	//자유게시판 검색 writer count
	int selectWriterSearchCount(String searchContent);
	
	//자유게시판 댓글 insert
	int insertCommunityComment(CommunityComment cc1);
	
	//자유게시판 댓글 List
	List<CommunityComment> selectListCommunityComment(int cPage,int numPerPage,int no);
	
	//자유게시판 마지막 댓글
	CommunityComment selectOneCommunityComment();
	
	//자유게시판 댓글 갯수
	int communityCommentCount(int no);
	
	//자유게시판 삭제시 댓글 List 삭제
	void deleteCommunityCommentList(int no);
	
	//자유게시판 댓글 삭제
	int deleteComment(int num);
}