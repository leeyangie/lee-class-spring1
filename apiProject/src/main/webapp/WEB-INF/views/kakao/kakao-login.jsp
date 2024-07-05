<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오로그인</title>

<style>
	a{
		display: inline-block;
	}


</style>

</head>
<body>

	<a id="login-btn">
		<img alt="로그인버튼" src="resources/img/kakao_login_medium_narrow.png" >
	</a>
	
	<br>
	<button id="logout-btn">로그아웃</button>
	
	
	
	<script>
		
		document.getElementById('login-btn').onclick = () => {
			
			location.href = 'https://kauth.kakao.com/oauth/authorize'
						  + '?client_id=2f37c28b39f863b6ecbfad087824c474'
						  + '&redirect_uri=http://localhost/api/oauth'
						  + '&response_type=code';
						  + '&scope=nickname,profile_image';
		};
	
	</script>







<br><br><br><br><br><br><br><br>
</body>
</html>