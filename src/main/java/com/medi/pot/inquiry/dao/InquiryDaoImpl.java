package com.medi.pot.inquiry.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.medi.pot.inquiry.vo.Inquiry;

@Repository
public class InquiryDaoImpl implements InquiryDao {





	//1:1 문의 List
	@Override
	public List<Inquiry> InquiryList(SqlSessionTemplate sqlSession, Map<String, String> map,int cPage,int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("Inquiry.InquiryList", map,rb);
	}
	
	//1:1 문의 totalCount
	@Override
	public int InquiryListTotalCount(SqlSessionTemplate sqlSession, Map<String, String> map) {
		return sqlSession.selectOne("Inquiry.InquiryListTotalCount", map);
	}
	
	//1:1 문의 admin 접속 시 List
	@Override
	public List<Inquiry> InquiryAdminList(SqlSessionTemplate sqlSession, int cPage, int numPerPage) {
		RowBounds rb=new RowBounds((cPage-1)*numPerPage,numPerPage);
		System.out.println("DAO 오닝");
		return sqlSession.selectList("Inquiry.InquiryAdminList",null,rb);
	}

	//1:1 문의 admin 접속 시 totalCount
	@Override
	public int InquiryAdminListTotalCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Inquiry.InquiryAdminListTotalCount");
	}

	//1:1 문의 insert
	@Override
	public int insertInquiry(SqlSessionTemplate sqlSession, Map<String, String> map) {
		return sqlSession.insert("Inquiry.insertInquiry",map);
	}

	//1:1 문의에 대한 답변
	@Override
	public int answerInquiry(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.update("Inquiry.answerInquiry",map);
	}

	//1:1 문의 삭제
	@Override
	public int deleteInquiry(SqlSessionTemplate sqlSession, int no) {
		return sqlSession.delete("Inquiry.deleteInquiry",no);
	}

	//1:1 문의 수정
	@Override
	public int updateInquiry(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.update("Inquiry.updateInquiry",map);
	}
}
