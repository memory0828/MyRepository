<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %>
<!DOCTYPE html>
<html> 
<head> 
	<meta charset ="UTF-8">
	<!-- 1. External Style Sheet : ���� ���� ����ϴ� ��� -->
 	<link rel="stylesheet" type="text/css" href="05_style.css">
 	
 	<!-- 2. Internal Style Sheet : �����ӿ�ũ���� ����ϴ� ��� -->
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
	<hr/>
	
	<header>����</header>
	<p>����</p>
	<a href="http://www.naver.com">����</a>
	
	<div class="menu">
	<ul>
		<li>menu1</li>
		<li>menu2</li>
		<li>menu3</li>
	</ul>
	</div>

 	<!-- 3. In-Line Style Sheet : �׳� ������ ���� �����..�� -->
 	<div style="background-color: yellow; text-align: center;">���� �����Դϴ�</div>
</body>
</html>
