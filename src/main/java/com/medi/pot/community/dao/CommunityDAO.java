package com.medi.pot.community.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.community.vo.Community;

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
}


