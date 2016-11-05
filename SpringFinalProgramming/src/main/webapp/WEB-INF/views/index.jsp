<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS -->
<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/justified-nav.css" rel="stylesheet">
<!-- jquery추가하기 -->
<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
<!-- 부트스트랩 jquery추가하기 -->
<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("nav li").on("click", function() {
			console.log(event.target);
			/* console.log(event.target.parent); */
			console.log(this); /* 이 this는 jQuery객체가 아니다. 그래서 이걸 jQuery객체로 만들필요가있다 왜? jQuery객체가 제공하는 다양한 기능을 쓰기위해 */

			/* HTML DOM setAttribute() Method 클래스 속성을 추가하는 방법
			document.getElementsByTagName("H1")[0].setAttribute("class", "democlass"); 
			http://www.w3schools.com/jsref/met_element_setattribute.asp */
			/* this.setAttribute("class", "active"); 이런식으로 사용(이건 jQuery을 안쓰고, DOM을 이용한것) */

			/* ●구현방법1 : jQuery + DOM 사용 */
			/*$("nav li").removeClass(); *//* 이건 jQuery을 통해 사용 : http://api.jquery.com/category/css/ 에서 .removeClass() 을 사용  */
			/*this.setAttribute("class", "active");	*//* 이건 DOM을 통해 사용 */

			/*	근데 이렇게 짬뽕해놓으니깐 통일 성이 없다. 그냥 jQuery많으로 처리하고싶어!
				그럴려면 DOM객체를 감싸는 jQuery 객체를 얻어야한다 왜인지알지?
					-> $(DOM객체) 이렇게 하면됨!( $("DOM객체") 이렇게 쓰는거 아니다 ) 
				이 객체를 감쌓는 jQuery가 그냥 만들어짐 이렇게 해놓으면 jQuery메소드를 쓸수있음 */

			/* ●구현방법2 :  jQuery만 사용 */
			$("nav li").removeClass();
			$(this).addClass("active"); /* $(this).~...~ 이게 바로 DOM객체를 jQuery로 감싸는거 */

			/* 메뉴를 눌렀을 때 처리하는 방식에는 3가지가 있음
			1 화면전체변경
			2 iFrame 이용
			3 Ajax 이용 */

		});
	})
</script>
<script type="text/javascript">



</script>

</head>

<body style="background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg)" >
	<div class="container">
		<div class="masthead"  >
			<h3 class="text-muted" style="margin-top: 0px;">SuzuBoard</h3>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a target="iframe" href="<%=pageContext.getServletContext().getContextPath()%>/home">Home</a></li>
					<li><a target="iframe" href="<%=pageContext.getServletContext().getContextPath()%>/member/login">Member</a></li>
					<li><a target="iframe" href="${pageContext.servletContext.contextPath}/freeboard/list">Free Board</a></li>
					<li><a target="iframe" href="${pageContext.servletContext.contextPath}/photoboard/list">Photo Board</a></li>
				</ul>
			</nav>
		</div>

		<%--
		<div class="jumbotron">
			<h1>Spring Final Programming</h1>
			<p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQuery,
				Ajax, JSP, Spring</p>
			<p>
				<a class="btn btn-lg btn-success" href="#" role="button">Get
					started today</a>
			</p>
		</div>
		--%>
		<script> 
		  function resizeIframe(obj) {
			  
			  console.log(obj.contentWindow.document.body.scrollHeight);
		    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
		  }
		</script>
		<iframe name="iframe" style="width:100%; border-width: 0px; " src="home" scrolling="no" onLoad="resizeIframe(this);"></iframe>
		


		<!-- 하단부분 -->
		<div class="row" style="background-color: #292929; color:white; margin-right: 5px; margin-left: 5px">
			<div class="col-lg-4">
				<h2>회원 서비스</h2>
				<p>회원 가입</p>
				<p>로그인</p>
				<p>로그아웃</p>
				<p>
					<a class="btn btn-primary" target="iframe"  href="<%=pageContext.getServletContext().getContextPath()%>/member/login" role="button">자세한 설명
						&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>자유 게시판</h2>
				<p>게시물 목록</p>
				<p>게시물 쓰기</p>
				<p>게시물 보기</p>
				<p>게시물 수정</p>
				<p>게시물 삭제</p>
				<p>
					<a class="btn btn-primary" target="iframe"  href="${pageContext.servletContext.contextPath}/freeboard/list" role="button">자세한 설명
						&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>포토 게시판</h2>
				<p>게시물 목록</p>
				<p>게시물 쓰기</p>
				<p>게시물 보기</p>
				<p>게시물 수정</p>
				<p>게시물 삭제</p>
				<p>
					<a class="btn btn-primary" target="iframe"  href="${pageContext.servletContext.contextPath}/photoboard/list" role="button">자세한 설명
						&raquo;</a>
				</p>
			</div>
		</div>

		<footer class="footer" style="margin:0px; padding: 10px;">
			<p>&copy; 2016 Company, Inc.</p>
		</footer>
	</div>

</body>
</html>
