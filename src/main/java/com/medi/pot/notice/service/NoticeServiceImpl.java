package com.medi.pot.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.pot.notice.dao.NoticeDAO;
import com.medi.pot.notice.vo.HospitalNotice;
import com.medi.pot.notice.vo.MemberNotice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	
	
	
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<HospitalNotice> selectList(int cPage, int numPerPage) {
		return noticeDAO.selectList(sqlsession,cPage,numPerPage);
	}
	@Override
	public int insertNotice(HospitalNotice notice) {
		System.out.println("1"+notice);
		return noticeDAO.insertNotice(sqlsession,notice);
	}
	@Override
	public HospitalNotice selectOneNotice(int no) {
		return noticeDAO.selectOneNotice(sqlsession,no);
	}
	@Override
	public void updateCount(int no) {
		noticeDAO.updateCount(sqlsession,no);
	}
	@Override
	public int selectCount() {
		return noticeDAO.selectCount(sqlsession);
	}
	@Override
	public List selectNoticeNumber() {
		return noticeDAO.selectNoticeNumber(sqlsession);
	}
	//검색 한 게시글 번호
	@Override
	public List searchTitleNumber(String searchContent) {
		return noticeDAO.searchTitleNumber(sqlsession,searchContent);
	}
	@Override
	public List searchContentNumber(String searchContent) {
		return noticeDAO.searchContentNumber(sqlsession,searchContent);
	}
	//게시글 삭제
	@Override
	public int deleteHospitalNotice(int no) {
		return noticeDAO.deleteHospitalNotice(sqlsession,no);
	}
	//게시글 검색 1.제목 2.내용
	@Override
	public List<HospitalNotice> selectTitleSearch(int cPage,int numPerPage,String searchContent) {
		return noticeDAO.selectTitleSearch(sqlsession,cPage,numPerPage,searchContent);
	}
	@Override
	public List<HospitalNotice> selectContentSearch(int cPage,int numPerPage,String searchContent) {
		return noticeDAO.selectContentSearch(sqlsession,cPage,numPerPage,searchContent);
	}
	//게시글 검색 count
	@Override
	public int selectTitleSearchCount(String searchContent) {
		return noticeDAO.selectTitleSearchCount(sqlsession,searchContent);
	}
	@Override
	public int selectContentSearchCount(String searchContent) {
		return noticeDAO.selectContentSearchCount(sqlsession,searchContent);
	}
	//게시글 수정
	@Override
	public int updateNotice(HospitalNotice notice) {
		return noticeDAO.updateNotice(sqlsession,notice);
	}
	
	
	
	
	//일반회원,비회원
	@Override
	public List<MemberNotice> selectMemberList(int cPage, int numPerPage) {
		return noticeDAO.selectMemberList(sqlsession,cPage,numPerPage);
	}
	@Override
	public int selectMemberCount() {
		return noticeDAO.selectMemberCount(sqlsession);
	}
	@Override
	public MemberNotice selectOneMemberNotice(int no) {
		return noticeDAO.selectOneMemberNotice(sqlsession,no);
	}
	@Override
	public List selectMemberNoticeNumber() {
		return noticeDAO.selectMemberNoticeNumber(sqlsession);
	}
	@Override
	public void updateMemberCount(int no) {
		noticeDAO.updateMemberCount(sqlsession,no);
	}
	@Override
	public int deleteMemberNotice(int no) {
		return noticeDAO.deleteMemberNotice(sqlsession,no);
	}
	@Override
	public int insertMemberNotice(MemberNotice mNotice) {
		return noticeDAO.insertMemberNotice(sqlsession,mNotice);
	}
	//게시글 검색 1.제목 2.내용
	@Override
	public List<MemberNotice> selectMtitleSearch(int cPage, int numPerPage, String searchContent) {
		return noticeDAO.selectMtitleSearch(sqlsession,cPage,numPerPage,searchContent);
	}
	@Override
	public List<MemberNotice> selectMcontentSearch(int cPage, int numPerPage, String searchContent) {
		return noticeDAO.selectMcontentSearch(sqlsession,cPage,numPerPage,searchContent);
	}
	//게시글 검색 count
	@Override
	public int selectMtitleSearchCount(String searchContent) {
		return noticeDAO.selectMtitleSearchCount(sqlsession,searchContent);
	}
	@Override
	public int selectMcontentSearchCount(String searchContent) {
		return noticeDAO.selectMcontentSearchCount(sqlsession,searchContent);
	}
	//검색 한 게시글 번호
	@Override
	public List searchMtitleNumber(String searchContent) {
		return noticeDAO.searchMtitleNumber(sqlsession,searchContent);
	}
	@Override
	public List searchMcontentNumber(String searchContent) {
		return noticeDAO.searchMcontentNumber(sqlsession,searchContent);
	}
	//게시글 수정
	@Override
	public int updateMemberNotice(MemberNotice mNotice) {
		return noticeDAO.updateMemberNotice(sqlsession,mNotice);
	}
}
