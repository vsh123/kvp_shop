package com.kvp.kvp_shop.book.model.dao;

import java.util.ArrayList;

import com.kvp.kvp_shop.book.model.vo.Book;


public interface BookDAO {

	//크롤링
	String[] crawling(String URL) throws Exception ;
	
	//api 받아오기
	void WebConnection(String c);
	
	//json 파싱
	ArrayList<Book> api(String c);
}
