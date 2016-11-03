<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		* {
			margin:0px;
			padding:0px;
		}
	</style>
	<script type="text/javascript">
		function checkLoginForm() {
			console.log("checkLoginForm() 실행");
			var mid = document.querySelector("#mid").values;
			var mpassword = document.querySelector("#mpassword").values;
			console.log(mid);
			if(mid =="" || mpassword =="" ){
				alert("아이디 또는 패스워드가 입력되지 않습니다.");
				return false;
			} else if(mid.length < 4 || mid.length > 10) {
				alert("아이디 또는 패스워드가 입력되지 않습니다.");
				return false;
			} else if(mpasword.length > 10) {
				alert("아이디 또는 패스워드가 입력되지 않습니다.");
				return false;
			}
			return false;
			
		}
	
	
	</script>
	
</head>
<body>
	유효성 검사(입력값 검사)
	<br>★
	<br>★
	<br>
	<a href="index.jsp">index로</a>
	<hr />

	<b>★</b>
	
	<!-- submit 이벤트가 발생(onsubmit)했을 때 checkLoginForm() 이 함수를 실행하는데
	얘가 실행하면서 뭔가 문제점을 발견했을 때 return false를 해서 form에서 문제점이 있는것을 알려준다  -->
	<!-- 그리고 제일 중요한거 아래  onsubmit="return ... 으로 checkLoginForm()의 리턴값은 다시 form으로 리턴하는 소스가 들어간다는 점이다 --> 
	<form id="loginForm" onsubmit="return checkLoginForm()">
		아이디 : <input type="text" id="mid" name="mid"><br/> 
		비밀번호 : <input type="password" id="mpassword" name="mpassword"><br/>
		<input type="submit" value="로그인"/>
	</form>

<script>	

</script>
	



</pre>
</body>
</html>