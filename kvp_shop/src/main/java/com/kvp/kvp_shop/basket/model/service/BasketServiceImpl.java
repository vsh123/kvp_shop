package com.kvp.kvp_shop.basket.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvp.kvp_shop.basket.model.dao.BasketDAO;
import com.kvp.kvp_shop.basket.model.vo.BasketBook;


@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketDAO basketDAO;

	@Override
	public List<BasketBook> selectBasketList(String memberId) {
		return basketDAO.selectBasketList(memberId);
	}

	@Override
	public int updateBasket(Map<String, Integer> map) {
		return basketDAO.updateBasket(map);
	}
}
