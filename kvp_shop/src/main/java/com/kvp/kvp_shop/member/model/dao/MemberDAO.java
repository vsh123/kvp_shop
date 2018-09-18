package com.kvp.kvp_shop.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kvp.kvp_shop.member.model.vo.Address;
import com.kvp.kvp_shop.member.model.vo.Member;
import com.kvp.kvp_shop.member.model.vo.MemberAddress;


public interface MemberDAO {

	int insertMember(Member member);

	int checkIdDuplicate(String memberId);

	int insertAddress(Map<String, Object> map);

	Member selectOneMemberById(String memberId);

	MemberAddress selectOneMemberAddressById(String memberId);

	List<Address> selectAddressList(String memberId);

}
