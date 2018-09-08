package com.kvp.kvp_shop.member.model.vo;

public class NonMember {
	private String memberNo;
	private String memberPassword;
	private String memberName;
	private String memberEmail;
	
	public NonMember() {}

	public NonMember(String memberNo, String memberPassword, String memberName, String memberEmail) {
		super();
		this.memberNo = memberNo;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		return "NonMember [memberNo=" + memberNo + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + "]";
	}
}
