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
	<script type="text/javascript"> /* 스크립트 방식(한줄한줄 실행하는)으로 이 안에 있는 코드를 실행하겠다 / 그리고 그걸 사용할 때 쓰는 언어는 javascript이다) */
		function sum(from, to){
			var sum=0;
			for(var i=from; i<=to; i++){
				sum += i;	
			}
			return sum;
		}
	</script>
	
</head>
<body>
	자바스크립트 함수
	<br>JavaScript Functions
	<br>http://www.w3schools.com/js/js_functions.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. 함수와 매소드의 차이</b>
	* 함수는 객체없이 실행블록만 있는것
	* 메소드는 객체안에 실행블록이 있는것
 
	함수는 일런식으로 사용
		함수(){ ... }
		함수();
	
	메소드는 오브젝트에 소속된 맴버기 때문에 오브젝트를 참조해서 사용해야한다
		var obj = Obect
		obj.메소드
		이런식
 
<b>2. 자바스크립트 함수의 자바 메소드와 차이점</b>
	예) 함수 선언
	function name(parameter1, parameter2, parameter3) {
	    code to be executed
	}
	1). 리턴 타입이 없어도 리턴값이 있을 수도 있고 없을 수도 있고
	   리턴이 있느냐 없느냐는 함수 코드안에 return이라는 코드가 있고 없고에 따라 결정됨
	2). 매개변수는 데이터 타입을 넣지 않는다, 그냥 변수이름만 바로옴
</pre>
 

<pre> 
<B>3. head와 body안에 스크립트가 들어가는 차이</B>
	 자바스크립트 함수는 사용하기전에 반드시 선언을 해야 사용가능하다
 	 <script> /* 뒤에 안써도 기본적으로 자바스크립트라 생각하니 생략가능 */
	 	console.log("1부터 10까지 합: " + sum(1,10));
	 </script>
	 방식1 보통 head 안에는 자바스크립트는 선언 코드가 오고
	 방식2 보통 body 안에는 단순하게 실행만 하는 코드는 그 실행되는 위치( body 사이 )
			 에다가 스크립트를 작성하고 바로 실행할 내용을 작성한다
	 		 또는 위에서 선언한 것들을 사용하는 코드가 들어감
 </pre>
</body>
</html>
