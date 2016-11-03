<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		/* 이거에의해서 찾아진 btn1에 click이벤트에 함수 배치 */
		/* $("#btn1").on("click", function() {} ); */
		/* 근데 이렇게하면 이거 적용안됨 왜냐? 아직 DOM이 해석되기 전이기떄문에 */

		/* ready이벤트가 발생됐을떄(=DOM이 완성됬을때) 실행됨 */
		/* 앞에서 했던 onload이벤트랑 비슷한 효과지만 ready 타이밍에서 실행됨 */
		$(function() {
			$("#btn1").on("click", function() {
				$("#img1").attr("src", "../common/image/photo12.jpg");
			} );
			
			$(".img2").on("mouseover", function() {
				$(".img2").attr("src", "../common/image/photo1.jpg");
			} );
			$(".img2").on("mouseout", function() {
				$(".img2").attr("src", "../common/image/photo2.jpg");
			} );
			
			$("#btn3").on("click", function() {
				/* 아이디가 div1인 거 뒤에 계속 추가해라 */
				$("#div1").append('<img class="img2" src="../common/image/photo1.jpg" width="100" height="100"/>&nbsp;');
			} );
		});
		
		
	</script>
</head>
<body>
	이벤트 처리
	<br>
	<a href="index.jsp">index로</a>
	<hr />
	<button id="btn1">버튼1</button>
	<div>
		<img id="img1" src="../common/image/photo10.jpg" width="100"/>
	</div>
	
	<button id="btn2">버튼2</button>
	<div>
		<img class="img2" src="../common/image/photo1.jpg" width="100" height="100"/>
		<img class="img2" src="../common/image/photo1.jpg" width="100" height="100"/>
	</div>
	
	<button id="btn3">버튼3</button>
	<div id="div1">		
		<img src="../common/image/photo6.jpg" width="100" height="100"/>
	</div>
</body>
</html>
