<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SANTA</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- 메인화면 CSS File -->
<link href="resources/css/style.css" rel="stylesheet">

  <!-- 메인화면 JS File -->
<script src="resources/js/main.js"></script>
  <!-- 슬라이더 JS File -->
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<style>
ul {
	list-style: none;
	padding-left: 0px;
}
</style>

</head>
<body>
  <!-- ======= Header ======= -->
  <div>
  <jsp:include page="header.jsp"></jsp:include>
  </div>

  <!-- ======= 베너 Section ======= -->
  <section id="banner" class="d-flex justify-content-center align-items-center img-fluid">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="resources/img/배너1.png" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="resources/img/베너2.png" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="resources/img/베너3.png" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
  </section>
  <!-- End 베너 -->

  <main id="main">

    <!-- ======= 신상품 Section ======= -->
    <section id="popular-courses" class="courses">
      <div class="container" ><!-- data-aos="fade-up" -->
      
        <div class="section-title">
          <h2>New</h2>
          <p>신상품</p>
        </div>

        <div class="row" ><!-- data-aos="zoom-in" data-aos-delay="100" -->

       	 <c:forEach var="item" items="${list}">
          <div class="col-lg-3 col-md-6 align-items-stretch mt-4">
            <div class="course-item">
			<!-- <img src="resources/img/아이폰15pro.jpg" class="img-fluid" alt="..."> -->
			  <p>${item.pImg1}</p> <!-- 이미지 DB에 제대로 넣으면 바꿔야해! -->
              <div class="course-content">
                <div class="d-flex justify-content-between align-items-center mb-3">
                  <h4>제조사</h4>
                  <p class="price"><a href="detail.do?pNo=${item.pNo}">${item.pName}</a></p>
                </div>

                <p>${item.pCode}</p>
                <p>${item.pInfo}</p>
              </div>
            </div>
          </div> <!-- End 상품 -->
		</c:forEach>

        </div>
        
        <br>
        <div class="d-flex align-items-center justify-content-center">
        	<a href="/list" class="btn outlinegrey medium" style="border: 1px solid #eef0ef;"> 더보기 </a>
        </div>

      </div>
    </section>
    <!-- End 인기상품 Section -->
    
    

  </main>
  <!-- End #main -->

	<!-- ======= Footer ======= -->
	<div>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!-- End Footer -->

	<div>
	  <a href="#"><img src="resources/img/화살표.png"  class="back-to-top d-flex align-items-center justify-content-center" alt="..." >top</a>
	</div>
 

</body>
</html>