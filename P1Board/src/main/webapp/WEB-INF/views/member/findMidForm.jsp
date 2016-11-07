<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	아이디 찾기
	<hr/>
	<form method="post" action=""> <!-- action=""한것은 같은요청경로로 post방식으로 요청함 처리임 -->
		이메일: <input type="email" name="memail"/>${error}<br/>
		<input type="submit" value="찾기"/>
	</form>
</body>
</html>