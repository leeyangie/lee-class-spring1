package com.kh.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("boardList")
	public String forwarding(@RequestParam(value="page", defaultValue="1")int page) {
		
		//페이징 처리
		
		// RowBounds 안쓴 것
		// RowBounds 쓴 것 
		// 두가지 성능이 다름
		
		//필요한 변수들 
		
		int listCount; 		// 현재 일반게시판의 게시글 총 개수 => Board테이블로부터 총 데이터 select count로 조회
		int currentPage;  	// 현재 페이지 (사용자가 요청한 페이지)
		int pageLimit; 		// 페이지 하단에 보여질 페이징바의 최대개수 => 10개로 고정 
		int boardLimit;		// 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage;		// 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage;		// 페이지 하단에 보여질 페이징바의 시작 수
		int endPage;		// 페이지 하단에 보여질 페이징바의 끝 수
		
		// *listCount : 총 게시글의 수
		listCount = boardService.boardCount();
		
		currentPage = page;
		
		log.info("게시글의 총개수:{}, 현재 요청페이지:{}", listCount, currentPage);
		
		pageLimit = 10;
		
		// 한 페이지에 보여질 게시글 최대갯수
		boardLimit = 10;
		
		// 가장 마지막 페이지 몇번 페이지인지
		// 총 글 수와 한페이지 뵤여질 개수에 따라 달라짐
		//boardLimit, listCount 규칙을 찾음 나눈 소숫점값에 올림처리
		// 1. listCount 형변환
		// 2. 나누기 (더큰 자료형에 맞춰서 연산됨)
		// 3. Math.ceil 결과를 올림처리
		// 4. 결과값을 int로 형변환
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		
		
		// 하단에 보여질 페이징바의 시작 수 - startPage : 1, 11, 21, 31
		//n*10 + 1 
		//5페이지씩 보여주는 페이징 바여도 n*5 +1
		startPage = (currentPage -1 )/pageLimit *pageLimit + 1;
		
		// 페이징바의 끝 수 - endPage : 10, 20, 30, 40
		//startPage, pageLimit에 영향을 받음 *MaxPage 는 마지막 페이징바에 영향을 끼침
		endPage = startPage + pageLimit -1;
		// endPage가 10인데 maxPage가 2 
		if(endPage > maxPage) endPage = maxPage;
		
		//많은 변수를 담을 곳을 정해야함
		
		//PageInfo pageInfo = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		//다같이 사용하기 힘든구조...나만아는 구조....
		
		PageInfo pageInfo = PageInfo.builder()
									.listCount(listCount)
									.currentPage(currentPage)
									.pageLimit(pageLimit)
									.maxPage(maxPage)
									.pageLimit(pageLimit)
									.boardLimit(boardLimit)
									.endPage(endPage)
									.build();
		
		
		
		
		
		
		
		
		
		return "board/list";
	}
}