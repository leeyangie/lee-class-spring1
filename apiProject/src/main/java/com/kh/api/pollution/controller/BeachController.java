package com.kh.api.pollution.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beach")
public class BeachController {

	@GetMapping(produces="application/json; charse=UTF-8")
	public String info(int pageNo) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		sb.append("http://apis.data.go.kr/6260000/BusanBeachInfoService/getBeachInfo");
		sb.append("?serviceKey=");
		sb.append(AirController.SERVICE_KEY);
		sb.append("&numOfRows=10");
		sb.append("&pageNo="+pageNo);
		sb.append("&resultType=json"); // 응답 형식 (json 또는 xml)
		
		String url = sb.toString();
			//Java 코드를 가지고 URL로 요청보냄
			//HttpURLConnection 객체 활용 -> API서버로 요청
			//1. java.net.URL 객체생성 ->생성자 호출시 url 값을 인자값으로 전달
		URL requestUrl = new URL(url); 		//2. HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection(); 	//3. 요청에 필요한 설정
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseData = br.readLine();
		
		br.close();
		urlConnection.disconnect();
		
		return responseData;
	}
}
