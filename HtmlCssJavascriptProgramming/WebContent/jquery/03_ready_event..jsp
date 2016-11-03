<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			console.log("제일 마지막에 나오는 0번");	
		};
		
		/* 1.도큐먼트 객체에서 ready이벤트가 발생하면 함수 실행 */
		$(document).on("ready", function() {
			console.log("1");
		});
		/* 2.도큐먼트라는 객체에서 ready라는 이벤트에 함수를 배치해주면 ready이벤트가 발생했을 때 이 함수 실행 */
		$(document).ready(function() {
			/* 도서에서 많이쓰는방식 */
			console.log("2");
		});
		/* 3.현재 이 html페이지에서 도큐먼트라는 객체에서 ready이벤트가 발생했을때 이 아래 함수가 실행 */
		    /* 많이 쓰는 방식 */ 
			/* 위 방식들을 가장 축약함 */
		$(function() {
			console.log("3");
		} );
		
	
	
	</script>
	
</head>
<body>
	ready 이벤트 처리 - 필기 참고해야함
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<b>★</b>
	<img src="../common/image/photo1.jpg"/>
<script>	

</script>
	

</body>
</html>
