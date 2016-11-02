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
	객체
	<br>JavaScript Objects
	<br>http://www.w3schools.com/js/js_objects.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. JavaScript Objects</b>
<script>	
	var car = {
		model: "승용차",	/* 값들이 저장되는것들은 필드 */
		company: "현대", /* 값들이 저장되는것들은 필드 */
		cc: 30000, /* 값들이 저장되는것들은 필드 */
		speed: 0, /* 값들이 저장되는것들은 필드 */

		/* 함수이름(=메소드이름) */
		/* ↓ */
		start: function() { /* 이건 실행부를 가지는 메소드*/
			console.log("시동을 겁니다.");
		}, 
		stop: function() {
			console.log("멈춥니다.");
		},
		setSpeed: function(speed) {
			this.speed = speed;  /* this.speed는 위에 speed: 0를 뜻함 */ 
		},
		getSpeed: function() {
			return this.speed;  /* this.speed는 위에 speed: 0를 뜻함 */ 
		},
	};
	
	//필드(속성) 값 읽기
	console.log("car.model: " + car.model);
	console.log("car.company: " + car.company);
	console.log("car.cc: " + car.cc);
	console.log("car.speed: " + car.speed);
	
	//필드(속성) 값 변경
	car.model = "자율주행";
	car.speed = 60;	
	console.log(car); /* 오브젝트 출력 */
	
	//메소드 호출
	car.start();
	car.setSpeed(100);
	console.log("현재 속도: " + car.getSpeed());
	car.stop();
	
</script>
	



</pre>
</body>
</html>