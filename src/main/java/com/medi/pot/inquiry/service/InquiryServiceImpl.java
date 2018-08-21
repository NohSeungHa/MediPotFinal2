package com.medi.pot.inquiry.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.inquiry.dao.InquiryDao;
import com.medi.pot.inquiry.vo.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService {
	

	@Autowired
	private InquiryDao inquiryDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//1:1 문의 List
	@Override
	public List<Inquiry> InquiryList(Map<String, String> map,int cPage,int numPerPage) {
		return inquiryDAO.InquiryList(sqlSession,map,cPage,numPerPage);
	}
	
	//1:1 문의 totalCount
	@Override
	public int InquiryListTotalCount(Map<String, String> map) {
		return inquiryDAO.InquiryListTotalCount(sqlSession,map);
	}
	
	//1:1 문의 admin 접속시 List
	@Override
	public List<Inquiry> InquiryAdminList(int cPage,int numPerPage) {
		System.out.println("서비스도 온당");
		return inquiryDAO.InquiryAdminList(sqlSession,cPage,numPerPage);
	}
	
	//1:1 문의  admin 접속시  totalCount
	@Override
	public int InquiryAdminListTotalCount() {
		return inquiryDAO.InquiryAdminListTotalCount(sqlSession);
	}
	
	//1:1 문의 insert
	@Override
	public int insertInquiry(Map<String, String> map) {
		return inquiryDAO.insertInquiry(sqlSession,map);
	}

	//1:1 문의에 대한 답변
	@Override
	public int answerInquiry(Map<String, Object> map) {
		return inquiryDAO.answerInquiry(sqlSession,map);
	}

	//1:1 문의 삭제
	@Override
	public int deleteInquiry(int no) {
		return inquiryDAO.deleteInquiry(sqlSession,no);
	}

	//1:1 문의 수정
	@Override
	public int updateInquiry(Map<String, Object> map) {
		return inquiryDAO.updateInquiry(sqlSession,map);
	}
}