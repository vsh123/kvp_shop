package com.kvp.kvp_shop.purchase.model.vo;

import java.sql.Date;

public class Purchase {
	private int purchaseNo;
	private String isbn;
	private int bookAmount;
	private Date purchaseDate;
	private String zipCode;
	private String roadAddress;
	private String locAddress;
	private String detailAddress;
	private String purchaseCode;
	private String isOld;
	private Date cancelDate;
	
	public Purchase() {}

	public Purchase(int purchaseNo, String isbn, int bookAmount, Date purchaseDate, String zipCode, String roadAddress,
			String locAddress, String detailAddress, String purchaseCode, String isOld, Date cancelDate) {
		super();
		this.purchaseNo = purchaseNo;
		this.isbn = isbn;
		this.bookAmount = bookAmount;
		this.purchaseDate = purchaseDate;
		this.zipCode = zipCode;
		this.roadAddress = roadAddress;
		this.locAddress = locAddress;
		this.detailAddress = detailAddress;
		this.purchaseCode = purchaseCode;
		this.isOld = isOld;
		this.cancelDate = cancelDate;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getIsOld() {
		return isOld;
	}

	public void setIsOld(String isOld) {
		this.isOld = isOld;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseNo=" + purchaseNo + ", isbn=" + isbn + ", bookAmount=" + bookAmount
				+ ", purchaseDate=" + purchaseDate + ", zipCode=" + zipCode + ", roadAddress=" + roadAddress
				+ ", locAddress=" + locAddress + ", detailAddress=" + detailAddress + ", purchaseCode=" + purchaseCode
				+ ", isOld=" + isOld + ", cancelDate=" + cancelDate + "]";
	}
}
