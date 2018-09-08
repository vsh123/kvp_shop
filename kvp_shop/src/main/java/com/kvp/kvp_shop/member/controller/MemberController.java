package com.kvp.kvp_shop.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kvp.kvp_shop.member.model.service.MemberService;
import com.kvp.kvp_shop.member.model.vo.Member;


@SessionAttributes("memberLoggedIn")
@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {
		if(logger.isDebugEnabled())
			logger.debug("회원가입 페이지");
		return "member/memberEnroll";
	}
	
	@RequestMapping(value="/member/memberEnrollEnd.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberEnrollEnd(Member member, Model model,
								  @RequestParam(value="sample4_postcode") String zipCode,
								  @RequestParam(value="sample4_roadAddress") String roadAddress,
								  @RequestParam(value="sample4_jibunAddress",required=false) String locAddress,
								  @RequestParam(value="sample4_detailAddress") String detailAddress) {
		if(logger.isDebugEnabled())
			logger.debug("회원가입 처리 페이지");
		
		logger.debug(member.toString());
		
		String rawPassword = member.getMemberPassword();
		
		/***** 암호화 시작 *****/
		String encodedPassword = bcryptPasswordEncoder.encode(rawPassword);
		
		member.setMemberPassword(encodedPassword);
		/***** 암호화 끝 *****/
		
		int result = 0;
		
		if(memberService.insertMember(member) > 0) {
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("memberId", member.getMemberId());
			map.put("zipCode", zipCode);
			map.put("roadAddress", roadAddress);
			map.put("locAddress", locAddress);
			map.put("detailAddress", detailAddress);
			
			result = memberService.insertAddress(map);
		}
		
		String loc = "/";
		String msg = "";
		
		if(result > 0)
			msg = "회원가입에 성공하였습니다.";
		else
			msg = "회원가입에 실패하였습니다.";
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/checkIdDuplicate.do")
	@ResponseBody
	public Map<String, Object> checkIdDuplicate(@RequestParam("memberId") String memberId) {
		if(logger.isDebugEnabled())
			logger.debug("아이디 중복 검사");
		
		Map<String, Object> map = new HashMap<>();

		int count = memberService.checkIdDuplicate(memberId);
		boolean isUsable = count==0?true:false;
		
		map.put("isUsable", isUsable);
		
		return map;
	}
	
	@RequestMapping("/member/memberLogin.do")
	public ModelAndView memberLogin(@RequestParam("memberId") String memberId, 
									@RequestParam("memberPassword") String memberPassword) {
		if(logger.isDebugEnabled())
			logger.debug("로그인 요청");
		
		ModelAndView mav = new ModelAndView();
		
		Member m = memberService.selectOneMemberById(memberId);
		
		String msg = "";
		String loc = "/";
		
		if(m == null) {
			msg = "존재하지 않는 아이디입니다.";
		} else {
			if(bcryptPasswordEncoder.matches(memberPassword, m.getMemberPassword())) {
				mav.addObject("memberLoggedIn", m);
			} else {
				msg = "비밀번호가 틀렸습니다.";								
			}
		}
		
		mav.addObject("msg", msg);
		mav.addObject("loc", loc);
		mav.setViewName("common/msg");
		
		return mav;
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(SessionStatus sessionStatus) {
		if(logger.isDebugEnabled())
			logger.debug("로그아웃 요청");
		
		// 현재 session 상태를 끝났다고 마킹함.
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
}
