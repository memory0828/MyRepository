<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html> 
<head> 
	<meta charset = "UTF-8">
	<meta charset ="UTF-8">
	<!-- 1. External Style Sheet : 제일 많이 사용하는 방법 -->
 	<link rel="stylesheet" type="text/css" href="05_style.css">
 	
 	<!-- 2. Internal Style Sheet : 프레임워크에서 사용하는 방법 -->
	<style type="text/css">
		.menu {
			background-color: #ffffff;
		}
		.menu li {
			color: orange;
		}
	</style>
	
</head>
<body>
	CSS Location
	<br><a href="index.jsp">index로</a>
	<hr/>
	
	<header>제목</header>
	<p>내용</p>
	<a href="http://www.naver.com">톰켓</a>
	
	<div class="menu">
	<ul>
		<li>menu1</li>
		<li>menu2</li>
		<li>menu3</li>
	</ul>
	</div>

 	<!-- 3. In-Line Style Sheet : 그냥 빠르게 쓰는 사람들..용 -->
 	<div style="background-color: yellow; text-align: center;">본문 내용입니다</div>
</body>
</html>
