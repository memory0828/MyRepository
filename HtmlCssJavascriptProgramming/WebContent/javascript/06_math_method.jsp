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

	
	
	</script>
	
</head>
<body>
	수학 관련 메소드
	<br>JavaScript Math Object
	<br>http://www.w3schools.com/js/js_math.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<script>
	console.log( Math.min(0, 150, 30, 20, -8, -200) );  // returns -200
	console.log( Math.max(0, 150, 30, 20, -8, -200) );  // returns 150
	
	console.log( Math.round(4.7) );    // returns 5
	console.log( Math.round(4.4) );    // returns 4
	
	/* 자바스크립트 타입변환 캐스팅이 없어서 이런식으로 사용함 */
	console.log( Math.floor (Math.random() * 6) + 1 );     // returns a random number

	
</script>
	



</pre>
</body>
</html>
