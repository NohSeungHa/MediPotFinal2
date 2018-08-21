package com.medi.pot.inquiry.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.medi.pot.inquiry.vo.Inquiry;

public interface InquiryDao {
	
	//1:1 문의 List
	List<Inquiry> InquiryList(SqlSessionTemplate sqlSession,Map<String, String> map,int cPage,int numPerPage);

	//1:1 문의 totalCount
	int InquiryListTotalCount(SqlSessionTemplate sqlSession,Map<String, String> map);
	
	//1:1 문의 List
	List<Inquiry> InquiryAdminList(SqlSessionTemplate sqlSession,int cPage,int numPerPage);

	//1:1 문의 totalCount
	int InquiryAdminListTotalCount(SqlSessionTemplate sqlSession);
	
	//1:1 문의 insert
	int insertInquiry(SqlSessionTemplate sqlSession,Map<String, String> map);
	
	//1:1 문의에 대한 답변
	int answerInquiry(SqlSessionTemplate sqlSession,Map<String, Object> map);
	
	//1:1 문의 삭제
	int deleteInquiry(SqlSessionTemplate sqlSession,int no);
	
	//1:1 문의 수정
	int updateInquiry(SqlSessionTemplate sqlSession,Map<String, Object> map);
}
