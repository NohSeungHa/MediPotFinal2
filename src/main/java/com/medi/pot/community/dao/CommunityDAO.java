package com.medi.pot.community.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.community.vo.Community;

public interface CommunityDAO {
	
	//자유게시판 List불러오기!
	List<Community> selectList(SqlSessionTemplate sqlsession,int cPage,int numPerPage);
	
	//자유게시판 전체 갯수
	int selectCount(SqlSessionTemplate sqlsession);

}
