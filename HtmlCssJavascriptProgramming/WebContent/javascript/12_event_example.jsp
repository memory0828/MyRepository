<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		* {
			margin:0px;
			padding:0px;
		}
	</style>
	<script type="text/javascript">
		/* 예제1 이벤트 처리 방식1로 */
		function checkMid() {
			var mid1 = document.querySelector("#mid1");
			mid1.value = mid1.value.toLowerCase();
		}
		
		/* 예제1 이벤트 처리 방식3로 */
		function checkMid2() {
			var mid2 = document.querySelector("#mid2");
			mid2.value = mid2.value.toLowerCase();
		}	
		window.onload = function() {
			document.querySelector("#mid2").addEventListener("keypress", checkMid2);
			document.querySelector("#mid2").addEventListener("change", checkMid2);
		}
		
		/* 예제2 이벤트 처리 방식1로 */
		function changImg(img) {   /* changImg(event) { 이렇게 event변수를 받아도되는데안받고도 이벤트 발생정보를 알아낼수있음 넣으면 event객체를 알아서 넘겨줌 / 즉 매게변수로 event를 지정해도 되고 안해도된다 */
			console.log(img);
			console.log(event.type); /* 현재 어떤 이벤트가 발생했는지 알아내는 방법 */
			/* var img = event.target; */ /* 이렇게 이벤트로 넘어온 타겟을 가져올수있음 */
			if(event.type == "mouseover"){
				img.src = "../common/image/photo13.jpg";
			}else if(event.type == "mouseout"){
				img.src = "../common/image/photo12.jpg";
			}
		}
		function changImg2(event) {
			console.log(event.type); /* 현재 어떤 이벤트가 발생했는지 알아내는 방법 */
			var img = event.target; /* 이렇게 이벤트로 넘어온 타겟을 가져올수있음 */
			if(event.type == "mouseover"){
				img.src = "../common/image/photo13.jpg";
			}else if(event.type == "mouseout"){
				img.src = "../common/image/photo12.jpg";
			}
		}
		/* 예제2 이벤트 처리 방식2로 */
		window.addEventListener("load", function() {
			var img2 = document.querySelector("#img2");
			/* 이런형태로 처리하면 changImg로 너어가는 매개값은 무조건 event객체가 들어감 */
			img2.addEventListener("mouseover", changImg2);
			img2.addEventListener("mouseout", changImg2);
		});

		function changColor(div) {
			if(event.type == "mouseover"){
				div.style.backgroundColor = "blue";
			}else if(event.type == "mouseout"){
				div.style.backgroundColor = "red";
			}
		}
	</script>
	
</head>
<body>
	다양한 Event 처리
	<br>예제1
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<form action="">
		방법1 function checkMid()로<br/>
		<input type="text" id="mid1" name="mid1" onkeypress="checkMid()"  onchange="checkMid()"/>
		<br/>
		방법3 addEventListener로<br/>
		<input type="text" id="mid2" name="mid2" />
		<br/>
	</form>
	<br/><br/>
	<br>예제2
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<pre>
	Event Object
		http://www.w3schools.com/jsref/dom_obj_event.asp
		target	Returns the element that triggered the event 이벤트가 발생한 객체를 리턴
		type : Returns the name of the event 발생한 이벤트 이름 리턴
	</pre>
	<img id="img1" src="../common/image/photo12.jpg" width="200px" onMouseOver="changImg(this)" onMouseOut="changImg(this)" >
	<img id="img2" src="../common/image/photo12.jpg" width="200px" >

	<br/><br/>
	<br>예제3
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<div id="div1" style="width: 200px; height: 200px; background-color: red " onMouseOver="changColor(this)" onMouseOut="changColor(this)"></div>



</body>
</html>
