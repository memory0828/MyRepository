<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	Exam05
	<hr/>
	1. <a href = "/myapp/exam05/index2/">String 리턴</a><br/> <!-- 이런 a태그는 get방식임 -->
	2. <a href = "/myapp/exam05/index3/">ModelAndView 리턴</a><br/> <!-- 이런 a태그는 get방식임 -->	
	3. <a href = "/myapp/exam05/index3/">void</a><br/> <!-- 이런 a태그는 get방식임 -->
	
	<!-- 	
	요청처리 메소드의 리턴타입
	String이 될수있고 ModelAndView도 void 될수있다.
	보통 뷰이름리턴시 String
	ModelAndView는 잘안쓰고 ModelAndView을 쓸경우에는 뷰이름을 리턴해야하고
	void 요청경로의  마지막 .jsp를 찾는다 근데 보통이렇게 쓰지않고, jsp에 전송하지 않고 자바안에서 처리를 원할때 void를 쓴다
	 -->
</body>
</html>