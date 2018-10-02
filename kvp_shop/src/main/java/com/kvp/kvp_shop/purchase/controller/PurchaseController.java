package com.kvp.kvp_shop.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kvp.kvp_shop.basket.model.service.BasketService;
import com.kvp.kvp_shop.basket.model.service.BasketServiceImpl;
import com.kvp.kvp_shop.basket.model.vo.BasketBook;
import com.kvp.kvp_shop.member.model.service.MemberService;
import com.kvp.kvp_shop.member.model.service.MemberServiceImpl;
import com.kvp.kvp_shop.member.model.vo.MemberAddress;
import com.kvp.kvp_shop.purchase.model.service.PurchaseService;
import com.kvp.kvp_shop.purchase.model.service.PurchaseServiceImpl;

@Controller
public class PurchaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/*@Autowired
	private PurchaseService purchaseService = new PurchaseServiceImpl();*/
	
	@Autowired
	private MemberService memberService = new MemberServiceImpl();
	
	@Autowired
	private BasketService basketService = new BasketServiceImpl();
	
	@RequestMapping("/purchase/purchase.do")
	public ModelAndView purchase(@RequestParam(value="basketNo") String basketNo,
			 					 @RequestParam(value="memberId") String memberId) {
		if(logger.isDebugEnabled())
			logger.debug("구매 페이지 요청");
		
		ModelAndView mav = new ModelAndView();
		
		MemberAddress ma = memberService.selectOneMemberAddressById(memberId);
		mav.addObject("memberAddress", ma);
		
		if(!basketNo.contains("/")) {
			BasketBook purchaseOne = basketService.selectOneBasketBook(Integer.parseInt(basketNo));
			mav.addObject("purchaseOne", purchaseOne);
		} else {
			String[] basketNoList = basketNo.split("/");
			List<BasketBook> purchaseList = new ArrayList<>();
			
			for(int i=0; i<basketNoList.length; i++) {
				purchaseList.add(basketService.selectOneBasketBook(Integer.parseInt(basketNoList[i])));
			}
			mav.addObject("purchaseList", purchaseList);
		}
		
		return mav;
	}
}
