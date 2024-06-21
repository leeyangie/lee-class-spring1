package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.repository.MemberRepository;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final SqlSessionTemplate sqlSession;
	private final MemberRepository memberRepository;
	
	public int returnNum() {
		return 1;
	}

	@Override
	public Member login(Member member) {
		
		return memberRepository.login(sqlSession, member);
		
	}

	@Override
	public int insert(Member member) {
		//1. DAO 호출
		//2. 컨트롤러로 결과 반환
		
		return memberRepository.insert(sqlSession, member);
	}

	@Override
	public int update(Member member) {
		return memberRepository.update(sqlSession, member);
	}

	@Override
	public int delete(String userId) {
		return memberRepository.delete(sqlSession, userId);
	}

}
