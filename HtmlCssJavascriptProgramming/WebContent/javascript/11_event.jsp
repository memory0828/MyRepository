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
		/* 이벤트 처리방법1 */
		function changeImg1(){
			var img1 = document.querySelector("#img1");
			img1.src = "../common/image/photo1.jpg";
		}
		
		/* 이벤트 처리방법2 */
		function changeImg2(){
			var img2 = document.querySelector("#img2");
			img2.src = "../common/image/photo2.jpg";
		}
		/* ======== 하지만 이상태로는 적용이 안됨 : 객체를 찾을 수 없어서.. ======== */
		/* btn2이라는 아이디를 가진 객체를 찾아와서 그것의 클릭이벤트에 changeImg2를 함수를 배치하겠다(실행아님!) */
		/* var btn2 = document.querySelector("#btn2");
		btn.onclick = changeImg2; */ /* ★여기서 ()가 안들어간것을 주목 / ()가 없으면 대입코드, ()가 들어가면 실행코드가 됨 */ 
		/* ====================================================== */
		
		/* window라는 객체의 onload라는 이벤트에다가 함수(익명객체같은 느낌)를 배치함 */
		/* 해석 : window 객체에서 onload라는 이벤트가 발생했을 때 이 function안의 이벤트를 발생시키겠다 */
		
		window.onload = function() {
			/* 이건 html내용을 다 해석하고 그것들을 객체로 만들면서 브라우저가 DOM을 만들었을 때
			   onload이벤트가 발생함 */			
			   /* 즉 onunload 이벤트는 
			   DOM이 다만들어지고 그림파일같은게 다 확보된다음에
			   브라우저에서 랜더링하기직전에 발생함 */

			console.log("window.onload이벤트 발생");
			
			/* ====== 위에서 안돌아간 소스 이곳에 넣어서 적용시킴 */
			var btn2 = document.querySelector("#btn2");
			btn2.onclick = changeImg2;
			/* ===================================== */
			
			/* 이벤트 처리방법3 */
			/* btn3에서 click 이벤트가 발생했을 때 함수를 등록하겠다는 의미 */
			/* 이방식은 그 엘리먼트가 지원하지 않는 이벤트도 지정할수 있다는 점에서 더 범용적이지만, 사용할수있는 이벤트가 별로없음 */
			var btn3 = document.querySelector("#btn3");
			btn3.addEventListener("click", function() {
				var img3 = document.querySelector("#img3");
				img3.src = "../common/image/photo3.jpg";
			});
			/* 함수가 이미 만들어져있으면 이렇게 해도됨
			btn3.addEventListener("click", changeImg3) */ /* 역시 changeImg2에 ()가 없음 있으면 실행결과를 가져오는코드 */
			
		}

	</script>
	
</head>
<body>
	Event 처리 방법
	<br>JavaScript Events
	<br>http://www.w3schools.com/js/js_events.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
	HTML 엘리먼트에서 이벤트가 발생한다
	버튼이나 이미지, 링크, 마우스 움직임
	
	이벤트들은.. 
	1. An HTML web page has finished loading
	   브라우저의 로드이벤트
	2. An HTML input field was changed
	   시용자가 입력후에 일어나는 이벤트
	3. An HTML button was clicked
	   버튼입력후에 일어나는이벤트
	그외 ....
	
	< some-HTML-element some-event='some JavaScript' >
	< some-HTML-element some-event="some JavaScript" >
	                               ↑속성
	속성에서 해당이벤트가 발생했을때 뒤에 " " or ' ' 의 자바스크립트 실행
	
	Example
	< button onclick="document.getElementById('demo').innerHTML=Date()">The time is?< /button>
	                 ------------------------------  ---------
	                    DOM에서 객체찾아옴		   그 객체의 내용
	
	Example
	
	        ↓Event
	        ------
	< button onclick="displayDate()">The time is?</button>
	 -----           ---------------------
	 ↑Event Source      ↑Event Handler(=Event Listener) 이벤트 발생했을때 실행되는 함수
	
	
	Common HTML Events
	사용자의 액션에 의해 발생하는 이벤트
	 - onchange	An HTML element has been changed
	 - onclick	The user clicks an HTML element
	 - onmouseover	The user moves the mouse over an HTML element
	 - onmouseout	The user moves the mouse away from an HTML element
	 - onkeydown	The user pushes a keyboard key
	브라우저의 이벤트
	 - onload	The browser has finished loading the page
</pre>


	<br>
	<br>
	<br>JavaScript HTML DOM Events
	<br>http://www.w3schools.com/js/js_htmldom_events.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />

	<h3>이벤트 처리방법1 ★제일 많이 씀</h3>
	onclick라는 이벤트에다가 값을 지정하는 형식<br/>
	<button onclick="changeImg1()">버튼1</button> <!-- changeImg1() 에서 ()가 들어간걸 주목 -->
	<img id="img1" src=""  width="100px"/>

	<h3>이벤트 처리방법2</h3>
	<button id="btn2">버튼2</button>
	<img id="img2" src=""  width="100px"/>

	<br>
	<br>
	<br>JavaScript HTML DOM EventListener
	<br>http://www.w3schools.com/js/js_htmldom_eventlistener.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<h3>이벤트 처리방법3</h3>
	<pre>
	addEventListener는 이 이벤트가 발생했을 때 이 함수를 실행하겠다를 등록하는 메소드
	element.addEventListener(event, function, useCapture);
		- event : 발생할 이벤트를 지정하고
		- function : 두번째 함수를 지정하고(어떤 이벤트가 발생했을 떄 이 함수를 실행하겠다)
	</pre>
	<button id="btn3">버튼3</button>
	<img id="img3" src=""  width="100px"/>

	<script>

	</script>
	




</body>
</html>
