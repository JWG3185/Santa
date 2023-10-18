<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품판매</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <jsp:include page="../header.jsp"></jsp:include>
  
  <link href="${pageContext.request.contextPath}/resources/css/sellbuy.css" rel="stylesheet">
  
</head>
<body>
   <!-- ======= 판매 폼 ======= -->
   <div class="content">
       <div class="text-center content_type">
           <p><span>판매</span>하기</p>
       </div>
       <div class="wrap ctn">
           <div id="item_info">
               <div id="item_img">
                   <img src="${pageContext.request.contextPath}/resources/img/iphone15protita.png" alt="상품이미지">
               </div>
               <div id="item_detail">
                   <span>apple_iphone14pro_128G_silver</span>
                   <span>아이폰 14 프로 128기가 실버</span>
               </div>
           </div>
           <div id="grade_select">
               <ul class="select_List">
                   <li class="select_item">
                       <button>
                           <div>
                               <span>S</span><br>
                               <span class="sell">900,000</span>
                           </div>
                       </button>
                   </li>
                   <li class="select_item">
                       <button>
                           <div>
                               <span>A</span><br>
                               <span class="sell">800,000</span>
                           </div>
                       </button>
                   </li>
                   <li class="select_item">
                       <button>
                           <div>
                               <span>B</span><br>
                               <span class="sell">750,000</span>
                           </div>
                       </button>
                   </li>
               </ul>			
           </div>
           <div class="sub">
               <button>
                   <div>
                       <span>판매상품 체크하기</span>
                   </div>
               </button>
           </div>
       </div>
   </div>
   <!-- ======= 판매 폼 끝 ======= -->

  <!-- ======= Footer ======= -->
  <jsp:include page="../footer.jsp"></jsp:include>
  <!-- End Footer -->
</body>
</html>