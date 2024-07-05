package com.kh.api.movie.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@RestController
@RequestMapping("movieList/")
public class MovieController {
	
	@GetMapping(value="nowPlaying", produces="application/json; charse=UTF-8")
	public String getNowPlayingMovie(@RequestParam("pageNo") int pageNo) throws IOException {
		
		//OkHttp 클라이언트 객체생성
		OkHttpClient client = new OkHttpClient();

		//get 요청
		Request request = new Request.Builder()
		  .url("https://api.themoviedb.org/3/movie/now_playing?append_to_response=images&language=ko-KR&page="+pageNo+"&include_image_language=en,null")
		  .get()
		  .addHeader("accept", "application/json")
		  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNjU2OTQwNzBmNWI4MzJmMjVkYjRjNjZmY2JmZWExNSIsIm5iZiI6MTcxOTk4Mzc5NS40NDkyODMsInN1YiI6IjY2N2NhYmNlMzQ3ZWM1MzNhYWViNGI3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qMXzz1zFbiC7Mct5mGb96DwMT3Tjtuo1HFjLE_b_kZ0")
		  .build();

		// 요청 실행 및 응답 받기
        try (Response response = client.newCall(request).execute()) {
            // 응답 본문 추출
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                return responseBody.string();
            } else {
                return "{}"; // 응답 본문이 없는 경우 빈 JSON 객체 반환
            }
        }
    }
	
	@GetMapping(value="upComming", produces="application/json; charse=UTF-8")
	public String getUpcommingMovie() throws IOException {
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1")
		  .get()
		  .addHeader("accept", "application/json")
		  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwNjU2OTQwNzBmNWI4MzJmMjVkYjRjNjZmY2JmZWExNSIsIm5iZiI6MTcyMDA2Mjc5Ni41OTIxNDksInN1YiI6IjY2N2NhYmNlMzQ3ZWM1MzNhYWViNGI3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.WfXqF4gZs0s7v7N9TyGhAUHP_ut6LgIEjSs_Bge8vH0")
		  .build();

		try (Response response = client.newCall(request).execute()) {
	            // 응답 본문 추출
	            ResponseBody responseBody = response.body();
	            if (responseBody != null) {
	                return responseBody.string();
	            } else {
	                return "{}"; // 응답 본문이 없는 경우 빈 JSON 객체 반환
	            }
	        }
	}
	
		
}