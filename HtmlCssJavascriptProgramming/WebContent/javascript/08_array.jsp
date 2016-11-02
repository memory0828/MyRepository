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
	배열(=자바스크립는 리스트와 같은 특징을 가짐)
	<br>JavaScript Arrays
	<br>http://www.w3schools.com/js/js_arrays.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. 배열과 리스트의 차이점</b>
	배열은 한번 정해지면 크기를 바꿀수없다
	배열은 같은 데이터만 넣을 수 있다
	
	리스트는 크기를 바꿀수 있다
	리스트는 다른 종류의 데이터를 넣을 수 있다(근데 보통 컬렉션을 쓰면 한 종류의 데이터를 쓰지~)
	리스트는 객체만 넣을 수 있다

<b>2. 자바스크립트에서는 배열밖에 없는데 이 배열이 곧 리스트의 특징을 가진다.</b>
	길이가 정해지지 않음
	종류가 다른 값이나 객체를 넣어도됨
<script>	
	var cars = ["Saab", "Volvo", "BMW"];  /* 자바스크립트에서는 []로 배열을 선언하고 {}는 객체선언을 뜻한다 */
	var cars2 = new Array("Saab", "3Volvo", "1BMW"); /* 이렇게선언가능 */
	var person = ["John", "Doe", 46]; /* 타입이 달라도 상관없음 */
	console.log(cars[0]);
	console.log(cars[1]);
	console.log(cars[2]);
	for(var i=0; i<cars.length; i++){
		console.log(cars[i]);
	}

	/* var x = cars.length;   // The length property returns the number of elements */
	/* var y = cars.sort();   // The sort() method sorts arrays */
	console.log(cars2);
	cars2.sort();
	console.log(cars2);
	
	var fruits = ["Banana", "Orange", "Apple", "Mango"];
	fruits.push("Lemon");    /* 원래는 위에서 4개인데 push를 통해 하나 더 넣겠다 */
	fruits[5] = "포도";    /* 5라는 인덱스가 없는데도 이렇게하면 하나 생겨서 같이 들어감 */
	console.log(fruits);
	
</script>
	



</pre>
</body>
</html>
