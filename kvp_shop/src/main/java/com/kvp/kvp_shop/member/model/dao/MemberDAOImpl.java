package com.kvp.kvp_shop.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvp.kvp_shop.member.model.vo.Member;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertMember(Member member) {
		return sqlSession.insert("member.insertMember", member);
	}

	@Override
	public int checkIdDuplicate(String memberId) {
		return sqlSession.selectOne("member.checkIdDuplicate", memberId);
	}

	@Override
	public int insertAddress(Map<String, Object> map) {
		return sqlSession.insert("member.insertAddress", map);
	}

	@Override
	public Member selectOneMemberById(String memberId) {
		return sqlSession.selectOne("member.selectOneMemberById", memberId);
	}

}
