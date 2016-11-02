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
		var v1 = "A"; /* 전역변수 */
		
		function fun1(){
			var v2 = "B"; /* 지역변수 */
			v3 = "C"; /* 자동전역변수처리 */
			console.log("전역변수 v1: " + v1);
			console.log("자동 전역변수 v3: " + v3);
			console.log("지역변수 v2:" + v2);	
		}
		
		function fun2(){
			console.log("전역변수 v1: " + v1);
			console.log("자동 전역변수 v3: " + v3);
			/* console.log("지역변수 v2: " + v2); */ /* 선언되지 않아 사용안됨 */			
		}
		
		function fun3(){
			if(true){
				var v4 = "D"; /* 함수단위로 선연된 지역변수 */
			}
			console.log("변수사용범위 v4 " + v4); /* 블록단위의 변수가 존재하지 않아 함수단위임으로 사용가능 */
		}
	</script>
	
</head>
<body>
	지역 변수와 전역 변수
	<br>JavaScript Scope
	<br>http://www.w3schools.com/js/js_scope.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>



<b>1. 지역변수 Local JavaScript Variables</b>
	function myFunction() {
	    var carName = "Volvo"; // 함수 안에서만쓰는 변수
	}


<b>2. 전역변수 Global JavaScript Variables</b>
	var carName = " Volvo"; // 함수와 상관없이 전체에서 사용할수있는 변수
	
	function myFunction() {
	    // code here can use	carName 
	}

<b>3. 자동 전역변수 Automatically Global</b>
	myFunction();
	
	// code here can use carName 
	
	function myFunction() {
	    carName = "Volvo"; //var가 있고 없고의 차이점
	}
	var없는 변수는 이전에 선언이 안되어있다면 이것을 전역변수로 취급한다
	그래서 이 함수가 아닌 다른 함수에서도 사용가능

<script>
	fun1();
	fun2();		
</script>
	
<b>4. 변수의 사용범위 The Lifetime of JavaScript Variables</b>
	자바는 블록단위의 지역변수가 존재하지만
	자바스크립느는 블록단위의 지역변수는 없고 함수단위의 지역변수만 존재한다

<script>
	fun3();		
</script>


</pre>
</body>
</html>
