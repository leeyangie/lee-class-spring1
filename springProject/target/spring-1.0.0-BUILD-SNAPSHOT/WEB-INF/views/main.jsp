<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B강의장 프로젝트 입니다.</title>
<style>
	#content{ height: 800px; margin: 100px;}"
</style>
</head>
<body>
	
	<jsp:include page="common/menubar.jsp"></jsp:include>
	
	<div id="content">
	
		<h3>게시글 조회수 TOP5</h3>
		<br>
		<a href="list.board" style="float:right; color:lightgray; font-weight:800; font-size:14px">더보기></a>
		<br>
		
		<table class="table table-hover" align="center" id="boardList">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
					<th>첨부파일</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
		<br><br>
		<table id="board-detail" class="table">
		
		</table>
	</div>
	
	<script>
	
		//조회된 게시글 목록 - 게시글클릭 - 선택한 글번호 - 게시글 정보 - ajax요청 - id속성값이 board-detail인 table에 자식요소를 만들어 출력
		
		$(()=>{
			
			$(document).on('click', '#boardList > tbody > tr', e => {
				
				const boardNo = $(e.currentTarget).children().eq(0).text();
				//뭔지 모르겠음
				//console.log(boardNo);
				
				$.ajax({
					url: 'boards/' + boardNo,
					type: 'get',
					success : result => {
						console.log(result);
						
						let value = '<tr><td colspan="3">게시글 상세보기 </td></tr>';
						value += '<tr>'
							   + '<td width="300">' + result.boardTitle + '</td>'
							   + '<td width="600">' + result.boardContent + '</td>'
							   + '<td width="200">' + result.boardWriter + '</td>'
							   + '</tr>';
							   
						 $('#board-detail').html(value);
					}		  
				})
				
			}); 
		});
	
	
	
		$(() => {
			findTopFiveBoard();
		})
	
		function findTopFiveBoard(){
			$.ajax({
				url : 'boards',
				type : 'get',
				success : boards => {
					
					console.log(boards);
					
					let value = "";
					
					for(let i in boards) {
						
						value  += '<tr>'
								+ '<td>' + boards[i].boardNo + '<td>'
								+ '<td>' + boards[i].boardTitle + '<td>'
								+ '<td>' + boards[i].boardWriter + '<td>'
								+ '<td>' + boards[i].count + '<td>'
								+ '<td>' + boards[i].createDate + '<td>'
								+ '<td>' ;
								if(boards[i].originName != null) {
									value += '♡';
								}
								+ '</td></tr>';
					}
					$('#boardList tbody').html(value);
				}
			});
		}
		
		function deleteTopFiveBoard(){
			$.ajax({
				url : 'boards'+ boardNo ,
				type : 'delete',
				success : response => {
					
			
			}	
			});
		}
		
	</script>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>