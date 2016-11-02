<%@ page contentType = "text/html;charset=UTF-8" %>
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
    	<style type="text/css">
    		#header, #footer{
	            padding: 1em;
	            color: white;
	            background-color: black;
	            text-align: center;
    		}
	       #content #menu {
	          background-color: orange;
	          padding: 1em;
	       }
	       #content #menu ul {
	          list-style-type: none;
	          padding: 0;
	       }
	       #content #center{
	          flex: 1;
	          padding: 1em;
	       }
			/* #container {
            height: 96.5vh; 이건 사용안함 부트스트랩 자체적인 grid 시스템이 있기때문에~
	       } */
    	</style>    
</head>
<body>
<!-- 	Layout 작성
	<br>http://getbootstrap.com/css/#grid-options
	<br><a href="index.jsp">index로</a>
	<hr/>

	<br><br>float와 flex에서 했던 레이아웃잡기<br> -->
	<!-- <div class="container-fluid"> --> <!-- 전체 브라우저 폭을 찾이 -->
	<!-- <div class="container"> --> <!-- 중앙에 위치 기본값 디바이스 크기기준에 따라 크기가 달라짐 -->
	<div class="container">
		<div id="header" class="row">
			<div class="col-md-12">
	            <h1>City Gallery</h1>
			</div>
		</div>
		<div id="content" class="row">
			<div id="menu" class="col-xs-12 col-md-3">
	            <ul>
	               <li><a href="#">London</a></li>
	               <li><a href="#">Paris</a></li>
	               <li><a href="#">Tokyo</a></li>
	               <li><a href="#">London</a></li>
	               <li><a href="#">Paris</a></li>
	               <li><a href="#">Tokyo</a></li>
	               <li><a href="#">London</a></li>
	               <li><a href="#">Paris</a></li>
	               <li><a href="#">Tokyo</a></li>
	               <li><a href="#">London</a></li>
	               <li><a href="#">Paris</a></li>
	               <li><a href="#">Tokyo</a></li>
	               <li><a href="#">London</a></li>
	               <li><a href="#">Paris</a></li>
	               <li><a href="#">Tokyo</a></li>
	            </ul>
			</div>
			<div  id="center" class="col-xs-12 col-md-9">
	               <h1>London</h1>
	               <p>London is the capital city of England. It is the most populous
	               city in the United Kingdom, with a metropolitan area of over 13
	               million inhabitants.</p>
	               <p>Standing on the River Thames, London has been a major
	               settlement for two millennia, its history going back to its founding
	               by the Romans, who named it Londinium.</p>
			</div>
		</div>	
		<div id="footer" class="row">
			<div class="col-md-12">
				Copyright © W3Schools.com
			</div>
		</div>
	</div>
</body>
</html>
