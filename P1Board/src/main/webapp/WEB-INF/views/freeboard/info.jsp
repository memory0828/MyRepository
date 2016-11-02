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
			         <!-- ModalModify / 시작 -->
			         <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalModify" class="modal fade" style="padding-top:110px; display: none;">
			             <div class="modal-dialog">
			                 <div class="modal-content">
			                     <div class="modal-header">
			                         <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			                         <h4 class="modal-title">Modify</h4>
			                     </div>
			                     <div class="modal-body">
			                         <form role="form" class="form-horizontal" method="post" action="<%=pageContext.getServletContext().getContextPath()%>/freeboard/modify" >
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Subject</label>
			                                 <div class="col-lg-10">
			                                 	<input type="hidden" name="bno"value="${freeboard.bno}"/>
			                                     <input type="text" placeholder="" value="${freeboard.btitle}" name="btitle" id="btitle" class="form-control"> 
			                                 </div>
			                             </div>
			                             <div class="form-group">
			                                 <label class="col-lg-2 control-label">Content</label>
			                                 <div class="col-lg-10">
			                                     <textarea rows="10" cols="30" class="form-control" id="bcontent" name="bcontent">${freeboard.bcontent}</textarea>
			                                 </div>
			                             </div>
			
			                             <div class="form-group">
			                                 <div class="col-lg-offset-2 col-lg-10">
 			                                     <!--<span class="btn green fileinput-button">
			                                       <i class="fa fa-plus fa fa-white"></i>
			                                       <span>Image Attachment</span>
			                                       <input type="file" name="files[]" multiple="">
			                                     </span> -->
			                                     <button class="btn btn-send" type="submit">modify</button>
			                                 </div>
			                             </div>
			                         </form>
			                     </div>
			                 </div><!-- /.modal-content -->
			             </div><!-- /.modal-dialog -->
			         </div><!-- /.modal -->
			         <!-- ModalModify / 종료 -->
				</div>
				
			        <ul class="inbox-nav inbox-divider">
			            <li class="active">
			                <a href="${pageContext.servletContext.contextPath}/freeboard/list?pageNo=1"><i class="fa fa-bookmark-o"></i> 자유 게시판 </a>
			            </li>
			            <li class="">
			                <a href="${pageContext.servletContext.contextPath}/photoboard/list?pageNo=1"><i class="fa fa-bookmark-o"></i> 사진 게시판 </a>
			            </li>
			        </ul>
			    </aside>
			    <aside class="lg-side">
			    	<!-- ---------------------------------------------------------------------- -->			    
			        <div class="inbox-head">
			            <h3>SuzuTeam TextBoard</h3>
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
			        	<!-- 내용보기 상단 메뉴 -->	
			           <div class="mail-option">
			               <div class="btn-group">
			               
								<c:if test="${login == freeboard.bwriter}">			               
			                   <div class="btn-group">
			                   <%-- href="modify?bno=${freeboard.bno}"  --%>
                   					<a href="#myModalModify" data-toggle="modal"  title="Compose"    class="btn btn-compose">			                   
			                           modify
									</a>		
			                   </div>
			                   <div class="btn-group">
									<a href="remove?bno=${freeboard.bno}" class="btn btn-compose">			                   
			                           delete
									</a>									
			                   </div>
								</c:if>
			                   <div class="btn-group">
									<a href="list" class="btn btn-compose">			                   
			                           list
									</a>									
			                   </div>
			               </div>			
			               <ul class="unstyled inbox-pagination">
								<li>			               
									<span>${freeboard.bno} 게시물 보기</span>
								</li>									
			               </ul>
			           </div>
						<!-- ./내용보기 상단 메뉴 -->
						<!-- 게시물 상세내용 출력부분 -->
						<table class="table table-inbox" style="width: 820px;">
				           	<tbody style="width: 820px;" >
				               <tr class=""  style="width: 700px;">
									<td style="width: 10px"></td>
									<td >${freeboard.btitle}</td>
									<td  style="width: 100px;">${freeboard.bwriter}</td>
									<td style="width: 50px;">${freeboard.bhitcount}</td>
									<td style="width: 100px" >${freeboard.bdate}</td>
							   </tr>
								<tr class="">
									<td colspan = "5" style="height: 440px"><pre style="white-space: pre-wrap; height:100%">${freeboard.bcontent}</pre></td>									
								</tr>
				           	</tbody>
						</table>	
						<!-- ./게시물 상세내용 출력부분 -->
			        	<!-- ---------------------------------------------------------------------- -->				
			        </div> <!-- ./inbox-body -->
					<!-- ---------------------------------------------------------------------- -->			        
			    </aside>
			</div>
		</div>	

	</div> <!-- ./container -->

</body><!-- BODY 종료 -->
</html>

