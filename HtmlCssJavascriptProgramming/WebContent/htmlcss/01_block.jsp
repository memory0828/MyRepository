<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %> <!-- 1���ǿ��Ҹ� ��� -->
<!DOCTYPE html>
<html> 
<head> 
	<meta charset = "UTF-8"> 
</head>
<body>
	������Ʈ(�±�)
	<hr/>
	
	<h1>Block</h1>
	<div style="background-color: #ff0000; height:50px; border:1px solid green"></div>
	<div style="background-color: #0000ff; height:50px; border:1px solid yellow"></div>
	<h1 style="background-color: #0000ff; height:50px; border:1px solid yellow">����</h1>
	<p style="background-color: #0000ff; height:50px; border:1px solid yellow">����</p>
	<form style="background-color: #0000ff; height:50px; border:1px solid yellow"></form>
	
	<h1>In-Line</h1>
	<span style="color:red; border:1px solid yellow">Inportant</span>
	<span style="color:green">Inportant</span>
	<span style="color:blue">Inportant</span>
	<img src="../common/image/naver.gif" style="border:1px solid yellow"/><!-- ����� -->
	
	<h1>Block -> Inline</h1>
	<div style="height:50px; width:200px; border:1px solid green; display:inline-block;"></div>
	<div style="height:50px; width:200px; border:1px solid red; display:inline-block;"></div>

	<h1>Example</h1>	
	<div style="height:50px; width:200px; border:1px solid green; display:inline-block;">
		<div style="background-color: #ff0000; height: 30px;"></div>
	</div>
	
</body>
</html>