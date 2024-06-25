<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    
    <jsp:include page="../common/menubar.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>마이페이지</h2>
            <br>

            <form action="update.do" method="post">
                <div class="form-group">
                    <label for="userId">* ID : </label>
                    <input type="text" class="form-control" id="userId" value="${ sessionScope.loginUser.userId }" name="userId" readonly> <br>

                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" value="${ sessionScope.loginUser.userName}" name="userName" required> <br>

					<label for="userPwd">* PassWord : </label>
                    <input type="password" class="form-control" id="userPwd" value="${ sessionScope.loginUser.userPwd}" name="userPwd" required readonly> <br>
						
                    <label for="email"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="email" value="${ sessionScope.loginUser.email}" name="email"> <br>

                    <label for="age"> &nbsp; Age : </label>
                    <input type="number" class="form-control" id="age" value="${ sessionScope.loginUser.age}" name="age"> <br>

                    <label for="phone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="phone" value="${ sessionScope.loginUser.phone}" name="phone"> <br>
                    
                    <label for="address"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="address" value="${ sessionScope.loginUser.address}" name="address"> <br>
                    
                    <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp;
                    <input type="radio" id="Male" value="M" name="gender">
                    <label for="Male">남자</label> &nbsp;&nbsp;
                    <input type="radio" id="Female" value="F" name="gender">
                    <label for="Female">여자</label> &nbsp;&nbsp;
                    
                    <script>
						window.onload = () => {
							
							//속성 선택자
							//SessionScope.loginUser.gender
							//javascript
							//document.querySelector('input[value=${sessionScope.loginUser.gender}]').checked = true;
						}
						
						//jquery
						$(() => {
							
							//콘솔에 출력
							//console.dir($('input[value="${sessionScope.loginUser.gender}"]'));
							
							$('input[value="${sessionScope.loginUser.gender}"]').attr('checked', true);
						})
							
							
						
					</script>
                    
                    
                    
                </div> 
                <br>
                <div class="btns" align="center">
                    <button type="submit" class="btn btn-primary">수정하기</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#passwordForm">비밀번호 수정하기</button>
                </div>
            </form>
        </div>
        <br><br>
        
    </div>
 
 
    <!-- 회원탈퇴 버튼 클릭 시 보여질 Modal -->
    <div class="modal fade" id="deleteForm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form action="delete.do" method="post">
                <!-- 회원탈퇴시 비밀번호는 암호화값이 중복될수 있기 때문에 해당 회원만 식별할 수 있는 아이디(PK) 값도 같이 있어야함 -->
                	<input type="hidden" value=${ sessionScope.loginUser.userId }" name="userId"/>
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
                            탈퇴 후 복구가 불가능합니다. <br>
                            정말로 탈퇴 하시겠습니까? <br>
                        </div>
                        <br>
                            <label for="userPwd" class="mr-sm-2">Password : </label>
                            <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd"> <br>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger" onclick="return deletePrompt();">탈퇴하기</button>
                    </div>
                </form>
                
                <script>
                	function deletePrompt() {
						const value = prompt('탈퇴를 원하신다면 "탈퇴합니다"를 정확히 입력해주세요.')	
						return value === '탈퇴합니다' ? true : false;
					}
                
                </script>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="passwordForm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 변경</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form action="delete.do" method="post">
                <!-- 회원탈퇴시 비밀번호는 암호화값이 중복될수 있기 때문에 해당 회원만 식별할 수 있는 아이디(PK) 값도 같이 있어야함 -->
                	<input type="hidden" value=${ sessionScope.loginUser.userId }" name="userId"/>
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
                            탈퇴 후 복구가 불가능합니다. <br>
                            정말로 탈퇴 하시겠습니까? <br>
                        </div>
                        <br>
                            <label for="userPwd" class="mr-sm-2">Password : </label>
                            <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd"> <br>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger" onclick="return deletePrompt();">탈퇴하기</button>
                    </div>
                </form>
                
                <script>
                	function deletePrompt() {
						const value = prompt('탈퇴를 원하신다면 "탈퇴합니다"를 정확히 입력해주세요.')	
						return value === '탈퇴합니다' ? true : false;
					}
                
                </script>
            </div>
        </div>
    </div>

    <jsp:include page="../common/footer.jsp" />


</body>
</html>