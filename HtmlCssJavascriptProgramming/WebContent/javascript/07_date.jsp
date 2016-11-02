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
	날짜 얻기
	<br>JavaScript Date Formats
	<br>http://www.w3schools.com/js/js_dates.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. Creating Date Objects</b>
	Date는 아래처럼 객체를 직접 만들어야함
	new Date() 현재날짜 이걸제일많이씀 
	new Date(milliseconds) 넘긴~ 초를 가지고 날짜환산
	new Date(dateString) 넘긴~ 문자열을 가지고 날짜환산
	new Date(year, month, day, hours, minutes, seconds, milliseconds) 년월일 시간분초 밀리세컨드까지 주고 날짜로 환산

<script>	
	var now = new Date();
	console.log("현재시간 : " + now);
	/* 년월일을 따로 따로 뽑아내서 사용함 */
	console.log( "년 : " + now.getFullYear() );
	console.log( "월 : " + (now.getMonth() + 1) );
	console.log( "일 : " + now.getDate() );
	console.log( "요일 : " + now.getDay() );
	
</script>
	



</pre>
</body>
</html>
