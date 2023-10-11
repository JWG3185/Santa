<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="resources/css/login.css">
<title>로그인</title>
</head>
<body>
	<div class="login-page" >

		<div class="login-content login-content-signin" ng-hide="showSignIn">
			<div>
				<h1 class="h1">santa</h1>
			</div>
			<div>
				<h2 class="h2">Log in</h2>
				<form method="POST" class="wrapper-box" role="form">
					<input type="email"  name="userEmail" class="form-control form-control-email"
						placeholder="Email address" required> 
					<input type="password" name="userPwd" class="form-control form-control-password" 
					placeholder="Password" required>


					<a href="${pageContext.request.contextPath}/user.do">
						<button type="submit" class="btn">Log in</button>
					</a>
					<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
				</form>
			</div>
		</div>


	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js"></script>
	
	<script>
	const msg = "${msg}";
	if(msg)
		alert(msg);
	</script>	

</body>
</html>