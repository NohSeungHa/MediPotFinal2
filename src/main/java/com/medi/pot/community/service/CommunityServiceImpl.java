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
}
