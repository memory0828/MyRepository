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
	String를 숫자로 변환
	<br>JavaScript Number Methods
	<br>http://www.w3schools.com/js/js_number_methods.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. Number Methods and Properties</b>
	이건 Number 객체가 가지고 있는 것들인데 중요하지 않으니 넘어감

<b>2. Global Methods</b>
	이건 Number 객체가 가지고 있지않는 Global Methods
<script>
	var v1 = "10";
	/* 숫자변환은 이 두가지 방식을 사용가능 편한거 사용! */
	var v2 = Number(v1); /* 메소드라표현했지만 함수라생각해도 무관 */
	var v3 = parseInt(v1); /* 메소드라표현했지만 함수라생각해도 무관 */
	/*
 	근데 왜 굳이 메소드라고 표현했을까?
			자바스크립트는 모든 함수에서 공통적으로 사용할 수 있는 전역 함수를 
			Globle이라는 객체안에 
				Number() {... } 
				parseInt()  {... }
				parseFloat()  {... }
			이런식으로 되어있는데
			이걸 사용할려면 객체 참조식 예) Globle.parseInt(); 으로 사용해야 맞는데
			자바스크립에서는 그냥 예) parseInt();로 사용가능하도록 만들어 놓았다
			그래서 아래같은 방식으로 사용가능하도록해놓았음
			functon fun1() {
				... parseInt();
			}
			그래서 일단 html에서 사용한 어떤 메소드가 선언이 안되어있다면 Globle 객체 안에서 찾아서 사용하도록 되어있음
	
			이 Globle 관련된 자세한 내용은 
			JavaScript Global Reference
			http://www.w3schools.com/jsref/jsref_obj_global.asp
			에서 확인하고
			
			부를 때는 함수라고 사용해도 되지만 정확히는 메소드가 맞다
	*/			
	console.log( typeof(v2));
	console.log( typeof(v3));
	console.log(v2+v3);
	
	var v4 = 3.14;
	console.log( parseInt(v4) );
	console.log( parseFloat(v4) );
	
	
</script>
	

</pre>
</body>
</html>
