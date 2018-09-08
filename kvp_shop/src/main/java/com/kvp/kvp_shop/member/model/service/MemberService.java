package com.kvp.kvp_shop.member.model.service;

import java.util.Map;

import com.kvp.kvp_shop.member.model.vo.Member;


public interface MemberService {

	// 회원 가입
	int insertMember(Member member);

	// 아이디 중복 검사
	int checkIdDuplicate(String memberId);

	// 주소 추가
	int insertAddress(Map<String, Object> map);

	// 아이디로 회원 찾기
	Member selectOneMemberById(String memberId);

}
