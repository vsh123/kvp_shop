package com.kvp.kvp_shop.book.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvp.kvp_shop.book.model.vo.Book;


@Repository
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//책 정보 DB에 삽입
	@Override
	public int insertBook(Book book){
		return sqlSession.insert("book.insertBook", book);
	}
	
	
	//해당책이 DB에 저장되어있는지 확인
	@Override
	public int existBook(String BookName){
		return sqlSession.selectOne("book.existBook", BookName);
	}
	
	
	//책 찾기
	@Override
	public Book findBook(String isbn){
		return (Book) sqlSession.selectList("book.findBook");
	}

}
