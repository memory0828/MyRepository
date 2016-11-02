<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link href="../resources/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="../resources/common/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="../resources/common/boardtheme/suzuboard_ui.css" rel="stylesheet" type="text/css">
	<link href="../resources/common/boardtheme/suzuboard_login.css" rel="stylesheet" type="text/css">	
	<link href="../resources/common/boardtheme/suzuboard_register.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="../resources/common/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../resources/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>

	<title>SuzuBoard</title>
	
	<style type="text/css">

	</style>

</head>
<body style="background-color: #E5E8EF">
	<div class="container"> 
		  
		<div class="modal-dialog" style="width: 330px;">
			<div class="modal-content">          
				<div class="modal-header">
					<!-- @@ -->	
				    <h4 class="modal-title">Login</h4>
				</div>
				
				
				<!-- === 로그인 FORM / 시작 === -->   
				<!-- @@ -->
				<div class="main-login main-center" >																		    
                       	<form role="form" class="form-horizontal" method="post" action="">
						<fieldset>
							<h2>Please Sign In</h2>
							<hr class="colorgraph" style="width: 276px; margin-left:-14px;">
							<div class="form-group">
			                    <input type="text" name="mid" id="mid" value="${findMid}" class="form-control input-lg" placeholder="Enter Your ID">
			                    <c:if test="${error == 'LOGIN_FAIL_MID'}">${findMid}- 아이디가 존재하지 않음</c:if>
							</div>
							<div class="form-group">
			                    <input type="password" name="mpassword" id="mpassword" class="form-control input-lg" placeholder="Enter Your Password">
			                    <c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}">- 패스워드가 틀림</c:if>
							</div>
							<hr class="colorgraph" style="width: 276px; margin-left:-14px;">
							
<%-- 							<div class="form-group">											
							<center><a href="findMid">아이디 찾기</a>&nbsp;&nbsp;<a href="#">비밀번호 찾기</a></center>
							</div> --%>
							
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
			                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<a href="${pageContext.servletContext.contextPath}/member/join" data-toggle="modal"  title="Compose"  class="btn btn-lg btn-primary btn-block">Register</a>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<!-- === 로그인 FORM / 종료 === -->
				   
					
			</div> <!-- ./modal-content -->
		</div> <!-- ./modal-dialog -->
	</div> <!-- ./container -->
	
	
</body><!-- BODY 종료 -->
</html>