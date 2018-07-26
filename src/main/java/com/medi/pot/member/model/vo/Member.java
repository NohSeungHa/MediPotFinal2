package com.medi.pot.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberBirth;
	private String memberPhone;
	private String memberEmail;
	private String memberAddr;
	private Date memberDate;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public Date getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public Member() {}
	public Member(String memberId, String memberPw, String memberName, String memberGender, String memberBirth,
			String memberPhone, String memberEmail, String memberAddr, Date memberDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
		this.memberDate = memberDate;
	}
	
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone
				+ ", memberEmail=" + memberEmail + ", memberAddr=" + memberAddr + ", memberDate=" + memberDate + "]";
	}
	
	
	
}
