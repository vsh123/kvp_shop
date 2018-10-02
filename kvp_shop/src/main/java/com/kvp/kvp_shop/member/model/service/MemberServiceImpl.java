package com.kvp.kvp_shop.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvp.kvp_shop.member.model.dao.MemberDAO;
import com.kvp.kvp_shop.member.model.vo.Address;
import com.kvp.kvp_shop.member.model.vo.Member;
import com.kvp.kvp_shop.member.model.vo.MemberAddress;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int insertMember(Member member) {
		return memberDAO.insertMember(member);
	}

	@Override
	public int checkIdDuplicate(String memberId) {
		return memberDAO.checkIdDuplicate(memberId);
	}

	@Override
	public int insertAddress(Map<String, Object> map) {
		return memberDAO.insertAddress(map);
	}

	@Override
	public Member selectOneMemberById(String memberId) {
		return memberDAO.selectOneMemberById(memberId);
	}

	@Override
	public MemberAddress selectOneMemberAddressById(String memberId) {
		return memberDAO.selectOneMemberAddressById(memberId);
	}

	@Override
	public List<Address> selectAddressList(String memberId) {
		return memberDAO.selectAddressList(memberId);
	}

}
