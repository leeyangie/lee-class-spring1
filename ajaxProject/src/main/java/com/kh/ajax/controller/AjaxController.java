package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.Menu;

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
	public String calSum(String menu, int amount, HttpServletResponse response) {
		
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
	
	@GetMapping("responseData")
	public void test(HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html, charset=UTF-8");
		writer.print("<h1 style='font-size=50px;'>");
	}
	
	
	
	@ResponseBody
	@GetMapping(value="ajax2.do", produces="application/json; charset=UTF-8")
	public String selectMenu(int menuNumber) {
		
		
		Menu menu = new Menu(1, "순두부", 9600, "순두부");
		/*
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		sb.append("\"menuNumber\" :" +"''"+ menu.getMenuNumber() + "',");
		sb.append("\"menuName\" :" +"''"+ menu.getMenuName() + "',");
		sb.append("\"pice\" :" +"''"+ menu.getPrice() + "',");
		sb.append("\"material\" :" +"''"+ menu.getMaterial() + "',");
		sb.append("}");
		return sb.toString();
		*/
		JSONObject jObj = new JSONObject();
		jObj.put("menuNumber", menu.getMenuNumber());
		jObj.put("menuName", menu.getMenuName());
		jObj.put("price",menu.getPrice());
		jObj.put("meterial", menu.getMaterial());
		return jObj.toJSONString();
	}
	
	@ResponseBody
	@GetMapping(value="ajax3.do", produces="application/json; charset=UTF-8")
	public String ajax3Method(int menuNumber) {
		Menu menu = new Menu(menuNumber, "순두부", 9600, "순두부");
		// DB에서 SELECT
		
		return new Gson().toJson(menu);
	}
	
	@ResponseBody
	@GetMapping(value="find.do", produces="application/json; charset=UTF-8")
	public String findAll() {
//		
		List<Menu>menus = new ArrayList();
		menus.add(new Menu(1,"순두부", 9600, "순두부"));
		menus.add(new Menu(2,"김치", 5500, "순두부"));
		menus.add(new Menu(3,"된장찌개", 9000, "된장"));
		
		
		JSONArray jArr = new JSONArray();
		
		return new Gson().toJson(menus);
		
	}
	
}
