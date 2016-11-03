<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link href="<%=pageContext.getServletContext().getContextPath()%>/resources/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/common/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/common/boardtheme/suzuboard_ui.css" rel="stylesheet" type="text/css">
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/common/boardtheme/suzuboard_login.css" rel="stylesheet" type="text/css">	
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/common/boardtheme/suzuboard_register.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/common/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/common/bootstrap-3.3.7/js/bootstrap.min.js"></script>

	<title>SuzuBoard</title>
	
	<style type="text/css">

	</style>
</head>
<body>
	<div class="container"> 
		<div class="mail-box">
			 <aside class="sm-side">
			     <!-- 로그인 정보 / 시작 -->
				 <c:if test="${login != null}">	
			     <div class="user-head">
			     	<a class="inbox-avatar" href="javascript:;">
					<img  width="64" hieght="60" src="<%=pageContext.getServletContext().getContextPath()%>/resources/photoprofil/★dprofile.jpg"></a>
					</a>
			         <div class="user-name">
			             <h5><a href="#">${login}</a></h5>
			             <span><a href="#">We welcome your visit</a></span>
			         </div>
			     </div>
				</c:if> 
			     <!-- 로그인 정보 / 종료 -->
 			     <div class="inbox-body">
					 <c:if test="${login != null}">		
			         <a href="#myModalWrite" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             글쓰기
			         </a>
			         &nbsp;
			         <a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             로그아웃
			         </a>
			         </c:if>    			         
					 <c:if test="${login == null}">			         
			         <a href="#myModalLogin" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             로그인
			         </a>
			         &nbsp;
			         <a href="#myModalRegister" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             회원가입
			         </a>				         
			         </c:if>         
			         <!-- ModalWrite / 시작 -->
			         <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalWrite" class="modal fade" style="padding-top:110px; display: none;">
			             <div class="modal-dialog">
			                 <div class="modal-content">
			                     <div class="modal-header">
			                         <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			                         <h4 class="modal-title">글쓰기</h4>
			                     </div>
			                     <div class="modal-body">
			                         <form role="form" class="form-horizontal" method="post" action="<%=pageContext.getServletContext().getContextPath()%>/freeboard/write" >
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Subject</label>
			                                 <div class="col-lg-10">
			                                     <input type="text" placeholder=""  name="btitle" id="btitle" class="form-control">
			                                 </div>
			                             </div>
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Content</label>
			                                 <div class="col-lg-10">
			                                     <textarea rows="10" cols="30" class="form-control" id="bcontent" name="bcontent"></textarea>
			                                 </div>
			                             </div>
			
			                             <div class="form-group">
			                                 <div class="col-lg-offset-2 col-lg-10">
			                                     <span class="btn green fileinput-button">
			                                       <i class="fa fa-plus fa fa-white"></i>
			                                       <span>Attachment</span>
			                                       <input type="file" name="files[]" multiple="">
			                                     </span>
			                                     <button class="btn btn-send" type="submit">Write</button>
			                                 </div>
			                             </div>
			                         </form>
			                     </div>
			                 </div><!-- /.modal-content -->
			             </div><!-- /.modal-dialog -->
			         </div><!-- /.modal -->
			         <!-- ModalWrite / 종료 -->
			         <!-- ModalLogin / 시작 -->
			         <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalLogin" class="modal fade" style="display: none;">
			             <div class="modal-dialog" style="width: 330px;">
							<div class="modal-content">
			                 			             
								<!-- === 로그인 FORM / 시작 === -->   
								<div class="modal-header">
								    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
								    <h4 class="modal-title">Login</h4>
								</div>
								<!-- @@ -->
								<div class="main-login main-center" >																		    
		                         	<form role="form" class="form-horizontal" method="post" action="">
										<fieldset>
											<h2>Please Sign In</h2>
											<hr class="colorgraph" style="width: 276px; margin-left:-14px;">
											<div class="form-group">
							                    <input type="text" name="name" id="email" class="form-control input-lg" placeholder="Enter Your Username">
											</div>
											<div class="form-group">
							                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Enter Your Password">
											</div>
											<hr class="colorgraph" style="width: 276px; margin-left:-14px;">
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6">
							                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6">
													<a href="#myModalRegister" data-toggle="modal"  title="Compose"  class="btn btn-lg btn-primary btn-block">Register</a>
												</div>
											</div>
										</fieldset>
									</form>
								</div>
								<!-- === 로그인 FORM / 종료 === -->   
								<!-- @@ -->								
							</div><!-- /.modal-content -->
			             </div><!-- /.modal-dialog -->
			         </div>
			         <!-- ModalLogin / 종료 -->			         
			         <!-- ModalRegister / 시작 -->
			         <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalRegister" class="modal fade" style="display: none;">
			             <div class="modal-dialog" style="width: 330px;">
							<div class="modal-content">
			                 			             
								<!-- === 회원가입 FORM / 시작 === -->   
								<div class="modal-header">
								    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
								    <h4 class="modal-title">Register</h4>
								</div>
								<!-- @@ -->							
								<div class="main-login main-center">
			                         <form role="form" class="form-horizontal" method="post" action="">
										
										<div class="form-group">
											<label for="name" class="cols-sm-2 control-label">Your Name</label>
											<div class="cols-sm-10">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
													<input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
												</div>
											</div>
										</div>
								
										<div class="form-group">
											<label for="email" class="cols-sm-2 control-label">Your Email</label>
											<div class="cols-sm-10">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
													<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
												</div>
											</div>
										</div>
								
										<div class="form-group">
											<label for="username" class="cols-sm-2 control-label">Username</label>
											<div class="cols-sm-10">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
													<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username"/>
												</div>
											</div>
										</div>
								
										<div class="form-group">
											<label for="password" class="cols-sm-2 control-label">Password</label>
											<div class="cols-sm-10">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
													<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
												</div>
											</div>
										</div>
								
										<div class="form-group">
											<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
											<div class="cols-sm-10">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
													<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
												</div>
											</div>
										</div>
								
										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
										</div>
									</form>
								</div>
								<!-- === 회원가입 FORM / 종료 === -->
								<!-- @@ -->								
							</div><!-- /.modal-content -->
			             </div><!-- /.modal-dialog -->
			         </div>
			         <!-- ModalRegister / 종료 -->
			         
				</div>
				
			        <ul class="inbox-nav inbox-divider">
			            <li class="active">
			                <a href="${pageContext.servletContext.contextPath}/freeboard/list?style=text&pageNo=1"><i class="fa fa-bookmark-o"></i> 자유 게시판 </a>
			            </li>
			            <li class="">
			                <a href="${pageContext.servletContext.contextPath}/photoboard/list?style=photo&pageNo=1"><i class="fa fa-bookmark-o"></i> 사진 게시판 </a>
			            </li>
			        </ul>
			    </aside>
			    <aside class="lg-side">
			    	<!-- ---------------------------------------------------------------------- -->
			        <div class="inbox-head">
			            <h3><a href="${pageContext.servletContext.contextPath}/" style="color: white">Suzu Cafe</a></h3>
		            	<form action="#" class="pull-right position">
			                <div class="input-append">
			                    <input type="text" class="sr-input" placeholder="제목 검색">
			                    <button class="btn sr-btn" type="button"><i class="fa fa-search"></i></button>
			                </div>
			            </form>
					</div>					
			        <!-- ---------------------------------------------------------------------- -->
			        <!-- ---------------------------------------------------------------------- -->
					<div class="inbox-body">
			        	<!-- 목록 리스트 출력 부분 -->			        
						<!-- 게시물 출력부분 -->
						<table class="table table-inbox table-hover">
				           	<tbody>
				               <tr class="">
				                   <td class="inbox-small-cells" style="width: 70px"><center>번호</center></td>
				                   <td class="view-message  dont-show" style="width: 150px;">글쓴이</td>
				                   <td class="view-message">제목</td>
				                   <td class="view-message  inbox-small-cells" style="width: 50px">HIT</td>
				                   <td class="view-message  text-right" style="width: 100px"><center>날짜</center></td>
				               </tr>			              
				             	<!-- 게시물 내용 / start -->
								<c:forEach var="freeBoard" items="${indexlist1}">
				               <tr class="">
				                   <td class="inbox-small-cells"><center>${freeBoard.bno}</center></td>
				                   <td class="view-message dont-show">${freeBoard.bwriter}</td>
				                   <td class="view-message view-message"><a href="${pageContext.servletContext.contextPath}/freeboard/info?style=text&?bno=${freeBoard.bno}">${freeBoard.btitle}</a></td>
				                   <td class="view-message inbox-small-cells">${freeBoard.bhitcount}</td>
				                   <td class="view-message text-right">${freeBoard.bdate}</td>
				               </tr>							
								</c:forEach>
				           	</tbody>
						</table>
						<!-- ./게시물 출력부분 -->	
						
						
						
						<!-- 게시물 출력부분 -->
						<table style="width: 840px;">
						<tr>		
						<td valign="top">		
							<!-- 게시물 내용 / start -->
							<c:forEach var="photoBoard" items="${indexlist2}">
							<table class="table table-inbox table-hover" style="width:205px; display:inline-block; border: 0px"  valign="top" >
					           	<tbody  style="border: 0px">
					               <tr class="">
										<td class="" style="width:150px;">
										<a href="${pageContext.servletContext.contextPath}/photoboard/info?style=photo&bno=${photoBoard.bno}">
										<!--  -->
										<table style="width:100%; height:30px; background-color: black; opacity: 0.5; margin-bottom: 10px;"> 
											<tr>
												<td style="text-align: left; color:white">${photoBoard.btitle}</td>
												<td style="text-align: right; color:aqua">${photoBoard.bhitcount}</td>
											</tr>
										</table>
										<div style="width:180px; height:150px ;background-image:url(showPhoto?savedfile=${photoBoard.savedfile}); background-size: 200px 150px; display:inline-block;">
											<div style="height:100px;" >
												<span style="color:black; opacity: 0.5; font-size:12px">&nbsp;&nbsp;${photoBoard.bdate}</span>
											</div>
										</div>
										<!--  -->
										</a>
										</td>	
									</tr>	
					           	</tbody>
							</table>	
							</c:forEach>
							<!-- 게시물 내용 / end-->
						</td>
						</tr>
						</table>
						<!-- ./게시물 출력부분 -->	
						
						
						
						

						<!-- 목록 리스트 출력 부분 / end -->
			        </div> <!-- ./inbox-body -->
					<!-- ---------------------------------------------------------------------- -->
			    </aside>
			</div>
		</div>	

	</div> <!-- ./container -->

</body><!-- BODY 종료 -->
</html>