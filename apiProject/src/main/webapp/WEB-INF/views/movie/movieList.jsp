<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
        #page1 { height: 80px;}
        .movies {
            width : 1200px;
            margin : auto;
            display: flex;
            flex-wrap: wrap;
            gap : 30px;
        }
        #page2 { 
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .Movie-enroll-title {
            text-align: center;
        }
        .Movie-enroll-title h2 {
            line-height: 1.7em;
            margin-top: 10px;
        }
        #pills-tab {
            margin-top: 50px;
            margin-bottom: 50px;
        }
        #page3 {
        display: flex;
        align-items: center;
        justify-content: center;
        margin-top: 50px;
        margin-bottom: 50px;
	    }
	    
	    #listbutton {
	    	margin : 20px auto;
	    }
	    
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <a href="#" class="navbar-brand d-flex align-items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2">
                        <rect x="2" y="7" width="20" height="15" rx="2" ry="2"></rect>
                        <path d="M16 3l-4 4H3L7 3z"></path>
                        <path d="M22 3l-4 4h-9L17 3z"></path>
                    </svg>
                    <strong>Cine HY</strong>
                </a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">영화</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">극장</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">예매</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">극장</a>
                    </li>
                </ul>
                <form class="form-inline mt-2 mt-md-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">회원가입</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <main>
    <div id="page1"></div>
    <div id="page2">
        <div>
            <div class="Movie-enroll-title">
                <h2 class="mb-4">영화 등록</h2>
            </div>
            <form class="form-inline mt-2 mt-md-0">
                <span class="input-group-text">영화검색</span>
                <input type="text" class="form-control">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
            </form>
        </div>
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button">박스오피스</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button">상영예정작</button>
            </li>
        </ul>
        <br/>
        <div class="tab-content" id="pills-tabContent">
            <hr/>
            <div class="tab-pane fade show active" id="pills-home" role="tabpanel">
                <ul id="movieList" class="movies"></ul>
                <nav aria-label="...">
                    <ul class="pagination pagination-sm">
                        <li class="page-item active">
                            <span class="page-link" id="pageNo">1</span>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#" onclick="changePage(2)">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#" onclick="changePage(3)">3</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="tab-pane fade" id="pills-profile" role="tabpanel">
                <hr/>
                 <ul id="movieUpList" class="movies"></ul>
            </div>
        </div>
    </div>
    <div id="page3">
	    <div>
	    선택한 영화
	    <br><br><br>
	        <div class="card mb-8" style="max-width: 540px; margin-right: 50px">
	            <div class="row g-0">
	                <div class="col-md-4">
	                    <img src="https://picsum.photos/200/250" class="img-fluid rounded-start" alt="...">
	                </div>
	                <div class="col-md-8">
	                    <div class="card-body">
	                        <h5 class="card-title">인사이드 아웃</h5>
	                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
	                        <p class="card-text"><small class="text-body-secondary">전체관람등급</small></p>
	                    </div>
	                </div>
	            </div>
	            <button type="button" class="btn btn-primary">등록하기</button>
	        </div>
        </div>
        <div class="card mb-4" id="Movie-enroll-list-card" style="width: 20rem;">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">인사이드 아웃</li>
                <li class="list-group-item">핸섬가이즈</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
                <li class="list-group-item">매드맥스 사가</li>
            </ul>
            <div id="listbutton" class="mt-3">
            <button type="button" class="btn btn-primary btn-sm">Small button</button>
            <button type="button" class="btn btn-secondary btn-sm" onclick="nextPage()">Small button</button>
        	</div>
        </div>
        
    </div>
    </main>
    
    <script>
        $(document).ready(function() {
            var currentPage = 1;
            function fetchMovies(pageNo) {
                $.ajax({
                    url: 'movieList/nowPlaying',
                    method: 'get',
                    dataType: 'json',
                    data: { pageNo: pageNo },
                    success: function(data) {
                        displayMovies(data);
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.error('Error fetching movie data:', textStatus, errorThrown);
                    }
                });
            }

            function displayMovies(data) {
                var movieList = $('#movieList');
                movieList.empty();
                if (data.results && data.results.length > 0) {
                    const movies = data.results;
                    let movieHtml = '';
                    for(let i in movies) {
                        movieHtml += '<div class="card" style="width: 12rem;">'
                          + '<img src="https://image.tmdb.org/t/p/w500' + movies[i].poster_path + '" class="card-img-top">'
                          + '<div class="card-body">'
                          + '<h5 class="card-title">' + movies[i].title + '</h5>'
                          + '<p class="card-text">' + movies[i].title + '</p>'
                          + '</div>'
                          + '<ul class="list-group list-group-flush">'
                          + '<li class="list-group-item">' + movies[i].release_date + ' 개봉</li>'
                          + '</ul>'
                          + '<div class="card-body">'
                          + '<div class="btn-group">'
                          + '<button type="button" class="btn btn-sm btn-outline-secondary" onclick=viewDetail()>View</button>'
                          + '<button type="button" class="btn btn-sm btn-outline-secondary" href>등록하기</button>'
                          + '</div>'
                          + '</div>'
                          + '</div>';
                    }
                    movieList.html(movieHtml);
                } else {
                    movieList.append('<li>No movies currently playing.</li>');
                }
            }

            function changePage(pageNo) {
                currentPage = pageNo;
                $('#pageNo').text(pageNo);
                fetchMovies(pageNo);
            }

            window.changePage = changePage;
            window.nextPage = function() {
                changePage(currentPage + 1);
            }

            fetchMovies(currentPage);
        });
    </script>
    
    <script>
        $(document).ready(function() {
            var currentPage = 1;
            function fetchUpMovies(pageNo) {
                $.ajax({
                    url: 'movieList/upComming',
                    method: 'get',
                    dataType: 'json',
                    data: { pageNo: pageNo },
                    success: function(data) {
                        displayUpMovies(data);
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.error('Error fetching movie data:', textStatus, errorThrown);
                    }
                });
            }

            function displayUpMovies(data) {
                var movieList = $('#movieUpList');
                movieList.empty();
                if (data.results && data.results.length > 0) {
                    const movies = data.results;
                    let movieHtml = '';
                    for(let i in movies) {
                        movieHtml += '<div class="card" style="width: 12rem;">'
                          + '<img src="https://image.tmdb.org/t/p/w500' + movies[i].poster_path + '" class="card-img-top">'
                          + '<div class="card-body">'
                          + '<h5 class="card-title">' + movies[i].title + '</h5>'
                          + '<p class="card-text">' + movies[i].title + '</p>'
                          + '</div>'
                          + '<ul class="list-group list-group-flush">'
                          + '<li class="list-group-item">' + movies[i].release_date + ' 개봉</li>'
                          + '</ul>'
                          + '<div class="card-body">'
                          + '<div class="btn-group">'
                          + '<button type="button" class="btn btn-sm btn-outline-secondary" onclick=viewDetail()>View</button>'
                          + '<button type="button" class="btn btn-sm btn-outline-secondary" href>등록하기</button>'
                          + '</div>'
                          + '</div>'
                          + '</div>';
                    }
                    movieList.html(movieHtml);
                } else {
                    movieList.append('<li>No movies currently playing.</li>');
                }
            }

            
            fetchUpMovies(currentPage);
        });
    </script>
    <footer class="bg-dark text-light pt-5 pb-4">
      <div class="container text-center text-md-left">
          <div class="row text-center text-md-left">
              <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                  <h5 class="text-uppercase mb-4 font-weight-bold text-warning">Cine HY</h5>
                  <p>최고의 영화 예매 사이트 Cine HY에 오신 것을 환영합니다. 다양한 최신 영화를 만나보세요.</p>
              </div>

              <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                  <h5 class="text-uppercase mb-4 font-weight-bold text-warning">Quick Links</h5>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Home</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Movies</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Theaters</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Booking</a></p>
              </div>

              <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                  <h5 class="text-uppercase mb-4 font-weight-bold text-warning">Useful Links</h5>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Account</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Help</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Contact Us</a></p>
                  <p><a href="#" class="text-light" style="text-decoration: none;">Privacy Policy</a></p>
              </div>

              <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                  <h5 class="text-uppercase mb-4 font-weight-bold text-warning">Contact</h5>
                  <p><i class="fas fa-home mr-3"></i> Seoul, South Korea</p>
                  <p><i class="fas fa-envelope mr-3"></i> info@cinehy.com</p>
                  <p><i class="fas fa-phone mr-3"></i> + 82 10 1234 5678</p>
                  <p><i class="fas fa-print mr-3"></i> + 82 10 8765 4321</p>
              </div>
          </div>

          <div class="row align-items-center">
              <div class="col-md-7 col-lg-8">
                  <p class="text-center text-md-left">© 2023 Cine HY. All Rights Reserved.</p>
              </div>

          </div>
      </div>
  </footer>
    
    
    
    
</body>
</html>