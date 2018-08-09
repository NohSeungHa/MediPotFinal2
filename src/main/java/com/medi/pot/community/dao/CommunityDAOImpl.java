package com.medi.pot.community.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.community.vo.Community;
import com.medi.pot.community.vo.CommunityComment;

@Repository
public class CommunityDAOImpl implements CommunityDAO {

	//자유게시판 List 불러오기!
	@Override
	public List<Community> selectList(SqlSessionTemplate sqlsession, int cPage, int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("community.selectList",null,rb);
	}
	
	//자유게시판 전체 갯수
	@Override
	public int selectCount(SqlSessionTemplate sqlsession) {
		return sqlsession.selectOne("community.selectCount");
	}
	
	//자유게시판 글작성
	@Override
	public int insertCommunity(SqlSessionTemplate sqlsession, Community com) {
		return sqlsession.insert("community.insertCommunity", com);
	}
	
	//자유게시판 조회수 증가
	@Override
	public void updateCount(SqlSessionTemplate sqlsession, int no) {
		sqlsession.update("community.updateCount",no);
		
	}
	
	//자유게시판 view 불러오기
	@Override
	public Community selectOneCommunity(SqlSessionTemplate sqlsession, int no) {
		return sqlsession.selectOne("community.selectOneCommunity",no);
	}
	
	//자유게시판 제목 검색
	@Override
	public List searchTitleNumber(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectList("community.searchTitleNumber", searchContent);
	}
	
	//자유게시판 내용 검색
	@Override
	public List searchContentNumber(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectList("community.searchContentNumber", searchContent);
	}
	
	//자유게시판 작성자 검색
	@Override
	public List searchWriterNumber(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectList("community.searchWriterNumber", searchContent);
	}
	
	//자유게시판 전체 번호
	@Override
	public List selectCommunityNumber(SqlSessionTemplate sqlsession) {
		return sqlsession.selectList("community.selectCommunityNumber");
	}
	
	//자유게시판 글 삭제
	@Override
	public int deleteCommunity(SqlSessionTemplate sqlsession, int no) {
		return sqlsession.delete("community.deleteCommunity",no);
	}
	
	//자유게시판 글 수정
	@Override
	public int updateCommunity(SqlSessionTemplate sqlsession, Community com) {
		return sqlsession.update("community.updateCommunity",com);
	}
	
	//자유게시판 title 검색
	@Override
	public List<Community> selectTitleSearch(SqlSessionTemplate sqlsession, int cPage, int numPerPage,
			String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("community.selectTitleSearch",searchContent,rb);
	}

	//자유게시판 content 검색
	@Override
	public List<Community> selectContentSearch(SqlSessionTemplate sqlsession, int cPage, int numPerPage,
			String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("community.selectContentSearch",searchContent,rb);
	}
	
	//자유게시판 writer 검색
	@Override
	public List<Community> selectWriterSearch(SqlSessionTemplate sqlsession, int cPage, int numPerPage,
			String searchContent) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("community.selectWriterSearch",searchContent,rb);
	}

	//자유게시판 title 검색 count
	@Override
	public int selectTitleSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("community.selectTitleSearchCount",searchContent);
	}

	//자유게시판 content 검색 count
	@Override
	public int selectContentSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("community.selectContentSearchCount",searchContent);
	}

	//자유게시판 writer 검색 count
	@Override
	public int selectWriterSearchCount(SqlSessionTemplate sqlsession, String searchContent) {
		return sqlsession.selectOne("community.selectWriterSearchCount",searchContent);
	}
	
	//자유게시판 댓글 insert
	@Override
	public int insertCommunityComment(SqlSessionTemplate sqlsession, CommunityComment cc1) {
		return sqlsession.insert("community.insertCommunityComment",cc1);
	}

	//자유게시판 댓글 List
	@Override
	public List<CommunityComment> selectListCommunityComment(SqlSessionTemplate sqlsession,int cPage,int numPerPage,int no) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlsession.selectList("community.selectListCommunityComment",no,rb);
	}
	
	//자유게시판 마지막 댓글
	@Override
	public CommunityComment selectOneCommunityComment(SqlSessionTemplate sqlsession) {
		return sqlsession.selectOne("community.selectOneCommunityComment");
	}
	
	//자유게시판 댓글 갯수
	@Override
	public int communityCommentCount(SqlSessionTemplate sqlsession,int no) {
		return sqlsession.selectOne("community.communityCommentCount", no);
	}
}