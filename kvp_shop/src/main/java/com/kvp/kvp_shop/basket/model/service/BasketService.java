package com.kvp.kvp_shop.basket.model.service;

import java.util.List;
import java.util.Map;

import com.kvp.kvp_shop.basket.model.vo.BasketBook;


public interface BasketService {

	// 회원 아이디로 장바구니 목록 조회
	List<BasketBook> selectBasketList(String memberId);

	// 장바구니 목록에서 도서 수량 변경
	int updateBasket(Map<String, Integer> map);

	// 장바구니 목록에서 도서 삭제
	int deleteBasket(int basketNo);

	// 장바구니 번호로 도서정보 찾기
	BasketBook selectOneBasketBook(int basketNo);

}
