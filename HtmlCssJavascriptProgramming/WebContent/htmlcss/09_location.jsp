<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		#div1{
			position: absolute; /* 좌표에 영향받음(body기준) */
			left: 100px;
			top: 200px;
			width: 100px;
			height: 100px;
			background-color: red;
		}
		#div2{
			/* 기본값 position: static; 좌표에 영향 안받음 */
			width: 100px;
			height: 100px;
			background-color: green;
		}
		#div3{
			position: fixed; /* 스크롤 따라서 */
			left: 300px;
			top: 200px;
			width: 100px;
			height: 100px;
			background-color: red;
		}
		#div4{
			position: relative;
			left: 500px;
			top: 100px;
			width: 300px;
			height: 300px;
			border: 1px solid black;
		}
		#div5{
			position: absolute;
			left: 100px;
			top: 100px;
			width: 50px;
			height: 50px;
			background-color: green;
		}
	</style>
</head>
<body>
	location 관련 CSS 속성
	<br>
	<a href="index.jsp">index로</a>
	<hr />

		<!-- CSS position Property
		
		static 는 포지션을 아무것도 안준경우 위에서부터 쌓인다.
		absolute 는 부모가 없으면 좌표0값이 브라우저 좌상단, 부모를 relative로 하고  absolute를 하면 부모의 좌상단이 0,0 임
		fixed 는 좌표0값이 브라우저 좌상단 스크롤 과 상관없이 고정 부모와 상관없음
		relative 는 부모의 좌상단 상대적으로 배치  -->

	<div id="div1">absolute</div>
	<div id="div2">static</div>
	<div id="div3">fixed</div>
	<div id="div4">
		<div id="div5">relative</div>
	</div>
	<%for(int i=0; i<30; i++) {  %>
	<br/>
	<% } %>	



</body>
</html>
