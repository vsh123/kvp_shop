package com.kvp.kvp_shop.basket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kvp.kvp_shop.basket.model.service.BasketService;
import com.kvp.kvp_shop.basket.model.vo.BasketBook;

@Controller
public class BasketController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BasketService basketService;
	
	@RequestMapping("/basket/selectBasketList.do")
	/*public String basketList(HttpServletRequest request) {
		if(request.getSession().getAttribute("memberLoggedIn")!=null) {
			System.out.println(request.getSession().getAttribute("memberLoggedIn"));
		}
		return "/basket/basketList";
	}*/
	public ModelAndView selectBasketList(@RequestParam(value="memberId") String memberId) {
		if(logger.isDebugEnabled())
			logger.debug("장바구니 목록 요청");
		
		ModelAndView mav = new ModelAndView();
		
		List<BasketBook> basketList = basketService.selectBasketList(memberId);
		logger.debug("basektList@BasketController = " + basketList);
		
		mav.addObject("basketList", basketList);
		mav.setViewName("/basket/basketList");
		
		return mav;
	}

	@RequestMapping("/basket/updateBasket.do") 
	@ResponseBody
	public Map<String, Integer> updateBasket(@RequestParam(value="basketNo") int basketNo, @RequestParam(value="bookAmount") int bookAmount) {
		if(logger.isDebugEnabled())
			logger.debug("장바구니 수량 변경");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("basketNo", basketNo);
		map.put("bookAmount", bookAmount);
		
		basketService.updateBasket(map);
		
		return map;
	}
	
	@RequestMapping("/basket/deleteBasket.do")
	public ModelAndView deleteBasket(@RequestParam(value="basketNo") String basketNo) {
		if(logger.isDebugEnabled())
			logger.debug("장바구니 상품 삭제");
		
		ModelAndView mav = new ModelAndView();
		
		if(!basketNo.contains("/")) {
			basketService.deleteBasket(Integer.parseInt(basketNo));
		}
		else {
			String[] basketNoList = basketNo.split("/");
			for(int i=0; i<basketNoList.length; i++) {
				basketService.deleteBasket(Integer.parseInt(basketNoList[i]));
			}
		}		
		
		mav.setViewName("/basket/basketList");
		
		return mav;
	}
}
