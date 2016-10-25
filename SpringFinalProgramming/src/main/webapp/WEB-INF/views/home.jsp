<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	SpringBoardProgramming<br/>
	<hr/>         
	<!-- 동적으로 context알아내는 방법1 표현식 방법 사용 -->
	1. <a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a></br>
	<!-- 동적으로 context알아내는 방법2 표현 언어 사용 -->
	2. <a href="${pageContext.servletContext.contextPath}/myweb/freeboard">자유게시판</a></br>
	3. <a href="${pageContext.servletContext.contextPath}/myweb/photoboard">포토 게시판</a></br>
 	 
</body>
</html>



