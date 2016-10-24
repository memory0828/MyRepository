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
	 ■1 <a href ='/myapp/exam01/index'>Exam01</a> : 컨트롤러 및 요청 매칭 메소드 작성<br/>
	 ■2 <a href ='/myapp/exam02/index'>Exam02</a> : 요청 파라미터 값 받기<br/>	 
	 ■3 <a href ='/myapp/exam03/index'>Exam03</a> : 폼 입력 값 받기<br/>	 
	 ■4-1 <a href ='/myapp/exam04/index'>Exam04</a> : 요청방식 별 처리 - 9/29, 9/30<br/>	
	 ■4-2 <a href="/myapp/exam04_board/index">게시판</a> - 9/30 <br/> 
	 ■5 <a href ='/myapp/exam05/index'>Exam05</a> : 요청 처리 메소드의 리턴타입 - 9/30 <br/>	 
	 ■6 <a href ='/myapp/exam06/index'>Exam06</a> : 요청 처리 메소드의 매개 변수 타입 - 9/30, 10/4<br/>
	 ■7 <a href ='/myapp/exam07/index'>Exam07</a> : 컨트롤러에서 JSP로 데이터 객체 전달 - 10/4, 10/6<br/>	 
	 ■8 <a href ='/myapp/exam08/index'>Exam08</a> : 리다이렉트 - 10/6<br/>
	 <br/>	 
	 ■9. <a href ='/myapp/exam09/index'>Exam09</a> : 의존성 주입(DI) - XML설정 파일 이용 10/6, 10/7<br/>	 
	 ■10. <a href ='/myapp/exam10/index'>Exam10</a> : 의존성 주입(DI) - 어노테이션 이용 10/7<br/>	 
	<br/>	 
	 ■11. <a href ='/myapp/exam11/index'>Exam11</a> : 서비스 계층과 데이터(퍼시스턴스(=데이터가 계속적으로 지속적으로 사용해 한다)) 계층)10/12<br/>
	 - 데이터(퍼시스턴스) 계층을 데이터화 작업을 하는 계층임<br/> 
	 ■12. <a href ='/myapp/exam12/index'>Exam12</a> : 커넥션 풀 설정<br/>	 
</body>
</html>
