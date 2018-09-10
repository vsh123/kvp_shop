package com.kvp.kvp_shop.book.model.vo;

public class Book {
	private String isbn;
	private String writerName;
	private String bookTitle;
	private String bookPublisher;
	private String bookIssueDate;
	private int bookPage;
	private int bookPrice;
	private int discount;
	private int categoryNo;
	private String bookImage;
	
	public Book() {}

	public Book(String isbn, String writerName, String bookTitle, String bookPublisher, String bookIssueDate,
			int bookPage, int bookPrice, int discount, int categoryNo, String bookImage) {
		super();
		this.isbn = isbn;
		this.writerName = writerName;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
		this.bookIssueDate = bookIssueDate;
		this.bookPage = bookPage;
		this.bookPrice = bookPrice;
		this.discount = discount;
		this.categoryNo = categoryNo;
		this.bookImage = bookImage;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookIssueDate() {
		return bookIssueDate;
	}

	public void setBookIssueDate(String bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}

	public int getBookPage() {
		return bookPage;
	}

	public void setBookPage(int bookPage) {
		this.bookPage = bookPage;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", writerName=" + writerName + ", bookTitle=" + bookTitle + ", bookPublisher="
				+ bookPublisher + ", bookIssueDate=" + bookIssueDate + ", bookPage=" + bookPage + ", bookPrice="
				+ bookPrice + ", discount=" + discount + ", categoryNo=" + categoryNo + ", bookImage=" + bookImage
				+ "]";
	}
}
