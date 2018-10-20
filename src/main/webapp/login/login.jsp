<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Welcome to Carroty</title>
<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/signin.css" rel="stylesheet">
<%@include file="/common/basicLib.jsp"%>

<script>
     $(document).ready(function(){
    	 console.log("test");
    	 //remember 쿠키 값이 Y이면 체크박스 체크
    	 if(getCookie("remember") == "Y"){
    		 //$("#remember-me").prop("checked", true);
    		 $("#remember-me").attr("checked", true);
    		 $("#userId").val(getCookie("userId"));
    	 }
    	 
     });
     	// 쿠키 값 확인하기
     	// 브라우저에서 확인해보세요 getCookie("remember")
    	function getCookie(cookieName){
	 		var cookieValue = "";
	 		var cookies = document.cookie.split("; ");
	 		for(var i =0 ; i<cookies.length ; i++){
	 			var str = cookies[i];
	 			if(str.startsWith(cookieName+"=")){
	 				cookieValue = str.substring((cookieName+"=").length);
	 			}
	 		}
	 		return cookieValue;
 		}
    </script>
</head>

<body class="text-center">
	<div class="container">
		<form class="form-signin" action="/loginServlet" method="post">
			<h1 class="h3 mb-3 font-weight-bold font-italic">Belle Board</h1>
			<br />
			<br />
			<label for="inputID" class="sr-only">ID</label>
			<!-- ID 입력박스 -->
			<input type="text" name="userId" id="userId" class="form-control"
				placeholder="your ID" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label>
			<!-- PW 입력박스 -->
			<input type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Password" value="brownpass" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" id="remember-me"
					name="remember-me" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2018. SoHyoung Lee all
				rights reserved.</p>
		</form>
	</div>
</body>
</html>


















