package com.kvp.kvp_shop.old.model.vo;

import java.sql.Date;

public class OldBoard {
	private int oldNo;
	private String isbn;
	private String memberId;
	private Date oldDate;
	private String oldContent;
	private int oldPrice;
	private String bookCondition;
	private String isSell;
	
	public OldBoard() {}

	public OldBoard(int oldNo, String isbn, String memberId, Date oldDate, String oldContent, int oldPrice,
			String bookCondition, String isSell) {
		super();
		this.oldNo = oldNo;
		this.isbn = isbn;
		this.memberId = memberId;
		this.oldDate = oldDate;
		this.oldContent = oldContent;
		this.oldPrice = oldPrice;
		this.bookCondition = bookCondition;
		this.isSell = isSell;
	}

	public int getOldNo() {
		return oldNo;
	}

	public void setOldNo(int oldNo) {
		this.oldNo = oldNo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getOldDate() {
		return oldDate;
	}

	public void setOldDate(Date oldDate) {
		this.oldDate = oldDate;
	}

	public String getOldContent() {
		return oldContent;
	}

	public void setOldContent(String oldContent) {
		this.oldContent = oldContent;
	}

	public int getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getBookCondition() {
		return bookCondition;
	}

	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}

	public String getIsSell() {
		return isSell;
	}

	public void setIsSell(String isSell) {
		this.isSell = isSell;
	}

	@Override
	public String toString() {
		return "OldBoard [oldNo=" + oldNo + ", isbn=" + isbn + ", memberId=" + memberId + ", oldDate=" + oldDate
				+ ", oldContent=" + oldContent + ", oldPrice=" + oldPrice + ", bookCondition=" + bookCondition
				+ ", isSell=" + isSell + "]";
	}
	
	
}
