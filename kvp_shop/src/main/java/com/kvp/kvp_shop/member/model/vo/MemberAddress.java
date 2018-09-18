package com.kvp.kvp_shop.member.model.vo;

import java.sql.Date;

public class MemberAddress {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberGender;
	private String memberBirthday;
	private String memberPhone;
	private String memberEmail;
	private Date memberEnrolldate;
	private Date memberConnect;
	private int memberGrade;
	private int addressNo;
	private String zipCode;
	private String roadAddress;
	private String locAddress;
	private String detailAddress;
	private int addressLevel;
	
	public MemberAddress() {}

	public MemberAddress(String memberId, String memberPassword, String memberName, String memberGender,
			String memberBirthday, String memberPhone, String memberEmail, Date memberEnrolldate, Date memberConnect,
			int memberGrade, int addressNo, String zipCode, String roadAddress, String locAddress, String detailAddress,
			int addressLevel) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberBirthday = memberBirthday;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberEnrolldate = memberEnrolldate;
		this.memberConnect = memberConnect;
		this.memberGrade = memberGrade;
		this.addressNo = addressNo;
		this.zipCode = zipCode;
		this.roadAddress = roadAddress;
		this.locAddress = locAddress;
		this.detailAddress = detailAddress;
		this.addressLevel = addressLevel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
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

	public Date getMemberEnrolldate() {
		return memberEnrolldate;
	}

	public void setMemberEnrolldate(Date memberEnrolldate) {
		this.memberEnrolldate = memberEnrolldate;
	}

	public Date getMemberConnect() {
		return memberConnect;
	}

	public void setMemberConnect(Date memberConnect) {
		this.memberConnect = memberConnect;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getLocAddress() {
		return locAddress;
	}

	public void setLocAddress(String locAddress) {
		this.locAddress = locAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public int getAddressLevel() {
		return addressLevel;
	}

	public void setAddressLevel(int addressLevel) {
		this.addressLevel = addressLevel;
	}

	@Override
	public String toString() {
		return "MemberAddress [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName="
				+ memberName + ", memberGender=" + memberGender + ", memberBirthday=" + memberBirthday
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberEnrolldate="
				+ memberEnrolldate + ", memberConnect=" + memberConnect + ", memberGrade=" + memberGrade
				+ ", addressNo=" + addressNo + ", zipCode=" + zipCode + ", roadAddress=" + roadAddress + ", locAddress="
				+ locAddress + ", detailAddress=" + detailAddress + ", addressLevel=" + addressLevel + "]";
	}
}
