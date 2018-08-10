package com.medi.pot.community.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.community.dao.CommunityDAO;
import com.medi.pot.community.vo.Community;
import com.medi.pot.community.vo.CommunityComment;

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
	
	//자유게시판 글 삭제
	@Override
	public int deleteCommunity(int no) {
		return communityDAO.deleteCommunity(sqlsession,no);
	}
	
	//자유게시판 글 수정
	@Override
	public int updateCommunity(Community com) {
		return communityDAO.updateCommunity(sqlsession,com);
	}
	
	//자유게시판 title 검색
	@Override
	public List<Community> selectTitleSearch(int cPage, int numPerPage, String searchContent) {
		return communityDAO.selectTitleSearch(sqlsession,cPage,numPerPage,searchContent);
	}

	//자유게시판 content 검색
	@Override
	public List<Community> selectContentSearch(int cPage, int numPerPage, String searchContent) {
		return communityDAO.selectContentSearch(sqlsession,cPage,numPerPage,searchContent);
	}

	//자유게시판 writer 검색
	@Override
	public List<Community> selectWriterSearch(int cPage, int numPerPage, String searchContent) {
		return communityDAO.selectWriterSearch(sqlsession,cPage,numPerPage,searchContent);
	}

	//자유게시판 title 검색 count
	@Override
	public int selectTitleSearchCount(String searchContent) {
		return communityDAO.selectTitleSearchCount(sqlsession, searchContent);
	}

	//자유게시판 content 검색 count
	@Override
	public int selectContentSearchCount(String searchContent) {
		return communityDAO.selectContentSearchCount(sqlsession, searchContent);
	}

	//자유게시판 writer 검색 count
	@Override
	public int selectWriterSearchCount(String searchContent) {
		return communityDAO.selectWriterSearchCount(sqlsession, searchContent);
	}
	
	//자유게시판 댓글 insert
	@Override
	public int insertCommunityComment(CommunityComment cc1) {
		return communityDAO.insertCommunityComment(sqlsession,cc1);
	}

	//자유게시판 댓글 List
	@Override
	public List<CommunityComment> selectListCommunityComment(int cPage,int numPerPage,int no) {
		return communityDAO.selectListCommunityComment(sqlsession,cPage,numPerPage,no);
	}

	//자유게시판 마지막 댓글
	@Override
	public CommunityComment selectOneCommunityComment() {
		return communityDAO.selectOneCommunityComment(sqlsession);
	}
	
	//자유게시판 댓글 갯수
	@Override
	public int communityCommentCount(int no) {
		return communityDAO.communityCommentCount(sqlsession,no);
	}
	
	//자유게시판 게시글 삭제시 댓글 List삭제
	@Override
	public void deleteCommunityCommentList(int no) {
		communityDAO.deleteCommunityCommentList(sqlsession,no);
	}

	//자유게시판 댓글 삭제
	@Override
	public int deleteComment(int num) {
		return communityDAO.deleteComment(sqlsession,num);
	}
}