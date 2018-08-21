package com.medi.pot.inquiry.service;

import java.util.List;
import java.util.Map;

import com.medi.pot.inquiry.vo.Inquiry;

public interface InquiryService {
	
	//1:1 문의 List
	List<Inquiry> InquiryList(Map<String, String> map,int cPage,int numPerPage);
	
	//1:1 문의 totalCount
	int InquiryListTotalCount(Map<String, String> map);
	
	//1:1 문의 admin 접속시 List
	List<Inquiry> InquiryAdminList(int cPage,int numPerPage);
		
	//1:1 문의  admin 접속시  totalCount
	int InquiryAdminListTotalCount();
	
	//1:1 문의 insert
	int insertInquiry(Map<String, String> map);
	
	//1:1 문의에 대한 답변
	int answerInquiry(Map<String, Object> map);

	//1:1 문의 삭제
	int deleteInquiry(int no);
	
	//1:1 문의 수정
	int updateInquiry(Map<String, Object> map);
}
