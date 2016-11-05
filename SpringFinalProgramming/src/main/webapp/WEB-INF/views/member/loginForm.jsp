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

	<c:if test="${login != null}">
	<div class="jumbotron">
		<!-- Form Name -->
		<legend>Logout - ${login}</legend>

		<div class="form-group" >
		  <label class="col-md-4 control-label"></label>
		  <div class="col-md-4">
				<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout" data-toggle="modal"  title="Compose"  class="btn btn-sm btn-primary btn-block">로그아웃</a>
		  </div>
		</div>
		

	</div>
	</c:if>

	<c:if test="${login == null}">
	<div class="jumbotron">
		<form class="form-horizontal" method="post" action=""> <!-- action=""한것은 같은요청경로로 post방식으로 요청함 처리임 -->
		<fieldset>
		<!-- Form Name -->
		<legend>Login</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="Login">Login ID</label>  
		  <div class="col-md-4">
			<input type="text" name="mid" id="mid" value="${findMid}" class="form-control input-md" placeholder="Enter Your ID">
			<c:if test="${error == 'LOGIN_FAIL_MID'}">${findMid}- 아이디가 존재하지 않음</c:if>
		  </div>
		</div>
		
		<!-- Password input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="passwordinput">Password</label>
		  <div class="col-md-4">
			<input type="password" name="mpassword" id="mpassword" class="form-control input-md" placeholder="Enter Your Password">
			<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}">- 패스워드가 틀림</c:if>
		  </div>
		</div>

		<!-- {pageContext.servletContext.contextPath} 절대경로 쓰기  -->
		<div class="form-group" >
		  <label class="col-md-4 control-label"></label>
		  <div class="col-md-4">
					<a href="findMid">아이디 찾기</a> | <a href="findMpassword">비밀번호 찾기</a>
		  </div>
		</div>

		
		<!-- Button (Double) -->
		<div class="form-group" >
		  <label class="col-md-4 control-label"></label>
		  <div class="col-md-4">
				<div class="col-md-6">
					<input type="submit"  class="btn btn-sm btn-success btn-block" value="Login">
				</div>
				<div class="col-md-6">
					<a href="${pageContext.servletContext.contextPath}/member/join" data-toggle="modal"  title="Compose"  class="btn btn-sm btn-primary btn-block">Register</a>
				</div>
		  </div>
		</div>
		</fieldset>		

		</form>

	</div>
	</c:if>
</body>
</html>