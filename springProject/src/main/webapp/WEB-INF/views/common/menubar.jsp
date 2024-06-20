<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <!-- alertjs -->
    <!-- JavaScript -->
	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/alertify.min.js"></script>
	<!-- CSS -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/alertify.min.css"/>
	<!-- Default theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/default.min.css"/>
	<!-- Semantic UI theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/semantic.min.css"/>
    <style>
        div {box-sizing:border-box;} 
        #header {
            width:80%;
            height:100px;
            padding-top:20px;
            margin:auto;
        }
        #header>div {width:100%; margin-bottom:10px;}
        #header_1 {height:80%;}
        #header_2 {height:60%;}

        #header_1>div{
            height:100%;
            float:left;
        }
        #header_1_left {width:30%; position:relative;}
        #header_1_center {width:40%;}
        #header_1_right {width:30%;}

        #header_1_left>img {height:100%; position:absolute; margin:auto; top:0px; bottom:0px; right:0px; left:0px;}
        #header_1_right {text-align:center; line-height:35px; font-size:12px; text-indent:35px;}
        #header_1_right>a {margin:5px;}
        #header_1_right>a:hover {cursor:pointer;}

        #header_2>ul {width:100%; height:100%; list-style-type:none; margin:auto; padding:0;}
        #header_2>ul>li {float:left; width:25%; height:100%; line-height:55px; text-align:center;}
        #header_2>ul>li a {text-decoration:none; color:black; font-size:18px; font-weight:900;}

        #header_2 {border-top:1px solid lightgray;}

        #header a {text-decoration:none; color:black;}

        .content {
            background-color:rgb(247, 245, 245);
            width:80%;
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }

    </style>
</head>
<body>
	<c:if test="${ not empty alertMsg }">
	<script>
		alertify.alert('알림','${alertMsg}');
	</script>
		<%-- <c:remove var="alertMsg"/> --%>
	</c:if>
    <div id="header">
        <div id="header_1">
            <div id="header_1_left">
                <img src="https://kh-academy.co.kr/resources/images/main/logo.svg" alt="">
            </div>
            <div id="header_1_center"></div>
            <div id="header_1_right">
                <c:choose>
                	<c:when test="${ sessionScope.loginUser eq null }">
	                
	                	<a href="enroll.do">회원가입</a>
	                	<a data-toggle="modal" data-target="#loginModal">로그인</a> 
                	</c:when>
	                
	                <c:otherwise>
	                    <lable> ${ sessionScope.loginUser. userName}님 환영합니다</label> &nbsp;&nbsp;
	                    <a href="mypage.do">마이페이지</a>
	                    <a href="logout.do">로그아웃</a>
	                </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div id="header_2">
            <ul>
                <li><a href="">HOME</a></li>
                <li><a href="">공지사항</a></li>
                <li><a href="boardList">자유게시판</a></li>
                <li><a href="">사진게시판</a></li>
            </ul>
        </div>
    </div>

    <!-- 로그인 클릭 시 뜨는 모달 (기존에는 안보이다가 위의 a 클릭 시 보임) -->
    <div class="modal fade" id="loginModal">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Login</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
        
                <form action="login.do" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <label for="userId" class="mr-sm-2">ID : </label>
                        <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter ID" id="userId" name="userId"> <br>
                        <label for="userPwd" class="mr-sm-2">Password : </label>
                        <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd">
                    </div>
                           
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success">로그인</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
    
    <br clear="both">
</body>
</html>