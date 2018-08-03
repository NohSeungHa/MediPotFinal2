package com.medi.pot.notice.service;

import java.util.List;

import com.medi.pot.notice.vo.HospitalNotice;
import com.medi.pot.notice.vo.MemberNotice;

public interface NoticeService {
	
	List<HospitalNotice> selectList(int cPage, int numPerPage);
	int insertNotice(HospitalNotice notice);
	HospitalNotice selectOneNotice(int no);
	void updateCount(int no);
	int selectCount();
	List selectNoticeNumber();
	//검색 한 게시글 번호
	List searchTitleNumber(String searchContent);
	List searchContentNumber(String searchContent);
	//게시글 삭제
	int deleteHospitalNotice(int no);
	//게시글 검색 1.제목  2.내용
	List<HospitalNotice> selectTitleSearch(int cPage,int numPerPage,String searchContent);
	List<HospitalNotice> selectContentSearch(int cPage,int numPerPage,String searchContent);
	//게시글 검색 count
	int selectTitleSearchCount(String searchContent);
	int selectContentSearchCount(String searchContent);
	//게시글 수정
	int updateNotice(HospitalNotice notice);
	
	//일반회원,비회원
	List<MemberNotice> selectMemberList(int cPage,int numPerPage);
	int insertMemberNotice(MemberNotice mNotice);
	int selectMemberCount();
	MemberNotice selectOneMemberNotice(int no);
	void updateMemberCount(int no);
	List selectMemberNoticeNumber();
	//검색 한 게시글 번호
	List searchMtitleNumber(String searchContent);
	List searchMcontentNumber(String searchContent);
	//게시글 삭제
	int deleteMemberNotice(int no);
	//게시글 검색 1.제목  2.내용
	List<MemberNotice> selectMtitleSearch(int cPage,int numPerPage,String searchContent);
	List<MemberNotice> selectMcontentSearch(int cPage,int numPerPage,String searchContent);
	//게시글 검색 count
	int selectMtitleSearchCount(String searchContent);
	int selectMcontentSearchCount(String searchContent);
	//게시글 수정
	int updateMemberNotice(MemberNotice mNotice);
}
