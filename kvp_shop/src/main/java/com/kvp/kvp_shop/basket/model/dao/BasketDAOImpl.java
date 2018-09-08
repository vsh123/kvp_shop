package com.kvp.kvp_shop.basket.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvp.kvp_shop.basket.model.vo.BasketBook;


@Repository
public class BasketDAOImpl implements BasketDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BasketBook> selectBasketList(String memberId) {
		return sqlSession.selectList("basket.selectBasketList", memberId);
	}

	@Override
	public int updateBasket(Map<String, Integer> map) {
		return sqlSession.update("basket.updateBasket", map);
	}
}
