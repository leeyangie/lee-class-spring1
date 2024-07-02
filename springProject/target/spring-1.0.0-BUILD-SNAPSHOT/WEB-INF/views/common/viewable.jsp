<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>var, let, const</h1>
	
	<h2>변수 선언 시 사용할 수 있는 키워드들</h2>

	<button onclick="defDeclare()"></button>
	
	
	<script>
	
		function defDeclare() {
			
			var userId = 'user01';
			console.log(userId);
			
			//var는 재선언 할 수 있음
			//제일 처음 만들어짐
			var userId = 'user02'
			console.log(userId);
			
			
		}
	
	</script>
	
	<h1>요소</h1>
	
	<button></button>
	
	
	
</body>
</html>