package com.kh.spring.board.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;

@Repository
public class BoardRepository {

	public int boardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.boardCount");
	}

	public List<Board> findAll(SqlSessionTemplate sqlSession, Map<String, Integer> map) {
		return sqlSession.selectList("boardMapper.findAll", map);
	}

	public int searchCount(SqlSessionTemplate sqlSession, Map<String, String> map) {
		return sqlSession.selectOne("boardMapper.searchCount", map);
	}

	public List<Board> findByConditionAndKeyword(SqlSessionTemplate sqlSession, Map<String, String> map,
			RowBounds rowBounds) {
		return sqlSession.selectList("boardMapper.findByConditionAndKeyword", map, rowBounds);
	}
	
	public int insert(SqlSessionTemplate sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insert", board);
	}

}
