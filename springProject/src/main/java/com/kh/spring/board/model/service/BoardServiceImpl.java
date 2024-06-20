package com.kh.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final SqlSessionTemplate sqlSession;
	
	@Override
	public int boardCount() {
		return boardRepository.boardCount(sqlSession);
	}
	
	@Override
	public int searchCount() {
		return 0;
	}

	@Override
	public List<Board> findAll() {
		return null;
	}

	@Override
	public List<Board> searchAll() {
		return null;
	}

	@Override
	public int insert(Board board) {
		return 0;
	}

	@Override
	public int increaseCount(int boardNo) {
		return 0;
	}

	@Override
	public Board findById(int boardNo) {
		return null;
	}

	@Override
	public int delete(int boardNo) {
		return 0;
	}

	@Override
	public int update(Board board) {
		return 0;
	}

	
	
	

}
