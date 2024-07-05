package com.kh.api.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.api.model.vo.AirVO;

public class ApiJavaApp {
	
	public static final String SERVICE_KEY = "0Uty6YZMI%2F5aowrsw4sjd88u1mjTN0NHsdK2owFL%2F3RIpvCvPeqIzZLBRmFjcxYf34%2BE3EyEXOL14ZjBapaTVQ%3D%3D";
	
	public static void main(String[] args) throws IOException {
		
		//System.out.println("하이!");
		
		//순수 java만으로 Client Program을 만들어서 시도별 API서버로 요청 보내고 응답받기
		
		//요청보낼 URL이 필요함 => String 타입으로
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
		sb.append("?serviceKey=");
		sb.append(SERVICE_KEY);
		sb.append("&sidoName=");
		sb.append(URLEncoder.encode("서울", "UTF-8"));
		sb.append("&returnType=json"); // 응답 형식 (json 또는 xml)
		
		String url = sb.toString();
		
		//System.out.println(url);
		
			//Java 코드를 가지고 URL로 요청보냄
			//HttpURLConnection 객체 활용 -> API서버로 요청
			//1. java.net.URL 객체생성 ->생성자 호출시 url 값을 인자값으로 전달
		URL requestUrl = new URL(url);
			//2. HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
			//3. 요청에 필요한 설정
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); //입력받을 수 있는 통로가 생김
			//BufferedReader : 문자로 읽을때 배열을 제공하여 한꺼번에 읽을 수 있는 기능을 제공해주는 보조 스트림
			//InputStream : 바이트단위로 읽은 자료를 문자로 변환해주는 보조스트림 클래스
		
//		while(true) {
//			String value = br.readLine();
//			if(value != null) {
//				System.out.println(value);
//			} else {
//				break;
//			}
//		}
		
//		//심화방법
//		String responseXml = "";
//		while((responseXml = br.readLine()) != null) {
//			System.out.println(responseXml);
//		}
//	
//		String responseJson = br.readLine();
//		System.out.println(responseJson);
//		
		
		StringBuilder responseSb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            responseSb.append(line);
        }
        
        String responseJson = responseSb.toString();
        //System.out.println(responseJson);

		
		
			//스트링으로 받아온 json데이터를 vo로 바꿔줘야함
			//라이브러리
			//JsonObject, JsonArray : JSON -> 자바데이터로  *GSON라이브러리에서 제공
			//JSONObject, JSONArray : 자바데이터 -> JSON으로 *JSON라이브러리에서 제공
				
		JsonObject jsonObj = JsonParser.parseString(responseJson).getAsJsonObject();
			//System.out.println(jsonObj);
		JsonObject responseObj = jsonObj.getAsJsonObject("response");
		JsonObject bodyObj = responseObj.getAsJsonObject("body"); //map   body라는 property로 접근 
			//System.out.println(bodyObj);
		
		int totalCount = bodyObj.get("totalCount").getAsInt(); // totalCount라는 property로 접근 => int 
			//System.out.println(totalCount);
		
		JsonArray items = bodyObj.getAsJsonArray("items"); // items property = > []JsonArray
			//System.out.println(items);
		
		JsonObject firstItem = items.get(0).getAsJsonObject();
			//System.out.println(firstItem);
		
		List<AirVO> list = new ArrayList();
		
		for(int i = 0; i < items.size(); i++) {
			
			JsonObject item = items.get(i).getAsJsonObject();
			
			AirVO air = new AirVO();
			air.setPm10Value(item.get("pm10Value").getAsString());
			air.setStationName(item.get("stationName").getAsString());
			air.setDataTime(item.get("dataTime").getAsString());
			air.setO3Value(item.get("o3Value").getAsString());
			air.setKhaiValue(item.get("khaiValue").getAsString());
			
			list.add(air);
		}
		
		for(AirVO air : list) {
			System.out.println(air);
		}
		
		br.close();

		
	}


	
}
