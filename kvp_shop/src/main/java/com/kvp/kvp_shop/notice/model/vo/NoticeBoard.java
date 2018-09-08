package com.kvp.kvp_shop.notice.model.vo;

import java.sql.Date;

public class NoticeBoard {
	private int noticeNo;
	private String memberId;
	private Date noticeDate;
	private String noticeTitle;
	private String noticeContent;
	
	public NoticeBoard() {}

	public NoticeBoard(int noticeNo, String memberId, Date noticeDate, String noticeTitle, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.memberId = memberId;
		this.noticeDate = noticeDate;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Override
	public String toString() {
		return "NoticeBoard [noticeNo=" + noticeNo + ", memberId=" + memberId + ", noticeDate=" + noticeDate
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + "]";
	}
}
