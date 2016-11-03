<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- 첫번째 방법 CDN에서 다운로드 받아쓰는방법 -->
	<!--<script
		  src="https://code.jquery.com/jquery-1.12.4.min.js"
		  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		  crossorigin="anonymous">
 	</script> -->
 	
	<!-- 두번째 방법 어플리케이션에서 사용하는방법(대부분임)-->
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	
	<!-- 기존 자바스크립트 소스(이거 실행안됨 저 밑에다가 놓아야함) -->
	<!-- <script type="text/javascript">
		var btn1 = document.querySelector("#btn1");
		btn1.addEventListener("click", function() { 
			var div1 = document.querySelector("#div1");
			div1.innerHTML = "수정 내용";
		});
	</script> -->
	
	<!-- 위 소스를 jQuery 사용해서 바꾸기 -->
	<script type="text/javascript">
		$(function() {
				$("#btn1").on("click", function() {
					$("#div1").html("수정내용");
				});
		});
	</script>
</head>
<body>
	 jQuery 라이브러리 로드
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<button id="btn1">버튼1</button>
	<div id="div1">최초 내용</div>



</body>
</html>
