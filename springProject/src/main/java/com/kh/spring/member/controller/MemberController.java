package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
//	@RequestMapping("login.do")
//	public String login(Member member) {
//		
//		log.info("가공된 멤버객체 : {}", member);
//		
//		Member loginMember = memberService.login(member);
//
//		log.info("멤버다 멤버 : {} ", loginMember);
//
//		return "main";
//		
//	}
	/*
	 * @RequestMapping("/login.do") //HandlerMapping으로 등록 public String
	 * login(HttpServletRequest request) {
	 * 
	 * String userId = request.getParameter("id"); String userPwd =
	 * request.getParameter("pwd");
	 * 
	 * log.info("회원이 입력한 아이디 값 : {}", userId); log.info("회원이 입력한 비밀번호 값 : {}",
	 * userPwd);
	 * 
	 * return "main";
	 * 
	 * 
	 * }
	 */
	/*
	 * spring에서 Handler가 요청 시 전달값(Parameter)을 받는 방법
	 * 1. HttpServletRequest를 이용해서 전달받기 (기존 JSP/Servlet 방식)
	*/
	
	
	
//	@RequestMapping("/login.do")
//	public String login(@RequestParam(value="id") String userId,
//						@RequestParam(value="pwd") String userPwd) {
//	log.info("회원이 입력한 아이디 값 : {}", userId); 
//	log.info("회원이 입력한 비밀번호 값 : {}", userPwd);
//	
//	return "main";
//	}
	
	
	
	//3. RequestParam애너테이션 생략하는 방법
	
	/*@RequestMapping("login.do")
	public String login(String id, String pwd) {
		
		log.info("회원이 입력한 아이디 값 : {}", id); 
		log.info("회원이 입력한 비밀번호 값 : {}",pwd);
		
		// 1.데이터 가공 -> DTO
		Member member = new Member();
		member.setUserId(id);
		member.setUserPwd(pwd);
		
		// 1.5 서비스 호출
		
		// 2. 응답화면 지정
		return "main";
	}
		 */
	//4. 커맨드 객체방식
	
	/*@RequestMapping("login.do")
	public String login(Member member) {
		
		log.info("가공된 멤버객체 : {}", member);
		
		return "main";
		
	}
	*/
	
	//Rest방식의 URL 만들기
//	@GetMapping("/member/{id}")
//	public void restTest(@PathVariable String id) {
//		
//		log.info("앞단에서 넘긴값:()", id);
//		
//	}
//	
//	@PostMapping("login.do")
//	public String login(Member member, Model model, HttpSession session) {
//		Member loginUser = memberService.login(member);
//		
//		if(loginUser ==null) {
//			model.addAttribute("errorMsg", "로그인에 실패");
//			return "common/errorPage";
//		} else {
//			session.setAttribute("loginUser", loginUser);
//		
//			return "redirect:/";
//		}
//	}
	
	@PostMapping("login.do")
	public ModelAndView login(Member member, ModelAndView mv, HttpSession session ) {
		Member loginUser = memberService.login(member);
		
		if(loginUser !=null) {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg", "로그인 실패").setViewName("common/errorPage");
		}
		return mv;
	}
//	
}
