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
	
		<!-- ${member.mid} 같은건 리퀘스트에 있는 model에 저장하는 효과... 기억나지?? -->
		아이디: <input type="text" name="mid" value="${member.mid}"/>
		<a href="checkMid">중복체크(추후함)</a>
		<br/>
		이름: <input type="text" name="mname" value="${member.mname}"/>
		<br/>		
		패스워드: <input type="password" name="mpassword"/>
		<br/>
		휴대전화: <input type="tel" name="mtel" value="${member.mtel}"/>
		<br/>
		이메일: <input type="email" name="memail" value="${member.memail}"/>
		<br/>
		주소: <input type="text" name="maddress" value="${member.maddress}"/>
		<br/>		
		<input type="submit" value="가입"/>
	</form>
</body>
</html>