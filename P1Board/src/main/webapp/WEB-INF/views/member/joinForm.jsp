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
				    <h4 class="modal-title">Register</h4>
				</div>
				
				
				
				<!-- === 회원가입 FORM / 시작 === -->   							
				<div class="main-login main-center">
                        <form role="form" class="form-horizontal" method="post" action="">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="mid" id="mid" value="${member.mid}" placeholder="Enter your ID"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="memail" id="memail" value="${member.memail}" placeholder="Enter your Email"/>
								</div>
							</div>
						</div>
												
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="mpassword" id="mpassword"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
					</form>
				</div>
				<!-- === 회원가입 FORM / 종료 === -->



			</div> <!-- ./modal-content -->
		</div> <!-- ./modal-dialog -->
		
		
		
		
	</div> <!-- ./container -->
	



	
</body><!-- BODY 종료 -->
</html>