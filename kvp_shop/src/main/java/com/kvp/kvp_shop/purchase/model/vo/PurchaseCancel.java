package com.kvp.kvp_shop.purchase.model.vo;

import java.sql.Date;

public class PurchaseCancel {
	private int purchaseNo;
	private String isbn;
	private int bookAmount;
	private Date purchaseDate;
	private Date cancelDate;
	private String memberId;
	
	public PurchaseCancel() {}
	
	public PurchaseCancel(int purchaseNo, String isbn, int bookAmount, Date purchaseDate, Date cancelDate,
			String memberId) {
		super();
		this.purchaseNo = purchaseNo;
		this.isbn = isbn;
		this.bookAmount = bookAmount;
		this.purchaseDate = purchaseDate;
		this.cancelDate = cancelDate;
		this.memberId = memberId;
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

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PurchaseCancel [purchaseNo=" + purchaseNo + ", isbn=" + isbn + ", bookAmount=" + bookAmount
				+ ", purchaseDate=" + purchaseDate + ", cancelDate=" + cancelDate + ", memberId=" + memberId + "]";
	}
}	
