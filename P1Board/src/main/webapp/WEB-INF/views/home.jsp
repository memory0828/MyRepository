<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	SpringBoardProgramming<br/>
	<hr/>         
	<!-- 동적으로 context알아내는 방법1 표현식 방법 사용 -->
	1.
	<c:if test="${login == null}">
	<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a></br>
	</c:if>
	<c:if test="${login != null}">
	<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a></br>
	</c:if>
		 
	<!-- 동적으로 context알아내는 방법2 표현 언어 사용 -->
	2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유게시판</a></br>
	3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a></br>
 	   
</body>
</html>



