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
			         <a href="<%=pageContext.getServletContext().getContextPath()%>/member/login" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             로그인
			         </a>
			         &nbsp;
			         <a href="<%=pageContext.getServletContext().getContextPath()%>/member/join" data-toggle="modal"  title="Compose"    class="btn btn-compose">
			             회원가입
			         </a>				         
			         </c:if>         
			         <!-- ModalWrite / 시작 -->
			         <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalWrite" class="modal fade" style="padding-top:110px; display: none;">
			             <div class="modal-dialog">
			                 <div class="modal-content">
			                     <div class="modal-header">
			                         <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			                         <h4 class="modal-title">포토 글쓰기</h4>
			                     </div>
			                     <div class="modal-body">
			                         <form role="form" class="form-horizontal" method="post" enctype="multipart/form-data" action="<%=pageContext.getServletContext().getContextPath()%>/photoboard/write" >
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Subject</label>
			                                 <div class="col-lg-10">
			                                     <input type="text" placeholder="" name="btitle" id="btitle" class="form-control" value="${photoboard.btitle}">
			                                 </div>
			                             </div>
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Content</label>
			                                 <div class="col-lg-10">
			                                     <textarea rows="10" cols="30" class="form-control" id="bcontent" name="bcontent">${photoboard.bcontent}</textarea>
			                                 </div>
			                             </div>
			
			                             <div class="form-group">
			                                 <div class="col-lg-offset-2 col-lg-10">
			                                     <span class="btn green fileinput-button">
			                                       <i class="fa fa-plus fa fa-white"></i>
			                                       <span>Attachment</span>
			                                       <input type="file" name="photo">
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
				</div>
				
			        <ul class="inbox-nav inbox-divider">
			            <li class="">
			                <a href="${pageContext.servletContext.contextPath}/freeboard/list?pageNo=1"><i class="fa fa-bookmark-o"></i> 자유 게시판 </a>
			            </li>
			            <li class="active">
			                <a href="${pageContext.servletContext.contextPath}/photoboard/list?pageNo=1"><i class="fa fa-bookmark-o"></i> 사진 게시판 </a>
			            </li>
			        </ul>
			    </aside>
			    <aside class="lg-side">
			    	<!-- ---------------------------------------------------------------------- -->
			        <div class="inbox-head">
			            <h3>SuzuTeam PhotoBoard</h3>
		            	<!--<form action="#" class="pull-right position">
			                <div class="input-append">
			                    <input type="text" class="sr-input" placeholder="제목 검색">
			                    <button class="btn sr-btn" type="button"><i class="fa fa-search"></i></button>
			                </div>
			            </form> -->
					</div>					
			        <!-- ---------------------------------------------------------------------- -->
			        <!-- ---------------------------------------------------------------------- -->
					<div class="inbox-body">
			        	<!-- 게시물 상단 메뉴 -->			        
			           <div class="mail-option">
			               <div class="btn-group">
			                   <div class="btn-group">
									<c:if test="${login != null}">			                   
									<a href="#myModalWrite" data-toggle="modal"  title="Compose"    class="btn btn-compose">			                   
			                           write
									</a>
									</c:if>
			                   </div>
			               </div>
		
							<ul class="unstyled inbox-pagination">
								<li>			               
									<span>${pageNo} of ${totalPageNo} pages</span>
								</li>									
								<li>
									<span><a href="list?pageNo=1">[처음]</a></span>			                   		
								</li>
								<li>
									<c:if test="${groupNo>1}">
										<span><a href="list?pageNo=${startPageNo-1}">[이전]</a></span>
									</c:if>			                   		
								</li>								
								<li>
									<span>
									<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
									&nbsp;
										<a href="list?pageNo=${i}"
											<c:if test="${pageNo==i}">style="color:red"</c:if> 
										>${i}</a>
									</c:forEach>
									</span>
								</li>
								<li>
									<c:if test="${groupNo<totalGroupNo}">
										<span><a href="list?pageNo=${endPageNo+1}">[다음]</a></span>
									</c:if>				                   		
								</li>
								<li>
									<span><a href="list?pageNo=${totalPageNo}">[맨끝]</a></span>                   		
								</li>
							</ul>
	           			</div>
			   			<!-- ./게시물 상단 메뉴 -->
						<!-- 게시물 출력부분 -->
						<table style="width: 840px;">
						<tr>		
						<td valign="top">		
							<!-- 게시물 내용 / start -->
							<c:forEach var="photoBoard" items="${list}">
							<table class="table table-inbox table-hover" style="width:205px; display:inline-block; border: 0px"  valign="top" >
					           	<tbody  style="border: 0px">
					               <tr class="">
										<td class="" style="width:150px;">
										<a href="info?bno=${photoBoard.bno}">
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
			        	<!-- ---------------------------------------------------------------------- -->
			        </div> <!-- ./inbox-body -->
					<!-- ---------------------------------------------------------------------- -->
			    </aside>
			</div>
		</div>	

	</div> <!-- ./container -->
	
</body><!-- BODY 종료 -->
</html>