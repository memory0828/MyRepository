<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %>
<!DOCTYPE html>
<html>
  <head>
	<meta charset = "UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <meta name="viewport" 로 지정되는 속성은 웹킷기반으로 하는 브라우저가 사용할 수 있는 속성 -->
    <!-- 브라우저가 웹킷기반이라면 이런설정을 적용하는데 아래와 같은 기능들을 설정 -->
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> --> 
    <!-- 	● width=device-width : width를 디바이스의 width값
    		● initial-scale=1 : 확대레벨을 1로해서~ 축소하지 말아라 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 	● maximum-scale=1 : 핀치행위를 하더라도 확대를하지말아라
    		● user-scalable=no : 사용자가 핀치행위 이외에 확대할수있도록 제공하지 말아라 -->
    
    <!-- 부트스트랩 css 추가 -->
    <link href="../common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--	● bootstrap.min.css  : 주석과 공백이 포함된 파일이고 - ★사용목적이면 가능한 이걸사용하는게 좋다
    		●  bootstrap.css : 주석과 공백이 포함된파일 ( 디버깅목적이면 이걸 ) -->
 	
 	<!-- jquery추가하기 -->
    <script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
    <!-- 부트스트랩 jquery추가하기 -->
    <script type="text/javascript" src="../common/bootstrap-3.3.7/js/bootstrap.min.js"></script>    
</head>
<body>
	Bootstrap
	<br><a href="../index.jsp">시작 index로</a>
	<hr/>	
	1. <a href="01_css.jsp">부트스트랩 CSS 사용하기</a><br/>
	2. <a href="02_grid_system.jsp">Grid System</a><br/>
	3. <a href="03_layout.jsp">Layout 작성</a><br/>
</body>
</html>
