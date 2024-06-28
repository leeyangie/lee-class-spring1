package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.PageTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("boardList")
	public String forwarding(@RequestParam(value="page", defaultValue="1")int page, Model model) {
		
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
									.startPage(startPage)
									.listCount(listCount)
									.currentPage(currentPage)
									.pageLimit(pageLimit)
									.maxPage(maxPage)
									.pageLimit(pageLimit)
									.boardLimit(boardLimit)
									.endPage(endPage)
									.build();
		
		Map<String, Integer> map = new HashMap();
		
		int startValue = (currentPage - 1) * boardLimit +1;
		int endValue = startValue + boardLimit - 1;
		map.put("startValue", startValue);
		map.put("endValue", endValue);
		
		List<Board> boardList = boardService.findAll(map);
		
		log.info("조회된 게시글을 수 :{}", boardList.size());
		log.info("-------------------------------------");
		log.info("조회된 게시글 목록 :{}", boardList);
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		log.info("{}", pageInfo.getStartPage());
		
		
		return "board/list";
	}
	
	@GetMapping("search.do")
	public String search(String condition, String keyword, @RequestParam(value="page", defaultValue = "1") int page, Model model) {
		
		log.info("검색조건 : {}", condition);
		log.info("검색 키워드 :{}", keyword);
		// 사용자가 선택한 조건과 입력한 키워드를 가지고 페이징 처리를 끝낸 후 검색결과를 들고가야함.
		
		Map<String, String> map = new HashMap();
		map.put("condition", condition); //"writer" "title" "content"
		map.put("keyword", keyword); //사용자가 입력하는 키워드
		
		int searchCount = boardService.searchCount(map);
		log.info("검색조건에 부합하는 행의 수 : {}", searchCount);
		int currentPage = page;
		int pageLimit = 3;
		int boardLimit = 3;
		/*
		int maxPage = (int)(Math.ceil((double)searchCount/boardLimit));
		int startPage = (currentPage -1 )/pageLimit *pageLimit + 1;
		int endPage = startPage + pageLimit -1;
		
		PageInfo pi = PageInfo.builder().pageLimit(pageLimit)
										.listCount(searchCount)
										.currentPage(currentPage)
										.pageLimit(pageLimit)
										.maxPage(maxPage)
										.pageLimit(pageLimit)
										.boardLimit(boardLimit)
										.startPage(startPage)
										.endPage(endPage)
										.build();
		*/
		PageInfo pageInfo = PageTemplate.getPageInfo(searchCount, 
													 currentPage, 
													 pageLimit, 
													 boardLimit);
		
		// offset, limit
		RowBounds rowBounds = new RowBounds((currentPage-1) * boardLimit, boardLimit);
		
		List<Board> boardList = boardService.findByConditionAndKeyword(map, rowBounds);
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("keyword", keyword);
		model.addAttribute("condition", condition);
		
		return "board/list";
	}
	
	@GetMapping("boardForm.do")
	public String insertForm() {
		
		
		
		return "board/insertForm";
		
	}
	@PostMapping("insert.do")
	public String insert(Board board, MultipartFile upfile, HttpSession session, Model model) {
		//MultipartFile[] 여러개의 파일이 배열로 한번에 들어옴
		
		//log.info("게시글정보 :{}", board);
		//log.info("파일정보 : {}", upfile);
		//첨부파일의 존재여부는 Multipart 객체 유무에 따라 -> fileName에 원본명이 존재하는가 없는가
		
		//존재할 경우 -> 파일 업로드
		if(!upfile.getOriginalFilename().equals("")) {
			/*
			//파일명 : kh_년월일시분초_랜덤한값.확장자
			String originName = upfile.getOriginalFilename();
			String ext = originName.substring(originName.lastIndexOf("."));
			//"abc.ddd.txt" 맨 마지막 .의 인덱스를 가져와야함
			
			int num = (int)(Math.random() * 100) + 1;
			// 0.0 ~ 0.99999999999999 사이값이 나옴 (double)
			//곱하는 숫자가 값의 범위를 지정하게됨 / 더하는 숫자는 시작값이 됨
			
			//log.info( "currentTime :{}", new Date());
			String currentTime = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
			
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			String changeName = "KH_" + currentTime + "_" + num + ext;
			
			try {
				upfile.transferTo(new File(savePath + changeName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			
			saveFile(upfile, session);
			
			board.setOriginName(upfile.getOriginalFilename());
			board.setChangeName(saveFile(upfile,session));
		
		}
		
		if(boardService.insert(board) > 0) {
			
			session.setAttribute("alertMsg", "게시글 작성 성공~");
			// 무조건 리다이렉트 해야함
			// 데이터 중복방지 (중복 post요청 방지)
			return "redirect:boardList";
		} else {
			model.addAttribute("errorMsg", "게시글 작성 실패");
			return "common/errorPage";
		}
		
		
	}
	// localhost/spring/board-detail?boardNo=???
	@GetMapping("board-detail")
	public ModelAndView findByBoardNo(int boardNo, ModelAndView mv) {
		
		// 파싱 (string -> int)
		// int abc = Integer.parseInt("123");
		
		// 데이터 가공 --> 데이터가 1개라서 할 필요 없음
		// 서비스 호출
		if(boardService.increaseCount(boardNo) > 0) {
			//실패할수 있기때문에
			mv.addObject(boardService.findById(boardNo))
			.setViewName("board/boardDetail");
		} else {
			
			mv.addObject("errorMsg", "게시글 상세조회에 실패했습니다.").setViewName("common/errorPage");
		}
	
		// 응답화면 지정
		return mv;
		 
	}
	//deleteById : Client 에게 정수형의 boardNo(Board테이블 PK)를 전달받아서 
	
	@PostMapping("boardDelete.do")
	public String deleteById(int boardNo, String filePath, HttpSession session, Model model) {
		
		if(boardService.delete(boardNo)>0) {
			
			if(!"".equals(filePath)) { //null값이 나올수 있는 확률이 있기때문에 빈문자열을 기준으로 비교코드를 짜는게 중요함
				new File(session.getServletContext().getRealPath(filePath)).delete();
			}
			
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			return "redirect:boardList";
			
		} else {
			model.addAttribute("errorMsg", "게시글 삭제실패!");
			return "common/errorPage";
		}
	}
	
	@PostMapping("boardUpdateForm.do")
	public ModelAndView upadteForm(ModelAndView mv, int boardNo) {
		
		mv.addObject("board", boardService.findById(boardNo))
		.setViewName("board/'boardUpdate");
		return mv;
	}
	
	@PostMapping("board-update.do")
	public String update(Board board, MultipartFile reUpFile, HttpSession session) {
		 //새로운 첨부파일이 존재하는가
		if(!reUpFile.getOriginalFilename().equals("")) {
			board.setOriginName(reUpFile.getOriginalFilename());
			board.setChangeName(saveFile(reUpFile,session));
			
		}
		if(boardService.update(board) >0) {
			session.setAttribute("alertMsg", "수정성공");
			return "";
		} else {
			session.setAttribute("errorMsg", "정보수정 실패");
			return "common/erroPage";
		}
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session) {
		
		String originName = upfile.getOriginalFilename();
		String ext = originName.substring(originName.lastIndexOf("."));
		
		int num = (int)(Math.random() * 100) + 1;
		
		String currentTime = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
		
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		String changeName = "KH_" + currentTime + "_" + num + ext;
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "resources/uploadFiles/"+ changeName;
	}
	
	@GetMapping("image-board")
	public String images(Model model) {
		
		//List<Board> images = boardService.selectImages();
		model.addAttribute("board", boardService.selectImages());
		
		return "board/imageList";
	}
	
	@ResponseBody
	@GetMapping(value="reply", produces="application/json; charset=UTF-8")
	public String selectReply(int boardNo) {
		boardService.selectReply(boardNo);
		return new Gson().toJson(boardService.selectReply(boardNo));
		
	}
	
	@PostMapping("reply")
	@ResponseBody
	public String saveReply(Reply reply) {
		
		return boardService.insertReply(reply) > 0 ? "success" : "fail";
	}
	
	@ResponseBody
	@GetMapping("board-reply")
	public Board boardAndReply(int boardNo) {
		
		return boardService.boardAndReply(boardNo);
	}
	
	@GetMapping("var")
	public String varForward() {
		return "common/viewable";
	}
}
