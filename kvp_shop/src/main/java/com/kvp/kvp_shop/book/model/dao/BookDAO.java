package com.kvp.kvp_shop.book.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.kvp.kvp_shop.book.model.vo.Book;


public interface BookDAO {

	//책 정보 DB에 삽입
	int insertBook(Book book);
	
	//해당책이 DB에 저장되어있는지 확인
	int existBook(String BookName);
	
	//책 찾기
	Book findBook(String isbn);
}
