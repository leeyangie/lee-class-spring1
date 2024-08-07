package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;

public interface BoardService {
	// 게시글 전체조회 + 페이징 처리
	
	// 현재 Board테이블의 총 행의 개수
	
	// 게시글 검색 기능 
	int searchCount(Map<String, String> map);
	
	// 게시글 목록 조회
	List<Board> findAll(Map<String, Integer> map);
	
	// 검색 목록 조회
	List<Board> findByConditionAndKeyword(Map<String, String> map, RowBounds rowBounds);
	
	// 게시글 작성
	int insert(Board board);
	
	// 게시글 상세보기
	// 조회수 증가
	int increaseCount(int boardNo);
	//우선 시행 되어야함 - 실패할 수도 있음, 실패시 다음 작업 이뤄지지 않게
	//
	
	// 상세조회
	Board findById(int boardNo);
	
	// 게시글 삭제
	int delete(int boardNo);
	
	// 게시글 수정
	int update(Board board);
	// 댓글 (AJAX / MyBatis)

	int boardCount();

	List<Board> selectImages();

	
	List<Reply> selectReply(int boardNo);

	int insertReply(Reply reply);

	Board boardAndReply(int boardNo);

	//조회수 상위 5개 게시물
	List<Board> findTopBoard();
	
	
	// 댓글 작성
	
	//
}
