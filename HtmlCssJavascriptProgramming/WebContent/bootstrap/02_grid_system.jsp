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
    	<style type="text/css">
    		div {
    			 border: 1px solid gray; 
    		}
    	</style>    
</head>
<body>
	Grid System ( Layout 작성 )
	<br>http://getbootstrap.com/css/#grid-options
	<br><a href="index.jsp">index로</a>
	<hr/>

	<br><br>Example: Stacked-to-horizontal - 1<br>
	<!--  레이아웃을 잡는것1  -->
	<div class="row">
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	</div>

	<br><br>Example: Stacked-to-horizontal - 2<br>
	<!-- 레이아웃을 잡는것2 -->
	<div class="row">
	  <div class="col-sm-8"> <!-- 8칸이 들어가고 -->
	  	.col-sm-8
	  </div>
	  <div class="col-sm-4"> <!-- 4칸이 들어가고 -->
	  	.col-sm-4
	  </div>
	</div>
	<!-- <div class="row">
	  <div class="col-sm-4">.col-sm-4</div>
	  <div class="col-sm-4">.col-sm-4</div>
	  <div class="col-sm-4">.col-sm-4</div>
	</div>
	<div class="row">
	  <div class="col-sm-6">.col-sm-6</div>
	  <div class="col-sm-6">.col-sm-6</div>
	</div>
	 -->
	 
	<br><br>Example: Mobile and desktop<br>
	<div class="row" style="width:600px;">
	  <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8<br>
	  	HOW DID THE ASF AND APACHE® PROJECTS GROW
		Formerly known as the Apache Group, the ASF was incorporated in 1999 as a membership-based, not-for-profit corporation in order to ensure that the Apache projects continue to exist beyond the participation of individual volunteers. Individuals who have demonstrated a commitment to collaborative open-source software development, through sustained participation and contributions within the Foundation's projects, are eligible for membership in the ASF. An individual is awarded membership after nomination and approval by a majority of the existing ASF members. Thus, the ASF is governed by the community it most directly serves -- the people collaborating within its projects.
	  </div> <!-- 모바일에서는 12등분 데스크탑에서는 8등분 -->
	  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4<br>
	  	WHAT IS THE ASF
		Established in 1999, the ASF is a US 501(c)(3) charitable organization, funded by individual donations and corporate sponsors. Our all-volunteer board oversees more than 350 leading Open Source projects, including Apache HTTP Server -- the world's most popular Web server software.
		The ASF provides an established framework for intellectual property and financial contributions that simultaneously limits potential legal exposure for our project committers. Through the ASF's meritocratic process known as "The Apache Way," more than 500 individual Members and 4,500 Committers successfully collaborate to develop freely available enterprise-grade software, benefiting millions of users worldwide: thousands of software solutions are distributed under the Apache License; and the community actively participates in ASF mailing lists, mentoring initiatives, and ApacheCon, the Foundation's official user conference, trainings, and expo.
	  </div> <!-- 모바일에서는 6등분 데스크탑에서는 4등분 --> 
	</div>

	
</body>
</html>
