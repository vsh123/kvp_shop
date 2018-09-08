package com.kvp.kvp_shop.basket.model.vo;

public class Basket {
	private int basketNo;
	private String memberId;
	private String isbn;
	private int bookAmount;
	
	public Basket() {}

	public Basket(int basketNo, String memberId, String isbn, int bookAmount) {
		super();
		this.basketNo = basketNo;
		this.memberId = memberId;
		this.isbn = isbn;
		this.bookAmount = bookAmount;
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

	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", memberId=" + memberId + ", isbn=" + isbn + ", bookAmount="
				+ bookAmount + ", getBasketNo()=" + getBasketNo() + ", getMemberId()=" + getMemberId() + ", getIsbn()="
				+ getIsbn() + ", getBookAmount()=" + getBookAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
