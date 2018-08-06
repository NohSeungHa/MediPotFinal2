package com.medi.pot.community.service;

import java.util.List;

import com.medi.pot.community.vo.Community;

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
	
	//자유게시판 제목으로 검색
	List searchTitleNumber(String searchContent);
	
	//자유게시판 내용으로 검색
	List searchContentNumber(String searchContent);
	
	//자유게시판 작성자로 검색
	List searchWriterNumber(String searchContent);
	
	//자유게시판 전체 번호
	List selectCommunityNumber();
	
	//자유게시판 글 삭제
	int deleteCommunity(int no);
	
	//자유게시판 글 수정
	int updateCommunity(Community com);
	
}
