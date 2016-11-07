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

</script>
</head>
<body>
	<div class="jumbotron">
		<h1>Spring Final Programming</h1>
		<p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQuery,
			Ajax, JSP, Spring</p>
		<p>
			<a class="btn btn-lg btn-success" href="<%=pageContext.getServletContext().getContextPath()%>/member/login" role="button">Get
				started today</a>
		</p>
	</div>
	<%--
 	SpringBoardProgramming<br/>
	<hr/>         
	<!-- 동적으로 context알아내는 방법1 표현식 방법 사용 -->
	1.
	<c:if test="${login == null}" >
	<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a></br>
	</c:if>
	<c:if test="${login != null}">
	<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a></br>
	</c:if>
		 
	<!-- 동적으로 context알아내는 방법2 표현 언어 사용 -->
	2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유게시판</a></br>
	3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a></br>
 	--%>	
</body>
</html>