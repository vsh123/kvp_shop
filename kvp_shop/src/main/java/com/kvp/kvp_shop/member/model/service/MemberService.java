package com.kvp.kvp_shop.member.model.service;

import java.util.List;
import java.util.Map;

import com.kvp.kvp_shop.member.model.vo.Address;
import com.kvp.kvp_shop.member.model.vo.Member;
import com.kvp.kvp_shop.member.model.vo.MemberAddress;


public interface MemberService {

	// 회원 가입
	int insertMember(Member member);

	// 아이디 중복 검사
	int checkIdDuplicate(String memberId);

	// 주소 추가
	int insertAddress(Map<String, Object> map);

	// 아이디로 회원 찾기
	Member selectOneMemberById(String memberId);

	// 아이디로 회원, 주소 정보 찾기
	MemberAddress selectOneMemberAddressById(String memberId);

	// 아이디로 회원 주소 찾기
	List<Address> selectAddressList(String memberId);


}
