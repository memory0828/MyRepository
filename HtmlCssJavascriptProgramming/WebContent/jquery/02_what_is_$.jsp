<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- <script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script> -->
	<!-- 자바스크립트는 함수도 객체고 함수도 또다른 필드와 객체를 가질수 있다 -->
	<script type="text/javascript">
		//함수(객체) 대입
		var $ = function(selector) {
			console.log("aaa");	
			return document.querySelectorAll(selector);
		};
		
		//동적 메소드 추가(자바스크립트에서 가능한것 함수 객체에서 ajax라는 새로운 매소드를 추가하겠다 )
		$.ajax = function() {
				console.log("bbb");		
		};
		
		function test() {
			$("#div1")[0].innerHTML = "수정 내용";
			$.ajax();
		}
	</script>
</head>
<body>
	jQuery $의 의미( $는 jQuery함수형 객체 )
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<button onclick="test()">버튼</button>
	<div id="div1">최초 내용</div>


</body>
</html>
