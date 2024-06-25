package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	/*
	 * 1. HttpServletResponse 객체로 응답데이터를 응답받기(Stream을 이용한 방식)
	 * 
	 * 
	 */
	/*
	@GetMapping("ajax1.do")
	public void calSum(String menu, int amount, HttpServletResponse response) throws IOException {
			
		//System.out.println("사용자가 입력한 메뉴:" + menu);
		//System.out.println("사용자가 입력한 수량:" + amount);
		int price = 0;
		switch(menu) {
		case "알밥" : price = 1000; break;
		case "김치찜" : price = 12000; break;
		case "돈까스" : price = 15000; break;
		case "막국수" : price = 9000; break;
		case "서브웨이" : price = 8000;
		}
		
		price *= amount;
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(amount);
		
		System.out.println(price);
	}
	*/
	//MessageConverter로 이동하게끔 해주어야함 => @ResponseBody 애너테이션
	
	@ResponseBody
	@GetMapping(value="ajax1.do", produces="text/html; charset=UTF-8")
	public String calSum(String menu, int amount) {
		
		int price = 0;
		switch(menu) {
		case "알밥" : price = 10000; break;
		case "김치찜" : price = 12000; break;
		case "돈까스" : price = 15000; break;
		case "막국수" : price = 9000; break;
		case "서브웨이" : price = 8000;
		}
		
		price *= amount;
		
		return String.valueOf(price);
	}
	
	
	
}
