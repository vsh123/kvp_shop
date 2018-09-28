package com.kvp.kvp_shop.member.model.vo;

public class Address {
	private int addressNo;
	private String memberId;
	private String zipCode;
	private String roadAddress;
	private String locAddress;
	private String detailAddress;
	private int addressLevel;
	
	public Address() {}

	public Address(int addressNo, String memberId, String zipCode, String roadAddress, String locAddress,
			String detailAddress, int addressLevel) {
		super();
		this.addressNo = addressNo;
		this.memberId = memberId;
		this.zipCode = zipCode;
		this.roadAddress = roadAddress;
		this.locAddress = locAddress;
		this.detailAddress = detailAddress;
		this.addressLevel = addressLevel;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "Address [addressNo=" + addressNo + ", memberId=" + memberId + ", zipCode=" + zipCode + ", roadAddress="
				+ roadAddress + ", locAddress=" + locAddress + ", detailAddress=" + detailAddress + ", addressLevel="
				+ addressLevel + "]";
	}
}
