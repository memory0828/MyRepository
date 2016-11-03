<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 외부 자바스크립트 파일 로딩 -->
	<script type="text/javascript" src="14_library.js"></script>
	<!-- 나만의 어플리케이션을 만드는 라이브러리를 만들때는 이런식은상관없지만 다른사람들에게 배포하는 라이브러리는
	이 아래 sum이 중복될수도있기 때문에 그래서 유일한 표현이 있어야하고 
	제이쿼리에서는 이 유일한 표현이 $이다. 이 내용은 14_library.js을 참고  -->
	<!-- <script type="text/javascript">
	/*	이걸 라이브러리에 옮김 */
		function sum(from, to) {
			for(var i = from; i<=to; i++){
				var sum = 0;
				for(var i=from; i<=to; i++){
					sum += i;
				}
				return sum;
			}
		}
	</script> -->
	
	<script type="text/javascript">
		function calculator(){
			var x = parseInt(document.querySelector("#x").value);
			var y = parseInt(document.querySelector("#y").value);
			var result = $.sum(x, y);
			document.querySelector("#result").value = result;
		}
	</script>
	
</head>
<body>
	외부 자바스크립트 파일 로딩
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<input type="text" id="x"/> 에서
	<input type="text" id="y"/> 까지의 합
	<button onclick="calculator()">계산</button>
	<input type="text" id="result" readonly/> 
	
	<script>
	
	</script>
	
</body>
</html>
