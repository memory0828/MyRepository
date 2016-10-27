<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	로그인
	<hr/>
	<form method="post" action=""> <!-- action=""한것은 같은요청경로로 post방식으로 요청함 처리임 -->
		아이디: <input type="text" name="mid" value="${findMid}"/><br/>
		<c:if test="${error == 'LOGIN_FAIL_MID'}">*아이디가 존재하지 않음</c:if>
		패스워드: <input type="password" name="mpassword"/><br/>
		<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}">*패스워드가 틀림</c:if>
		<br/>
		<input type="submit" value="로그인"/>
	</form>
	<!-- {pageContext.servletContext.contextPath} 절대경로 쓰기  -->
	<a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/>
	<a href="findMid">아이디 찾기</a>
	비밀번호 찾기
</body>
</html>