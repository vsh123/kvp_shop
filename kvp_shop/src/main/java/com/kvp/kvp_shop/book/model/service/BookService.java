package com.kvp.kvp_shop.book.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kvp.kvp_shop.book.model.vo.Book;


public interface BookService {
	
	//크롤링
	List<String> crawling(String URL) throws Exception ;
	
	//api 받아오기
	void WebConnection(String c) throws Exception;
	
	//json 파싱
	ArrayList<Book> api(String c) throws Exception;
}
