<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웰컴파일</title>
</head>
<body>

	<h1>Spring에서의 비동기 통신 활용법</h1>
	<h3>AJAX</h3>
	<p>
	비동기방식?????
	자바스크립트?????
	JSON?????
	
	Asynchronous JavaScript And Xml의 약자<br>
	서버로부터 데이터를 응답받아 전체 페이지를 다시 만드는것이 아니라 일부만 내용물을 바꿀수 있는 기법
	a태그/form태그 - 동기식 요청<br>
	=> HTML 전체를 응답받아서 브러우저는 화면전체를 렌더링해야 했음.<br>
	동기식 : 서버가 요청 처리후 응답 HTML데이터가 돌아와야만 다음작업가능<br>
	만약 서버에서 응답페이지를 돌려주는 시간이 지연되면 무작정 기다리고 있어야함<br>
	응답데이터가 돌아오면 
	<br>
	비동기식
	=> 현재페이지를 그대로 유지한느 동안 중간중간 추가요청을 보낼수있음
	요청을 보내놓고 응답이 올때까지 다른작업을 할 수 있음
	<br><br>
	
	*예시 ) 예약, 중복확인, 검색어 자동완성, 
	*단점 ) 요청 후 돌아온 응답데이터를 가지고 현재 페이지에서 새로운 요소를 동적으로 만들어줘야함.
	=>DOM요소를 새롭게 만드는 구문을 잘 익혀둬야함
	- 페이지 복잡도가 기하급수적으로 늘어남
	<br><br><br>
	
	<pre>
	*jQuery에서의 AJAX통신
	
	[표현법]
	$.ajax({
		속성명 : 속성값,
		속성명 : 속성값,
		...
		
	});
	
	*주요속성 :
	- url :*필수 - 요청할 ur => form태그의 action속성
	- type : 요청 전송방식 (GET/POST/PUT/DELETE) 생략시 기본값은 GET
	- data : 요청시 전달할 값 ({key:value, ket:value,...) => form태그의 input요소 value속성
	- success : AJAX통신 성공 시 콜백함수를 정의
	
	- error : AJAX통신 실패시 콜백 함수를 정의
	- complete : AJAX통신이 성공하든 실패하든 무조건 끝나면 실행할 콜백함수
	- async : 서버와 비동기 처리방식 설정 여부 {기본값 true)
	- contentType : 요청시 데이터 인코딩 방식 정의 (보내는 측의 데이터 인코딩)
	- dataType : 서버에 응답시 돌아오는 데이터의 형태 설정, 작성안하면 스마트하게 판단함
		xml :트리형태
		json:탭형태의 구조(일반적인 데이터 구조)
		script:javascript및 일반 String형태의 데이터
		html:html태그 자체를 return하는 방식
		text: String 데이터
		
	
	</pre>
	
	<h4>AJAX로 요청 보내고 응답 받아오기</h4>
	
	<h5>1. 서버로 요청시 인자값을 전달하고 응답데이터를 받아서 화면에 출력</h5>
	
	<label>오늘 먹을거 : </label> 알밥, 돈까스, 서브웨이, 김치찜, 막국수
	
	메뉴 : <input type="text" id="menu"/> <br/>
	수량 : <input type="number" id="amount" /> <br/><br/>
	<button id="btn">서버로 전송</button>
	
	<div id="resultMsg">
	 요건 어느속성에 들어갈까요
	</div>
	<!-- 1.버튼 클릭 시  2.메뉴에 입력한 음식명과 수량에 입력한 개수를 가지고 서버에 요청해서 => 3.응답받은 데이터를 div요소의 content영역에 출력-->
	<script >
		//console.log(btn); //금기사항 (요소만가지고 선택이 됨...)
		
		document.getElementById('btn').onclick =() => {
			
			const menuValue = document.getElementById('menu').value;
			const amountValue = document.getElementById('amount').value;
		
			
			$.ajax({
				url : 'ajax1.do', //필수정의 속성(매핑값)
				type : 'get', //요청 시 전달방식
				data : { //요청 시 전달 값(key-value)
					menuValue,
					amountValue
				},
				success : result => {
					
					const resultValue != 0? '선택하신 메뉴' + menuValue +' '+amountValue + '개의 가격은' + result + 'dnjs 입니다' : '값이 없습니다.'
					document.getElementById('resultMsg').innerHTML = resultValue;
					
				},
				error : () => {
					console.log('오타?');
				}
				
				});
			}
		
		
		
		
		
	</script>
	
	
	
	</p>
</body>
</html>