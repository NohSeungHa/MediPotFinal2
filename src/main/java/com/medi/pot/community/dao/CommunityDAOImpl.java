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
	
	
}