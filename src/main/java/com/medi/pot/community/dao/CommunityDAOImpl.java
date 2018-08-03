package com.medi.pot.community.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.community.vo.Community;

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
}