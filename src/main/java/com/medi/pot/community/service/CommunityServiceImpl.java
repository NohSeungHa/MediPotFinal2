package com.medi.pot.community.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.community.dao.CommunityDAO;
import com.medi.pot.community.vo.Community;

@Service
public class CommunityServiceImpl implements CommunityService {


	

	@Autowired
	private CommunityDAO communityDAO;
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	//자유게시판 List불러오기!
	@Override
	public List<Community> selectList(int cPage, int numPerPage) {
		return communityDAO.selectList(sqlsession,cPage,numPerPage);
	}
	
	//자유게시판 전체 갯수
	@Override
	public int selectCount() {
		return communityDAO.selectCount(sqlsession);
	}
	
	//자유게시판 글작성
	@Override
	public int insertCommunity(Community com) {
		return communityDAO.insertCommunity(sqlsession,com);
	}

	//자유게시판 조회수 증가
	@Override
	public void updateCount(int no) {
		communityDAO.updateCount(sqlsession,no);
	}
	
	//자유게시판 view 불러오기
	@Override
	public Community selectOneCommunity(int no) {
		return communityDAO.selectOneCommunity(sqlsession,no);
	}
	
	//자유게시판 제목 검색
	@Override
	public List searchTitleNumber(String searchContent) {
		return communityDAO.searchTitleNumber(sqlsession,searchContent);
	}
	
	//자유게시판 내용 검색
	@Override
	public List searchContentNumber(String searchContent) {
		return communityDAO.searchContentNumber(sqlsession,searchContent);
	}
	
	//자유게시판 작성자 검색
	@Override
	public List searchWriterNumber(String searchContent) {
		return communityDAO.searchWriterNumber(sqlsession,searchContent);
	}
	
	//자유게시판 전체 번호
	@Override
	public List selectCommunityNumber() {
		return communityDAO.selectCommunityNumber(sqlsession);
	}
}


