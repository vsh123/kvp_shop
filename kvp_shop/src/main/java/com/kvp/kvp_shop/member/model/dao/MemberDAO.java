package com.kvp.kvp_shop.member.model.dao;

import java.util.Map;

import com.kvp.kvp_shop.member.model.vo.Member;


public interface MemberDAO {

	int insertMember(Member member);

	int checkIdDuplicate(String memberId);

	int insertAddress(Map<String, Object> map);

	Member selectOneMemberById(String memberId);

}
