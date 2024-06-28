package com.kh.spring.notice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class NoticeForwardController {
	
	@GetMapping("notices")
	public String notices() {
		return "api/notice";
	}

}
