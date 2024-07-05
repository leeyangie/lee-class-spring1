<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
#kh-bg {
	width : 800px;
	height : 450px;
	background-image: url('https://images.unsplash.com/photo-1498747946579-bde604cb8f44?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHN1bW1lcnxlbnwwfHwwfHx8MA%3D%3D');
	margin-top: ;
	display: flex;
	justify-content : center;
	background-repeat: no-repeat;
	background-position: center;
	background-size: 100% auto;

}

#search-btn {
	float: right;
}

.items {
	width : 1000px;
	margin : auto;
	display: flex;
	flex-wrap: wrap;
	gap : 30px;
}




</style>
</head>
<body>

<nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="data:image/jpeg;base64,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" alt="Logo" width="70" class="d-inline-block align-text-top" >
      KH몰
    </a>
  </div>
  
  <div class="container-fluid">
    <form class="d-flex" role="search">
      <input id="keyword" class="form-control me-2" type="search" placeholder="상품을 입력해주세요" aria-label="Search">
      <button id="search-btn" class="btn btn-outline-success" type="button">Search</button>
    </form>
  </div>
  
</nav>

<div id="kh-bg">

</div>

<hr/>

<br>
<div id="total-count" style="display:none; padding:30px;, text-align:right;">

</div>
<div class="items">

</div>

<button class="button btn-lg" style="">다음상품</button>

<script>

	$('#search-btn').click(() => {
		searchItem();
		
	});
	
	function nextPage() {
		startNo += 9;
		searchItem();
	};
	
	var startNo = 1;

	function searchItem() {
		
		const $keyword = $('#keyword').val();
		
		$.ajax({
			
			url : 'product',
			type : 'get',
			data : {
				keyword : $keyword,
				start : startNo
			},
			success : product => {
				$('#total-count').fadeOut(1000);
				console.log(product);
				$('#total-count').html('중 <b>' + product.total + '</b>건의'
						+'<labe style="color:red; front-weight:bold;">' + $keyword + '</labe>이 검색되었습니다.')
						.fadeIn(1000);
				
				startNo +=9;
				const items = product.items;
				let item = '';
				
				for(let i in items) {
					
					item += '<div class="card" style="width: 18rem;">'
					  + '<img src="' + items[i].image + '" class="card-img-top">'
					  + '<div class="card-body">'
					  + '<h5 class="card-title">' + items[i].brand + '</h5>'
					  + '<p class="card-text">' + items[i].title +'</p>'
					  + '</div>'
					  + '<ul class="list-group list-group-flush">'
					  + '<li class="list-group-item">가격</li>'
					  + '<li class="list-group-item">'+items[i].lprice+'원</li>'
					  + '</ul>'
					  + '<div class="card-body">'
					  + '<a href="#" class="card-link">구매하러가기</a>'
					  + '</div>'
					  +'</div>';
				};
				$('.items').html(item);
			}
			
		});
	};


</script>






</body>
</html>