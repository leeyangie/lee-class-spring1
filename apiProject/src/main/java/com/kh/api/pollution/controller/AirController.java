package com.kh.api.pollution.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pollution")
public class AirController {
	
	public static final String SERVICE_KEY = "0Uty6YZMI%2F5aowrsw4sjd88u1mjTN0NHsdK2owFL%2F3RIpvCvPeqIzZLBRmFjcxYf34%2BE3EyEXOL14ZjBapaTVQ%3D%3D";

	@GetMapping(produces="application/json; charse=UTF-8")
	public String airPollution(String sidoName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
		sb.append("?serviceKey=");
		sb.append(SERVICE_KEY);
		sb.append("&sidoName=");
		sb.append(URLEncoder.encode("서울", "UTF-8"));
		sb.append("&returnType=json"); // 응답 형식 (json 또는 xml)
		
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
	
	
	@GetMapping(value="/xml", produces="text/html; charse=UTF-8")
	public String xmlPollution(String sidoName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
		sb.append("?serviceKey=");
		sb.append(SERVICE_KEY);
		sb.append("&sidoName=");
		sb.append(URLEncoder.encode("서울", "UTF-8"));
		sb.append("&returnType=xml"); // 응답 형식 (json 또는 xml)
		
		String url = sb.toString();
			//Java 코드를 가지고 URL로 요청보냄
			//HttpURLConnection 객체 활용 -> API서버로 요청
			//1. java.net.URL 객체생성 ->생성자 호출시 url 값을 인자값으로 전달
		URL requestUrl = new URL(url); 		//2. HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection(); 	//3. 요청에 필요한 설정
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseData = "";
		String line;
		
		while((line = br.readLine()) !=null) {
			responseData += line;
		}
		
		br.close();
		urlConnection.disconnect();
		
		return responseData;
	
	
	
	}
	

}
