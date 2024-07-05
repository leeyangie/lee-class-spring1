package com.kh.api.kakao.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.api.kakao.model.service.KakaoService;

@Controller
public class LoginController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@GetMapping("oauth")
	public void socialLogin(String code, HttpSession session) throws IOException, ParseException, org.json.simple.parser.ParseException {
		
		//System.out.println(code);
		String accessToken = KakaoService.getToken(code);
		session.setAttribute("accessToken", accessToken);
		
		kakaoService.getUserInfo(accessToken);
		
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		String accessToken = (String)session.getAttribute("accessToken");
		
		kakaoService.logout(accessToken);
		
		return "redirect:login";
				
	}
}
