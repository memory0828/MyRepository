<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %> <!-- 1번의역할만 담당 : 이거 생략되어있으면 위 "text/html;charset=UTF-8"로 처리  -->
<!-- page contentType = "text/html;charset=UTF-8" -->
<!-- 위역할 1. 파일저장 인코딩 / 2. HTML내용이 어떤 문자셋(브라우저에 전달되서 브라우저에서 해석될때 어떤 문자타입인지)  -->
<!-- 컨텐트 타입이라는 html요청 ... 에 들어가는 내용 -->

<!DOCTYPE html> <!-- 뒤에는 문서유형 즉 여기선 html을 뜻한다 -->
<html> 
<head> <!-- HTMl(내용의 구조 (뼈대)) -->
	<!-- 눈에 안보이는데 구동에 필요한 내용들 -->
	<!-- * 인코딩/Style(CSS)/ JavaScript -->
	
	<meta charset = "UTF-8"> <!-- html일때는 적을 필요가있고 jsp파일이면 위에서 썼기때문에 없어도됨(위에서 2번의 역할) -->
	<!-- 위에꺼 있어서 사실 상관은없지만.. -->
	<!-- 일단 파일저장 인코딩은 전혀 상관없음 -->	
</head>
<body> <!-- 눈에보이는 부분 UI태그 -->
	<!-- UI태그(엘리먼트) -->
	HTML기본 구조와 URL 인코딩(주속으로 설명됨)
	<br><a href="index.jsp">index로</a>
	<hr/>
	
<!-- CSS 내용을  꾸미기(시각화)  -->
<!-- HTML과 CSS가 결합이 되야 뭔가 사용자에게 그럴싸한 UI가 만들어짐-->	
</body>
</html>
	
