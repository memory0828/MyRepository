<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	SpringProgramming
	<hr/> <!--  시작과 동시에 끝이다. 일땐 이렇게 써도됨
	                내용이 있으면 시작태그와 끝태그를 명시적으로 넣어주기 -->
	                
	<!-- 아래 경로 결과는 다 동일한데 차이는-->	
	<!-- 절대경로 -->
	<!--  1. <a href ='http://localhost:8080/myapp/exam01/join'>컨트롤러 및 요청 매칭 메소드 작성</a><br>  -->
	
	<!-- 상대경로는 /도 없이 시작하는데
	      현재 페이지의 URL에다가 추가적으로 더 붙인다 즉 ( 앞에는 http://localhost:8080/myapp/를 붙여서 ) -->
	<!--  2. <a href ='exam01/join'>컨트롤러 및 요청 매칭 메소드 작성</a><br> -->
	
	<!-- 절대경로지만 http://localhost:8080가 생략되고 
	      / ->부터 시작하는데
	      현재 이페이지가 있는 서버의 http://localhost:8080 이 내용이 동일하다 는 의미 -->
	<!-- ★앞으론 이런 방식으로 쓰려고한다. -->
	 <a href ='/myapp/exam01/index'>Exam01</a> : 컨트롤러 및 요청 매칭 메소드 작성<br>
	 <a href ='/myapp/exam02/index'>Exam02</a> : 요청 파라미터 값 받기<br>	 
	 <a href ='/myapp/exam03/index'>Exam03</a> : 폼 입력 값 받기<br>	 

</body>
</html>
