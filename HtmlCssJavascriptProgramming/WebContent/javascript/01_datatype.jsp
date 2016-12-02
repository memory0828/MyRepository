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
		var v1 = 10;
		var v2 = '자바스크립트'; /* 문자 선언( ' '와 " " 모두 씀 ' '을 더 많이 씀') */
		var v3 = true;
		var v4 = {name:"홍길동", age:27}; /* 자바스크립트에서 {}는 객체를 선언한다는 의미 : 객체 name은 필드 "홍길동"은 필드값 */
		var v5 = function() { }; /* 함수대입 */
		var v6 = null;  /*객체를 만들어 대입 null값 넣어짐 */
		var v7 = new Date(); /*객체를 만들어 대입 Date타입을 넣음 */
		var v8 = [1, 2, 3]; /* 배열 */
		
		/* x라는 값의 타입은 선언할 때 결정되는게 아니라, 값이 대입될 때 자동으로 타입이 정해진다 */
		/* 변수를 선언하고 값을 대입함 / 이렇게 대입될 때 타입이 결정된다 */
		
		/* var로 선언한 변수들의 타입 확인 */
		console.log("v1: " + typeof(v1));
		console.log("v2: " + typeof(v2));
		console.log("v3: " + typeof(v3));
		console.log("v4: " + typeof(v4));
		console.log("v5: " + typeof(v5)); /* 함수를 변수에 대입? 자바스크립트에서는 가능. 함수라는 데이터 타입이 별도로 있음 */
												/* 함수도 객체인데, 구분을위해 타입이 object가 아닌 function으로 나오고 참조타입이다 */
		console.log("v6: " + typeof(v6)); /* 참조타입 객체의 번지를 넣음 = 참조타입은 자바스크립에서 다 object로 표현됨 */
		console.log("v7: " + typeof(v7)); /* 참조타입 객체의 번지를 넣음 = 참조타입은 자바스크립에서 다 object로 표현됨 */
		console.log("v8: " + typeof(v8)); /* 참조타입 객체의 번지를 넣음 = 참조타입은 자바스크립에서 다 object로 표현됨 */
		
		/* 그래서 이미 선언해서 타입이 결정되 변수라도 이렇게 다시 넣으면 그 타입으로 알아서 바뀐다 */
		v1 = 123;
		console.log("타입변경 v1: " + typeof(v1));
		v1 = 'dd';
		console.log("타입변경 v1: " + typeof(v1));

	</script>
	
</head>
<body>
	데이타 타입
	<br>JavaScript Variables 
	<br>http://www.w3schools.com/js/js_variables.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />

	<br>JavaScript Operators
	<br>JavaScript Arithmetic
	<br>JavaScript Assignment
	<br>JavaScript Data Types
	<br>모두 넘어감 자바랑 똑같음
</body>
</html>
