package com.kh.spring.member.model.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

//Repository :저장소
//영속성 작업 - 메모리에서 유지
@Repository
public class MemberRepository {

	public Member login(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}

	public int insert(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insert", member);
	}

	public int update(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.update("memberMapper.update", member);
	}
	
	public int delete(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.update("memberMapper.delet", userId);
	}
}
