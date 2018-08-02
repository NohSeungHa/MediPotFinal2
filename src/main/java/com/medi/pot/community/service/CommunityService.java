package com.medi.pot.community.service;

import java.util.List;

import com.medi.pot.community.vo.Community;

public interface CommunityService {
	
	//자유게시판 List불러오기!
	List<Community> selectList(int cPage,int numPerPage);
	
	//자유게시판 전체 갯수
	int selectCount();
}
