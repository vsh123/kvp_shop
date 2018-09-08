package com.kvp.kvp_shop.basket.model.dao;

import java.util.List;
import java.util.Map;

import com.kvp.kvp_shop.basket.model.vo.BasketBook;


public interface BasketDAO {

	List<BasketBook> selectBasketList(String memberId);

	int updateBasket(Map<String, Integer> map);

}
