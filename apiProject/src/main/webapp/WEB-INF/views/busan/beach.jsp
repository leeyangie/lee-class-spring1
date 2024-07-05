<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부산 해수욕장 수질</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>부산해수욕장에 대장균 현황</h1>
	
	<table class="table table-success">
		<thead>
			<tr>
				<th>측정지점</th>
				<th>대장구균</th>
				<th>장구균</th>
				<th>측정일시</th>
				
			</tr>
		
		</thead>
		<tbody>
		
		
		</tbody>
	
	</table>
	<button class="btn btn-info" id="page">다음</button>
	
	<script>
		var pageNo = 1;
		$(() => {
			
			$.ajax({
				
				url : 'beach',
				type : 'get',
				data : { 
					pageNo : pageNo
				},
				success : info => {
					
					pageNo +=1;
					const items = info.getBeachInfo.body.items.item;
					 
					let strEl = '';
					for(let i in items) {
						
						const item = items[i];
						
						strEl += '<tr>'
							   + '<td>' + item.inspecArea + '</td>'
							   + '<td>' + item.water01 + '</td>'
							   + '<td>' + item.water02 + '</td>'
							   + '<td>' + item.inspecYm + '</td>'
							   + '</tr>'
					};
					$('tbody').html(strEl);
				}
				
			});
			
		});
	
	
	</script>
	
	
	
	
</body>
</html>