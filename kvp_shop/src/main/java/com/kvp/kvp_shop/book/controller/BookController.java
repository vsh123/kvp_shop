package com.kvp.kvp_shop.book.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kvp.kvp_shop.book.model.service.BookService;
import com.kvp.kvp_shop.book.model.vo.Book;


@Controller
public class BookController {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BookService BookService;
	

	@RequestMapping("/book/booksearch.do")
	public ModelAndView booksearch(@RequestParam("search") String search) throws Exception {
		ArrayList<Book> book = new ArrayList<Book>();
		System.out.println("컨트롤러 변환 전 : "+search);
		System.out.println("컨트롤러 : "+search);
		book = BookService.api(search);
		for(int i=0;i<book.size();i++) {
			book.get(i).getBookTitle();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/result");
		mav.addObject("book",book);
		return mav;
	}

}
