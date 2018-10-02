package com.kvp.kvp_shop.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kvp.kvp_shop.book.model.dao.BookDAO;
import com.kvp.kvp_shop.book.model.service.BookService;
import com.kvp.kvp_shop.book.model.vo.Book;


@Controller
public class BookController {
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BookService BookService;
	
	@Autowired
	private BookDAO BookDAO;
	

	@RequestMapping("/book/bookSearch.do")
	public ModelAndView booksearch(@RequestParam("search") String search) throws Exception {
		List<Book> book = new ArrayList<Book>();
		book = BookService.api(search);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/result");
		mav.addObject("book",book);
		return mav;
	}
	
	@RequestMapping("/book/bookDetails.do")
	public ModelAndView bookDetail(@RequestParam("isbn") String isbn) throws Exception {
			System.out.println("상세 정보 페이지");
			Book book = BookDAO.findBook(isbn);
			List<String> list = BookService.crawling(book.getBookInfo());	
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("book/result2");
			mav.addObject("book",book);
			mav.addObject("info", list);
			return mav;
	}

}
