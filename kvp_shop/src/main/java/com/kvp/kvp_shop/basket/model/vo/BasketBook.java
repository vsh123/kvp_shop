package com.kvp.kvp_shop.basket.model.vo;

public class BasketBook {
	private int basketNo;
	private String memberId;
	private String isbn;
	private int bookAmount;
	private String writerName;
	private String bookTitle;
	private int bookPrice;
	private int discount;
	private String categoryName;
	private String bookImage;
	
	public BasketBook() {}

	public BasketBook(int basketNo, String memberId, String isbn, int bookAmount, String writerName, String bookTitle,
			int bookPrice, int discount, String categoryName, String bookImage) {
		super();
		this.basketNo = basketNo;
		this.memberId = memberId;
		this.isbn = isbn;
		this.bookAmount = bookAmount;
		this.writerName = writerName;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.discount = discount;
		this.categoryName = categoryName;
		this.bookImage = bookImage;
	}

	public int getBasketNo() {
		return basketNo;
	}

	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "BasketBook [basketNo=" + basketNo + ", memberId=" + memberId + ", isbn=" + isbn + ", bookAmount="
				+ bookAmount + ", writerName=" + writerName + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice
				+ ", discount=" + discount + ", categoryName=" + categoryName + ", bookImage=" + bookImage + "]";
	}
}
