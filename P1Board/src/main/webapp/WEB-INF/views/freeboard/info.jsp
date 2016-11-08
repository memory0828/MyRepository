<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<title>P1Board</title>
	
	<link href="/myweb/resources/css/bootstrap.min.css" rel="stylesheet">


	<style type="text/css">
			.mail-box {
			    border-collapse: collapse;
			    border-spacing: 0;
			    display: table;
			    table-layout: fixed;
			    width: 100%;
			}
			.mail-box aside {
			    display: table-cell;
			    float: none;
			    height: 100%;
			    padding: 0;
			    vertical-align: top;
			}
			.mail-box .sm-side {
			    background: none repeat scroll 0 0 #e5e8ef;
			    border-radius: 4px 0 0 4px;
			    width: 25%;
			}
			.mail-box .lg-side {
			    background: none repeat scroll 0 0 #fff;
			    border-radius: 0 4px 4px 0;
			    width: 75%;
			}
			.mail-box .sm-side .user-head {
			    background: none repeat scroll 0 0 #00a8b3;
			    border-radius: 4px 0 0;
			    color: #fff;
			    min-height: 80px;
			    padding: 10px;
			}
			.user-head .inbox-avatar {
			    float: left;
			    width: 65px;
			}
			.user-head .inbox-avatar img {
			    border-radius: 4px;
			}
			.user-head .user-name {
			    display: inline-block;
			    margin: 0 0 0 10px;
			}
			.user-head .user-name h5 {
			    font-size: 14px;
			    font-weight: 300;
			    margin-bottom: 0;
			    margin-top: 15px;
			}
			.user-head .user-name h5 a {
			    color: #fff;
			}
			.user-head .user-name span a {
			    color: #87e2e7;
			    font-size: 12px;
			}
			a.mail-dropdown {
			    background: none repeat scroll 0 0 #80d3d9;
			    border-radius: 2px;
			    color: #01a7b3;
			    font-size: 10px;
			    margin-top: 20px;
			    padding: 3px 5px;
			}
			.inbox-body {
			    padding: 20px;
			}
			.btn-compose {
			    background: none repeat scroll 0 0 #ff6c60;
			    color: #fff;
			    padding: 12px 0;
			    text-align: center;
			    width: 100%;
			}
			.btn-compose:hover {
			    background: none repeat scroll 0 0 #f5675c;
			    color: #fff;
			}
			ul.inbox-nav {
			    display: inline-block;
			    margin: 0;
			    padding: 0;
			    width: 100%;
			}
			.inbox-divider {
			    border-bottom: 1px solid #d5d8df;
			}
			ul.inbox-nav li {
			    display: inline-block;
			    line-height: 45px;
			    width: 100%;
			}
			ul.inbox-nav li a {
			    color: #6a6a6a;
			    display: inline-block;
			    line-height: 45px;
			    padding: 0 20px;
			    width: 100%;
			}
			ul.inbox-nav li a:hover, ul.inbox-nav li.active a, ul.inbox-nav li a:focus {
			    background: none repeat scroll 0 0 #d5d7de;
			    color: #6a6a6a;
			}
			ul.inbox-nav li a i {
			    color: #6a6a6a;
			    font-size: 16px;
			    padding-right: 10px;
			}
			ul.inbox-nav li a span.label {
			    margin-top: 13px;
			}
			ul.labels-info li h4 {
			    color: #5c5c5e;
			    font-size: 13px;
			    padding-left: 15px;
			    padding-right: 15px;
			    padding-top: 5px;
			    text-transform: uppercase;
			}
			ul.labels-info li {
			    margin: 0;
			}
			ul.labels-info li a {
			    border-radius: 0;
			    color: #6a6a6a;
			}
			ul.labels-info li a:hover, ul.labels-info li a:focus {
			    background: none repeat scroll 0 0 #d5d7de;
			    color: #6a6a6a;
			}
			ul.labels-info li a i {
			    padding-right: 10px;
			}
			.nav.nav-pills.nav-stacked.labels-info p {
			    color: #9d9f9e;
			    font-size: 11px;
			    margin-bottom: 0;
			    padding: 0 22px;
			}
			.inbox-head {
			    background: none repeat scroll 0 0 #41cac0;
			    border-radius: 0 4px 0 0;
			    color: #fff;
			    min-height: 80px;
			    padding: 20px;
			}
			.inbox-head h3 {
			    display: inline-block;
			    font-weight: 300;
			    margin: 0;
			    padding-top: 6px;
			}
			.inbox-head .sr-input {
			    border: medium none;
			    border-radius: 4px 0 0 4px;
			    box-shadow: none;
			    color: #8a8a8a;
			    float: left;
			    height: 40px;
			    padding: 0 10px;
			}
			.inbox-head .sr-btn {
			    background: none repeat scroll 0 0 #00a6b2;
			    border: medium none;
			    border-radius: 0 4px 4px 0;
			    color: #fff;
			    height: 40px;
			    padding: 0 20px;
			}
			.table-inbox {
			    border: 1px solid #d3d3d3;
			    margin-bottom: 0;
			}
			.table-inbox tr td {
			    padding: 12px !important;
			}
			.table-inbox tr td:hover {
			    cursor: pointer;
			}
			.table-inbox tr td .fa-star.inbox-started, .table-inbox tr td .fa-star:hover {
			    color: #f78a09;
			}
			.table-inbox tr td .fa-star {
			    color: #d5d5d5;
			}
			.table-inbox tr.unread td {
			    background: none repeat scroll 0 0 #f7f7f7;
			    font-weight: 600;
			}
			ul.inbox-pagination {
			    float: right;
			}
			ul.inbox-pagination li {
			    float: left;
			}
			.mail-option {
			    display: inline-block;
			    margin-bottom: 10px;
			    width: 100%;
			}
			.mail-option .chk-all, .mail-option .btn-group {
			    margin-right: 5px;
			}
			.mail-option .chk-all, .mail-option .btn-group a.btn {
			    background: none repeat scroll 0 0 #fcfcfc;
			    border: 1px solid #e7e7e7;
			    border-radius: 3px !important;
			    color: #afafaf;
			    display: inline-block;
			    padding: 5px 10px;
			}
			.inbox-pagination a.np-btn {
			    background: none repeat scroll 0 0 #fcfcfc;
			    border: 1px solid #e7e7e7;
			    border-radius: 3px !important;
			    color: #afafaf;
			    display: inline-block;
			    padding: 5px 15px;
			}
			.mail-option .chk-all input[type="checkbox"] {
			    margin-top: 0;
			}
			.mail-option .btn-group a.all {
			    border: medium none;
			    padding: 0;
			}
			.inbox-pagination a.np-btn {
			    margin-left: 5px;
			}
			.inbox-pagination li span {
			    display: inline-block;
			    margin-right: 5px;
			    margin-top: 7px;
			}
			.fileinput-button {
			    background: none repeat scroll 0 0 #eeeeee;
			    border: 1px solid #e6e6e6;
			}
			.inbox-body .modal .modal-body input, .inbox-body .modal .modal-body textarea {
			    border: 1px solid #e6e6e6;
			    box-shadow: none;
			}
			.btn-send, .btn-send:hover {
			    background: none repeat scroll 0 0 #00a8b3;
			    color: #fff;
			}
			.btn-send:hover {
			    background: none repeat scroll 0 0 #009da7;
			}
			.modal-header h4.modal-title {
			    font-family: "Open Sans",sans-serif;
			    font-weight: 300;
			}			
			.modal-body label {
			    font-family: "Open Sans",sans-serif;
			    font-weight: 400;
			}
			.heading-inbox h4 {
			    border-bottom: 1px solid #ddd;
			    color: #444;
			    font-size: 18px;
			    margin-top: 20px;
			    padding-bottom: 10px;
			}
			.sender-info {
			    margin-bottom: 20px;
			}
			.sender-info img {
			    height: 30px;
			    width: 30px;
			}
			.sender-dropdown {
			    background: none repeat scroll 0 0 #eaeaea;
			    color: #777;
			    font-size: 10px;
			    padding: 0 3px;
			}
			.view-mail a {
			    color: #ff6c60;
			}
			.attachment-mail {
			    margin-top: 30px;
			}
			.attachment-mail ul {
			    display: inline-block;
			    margin-bottom: 30px;
			    width: 100%;
			}
			.attachment-mail ul li {
			    float: left;
			    margin-bottom: 10px;
			    margin-right: 10px;
			    width: 150px;
			}
			.attachment-mail ul li img {
			    width: 100%;
			}
			.attachment-mail ul li span {
			    float: right;
			}
			.attachment-mail .file-name {
			    float: left;
			}
			.attachment-mail .links {
			    display: inline-block;
			    width: 100%;
			}
			
			.fileinput-button {
			    float: left;
			    margin-right: 4px;
			    overflow: hidden;
			    position: relative;
			}
			.fileinput-button input {
			    cursor: pointer;
			    direction: ltr;
			    font-size: 23px;
			    margin: 0;
			    opacity: 0;
			    position: absolute;
			    right: 0;
			    top: 0;
			    transform: translate(-300px, 0px) scale(4);
			}
			.fileupload-buttonbar .btn, .fileupload-buttonbar .toggle {
			    margin-bottom: 5px;
			}
			.files .progress {
			    width: 200px;
			}
			.fileupload-processing .fileupload-loading {
			    display: block;
			}
			* html .fileinput-button {
			    line-height: 24px;
			    margin: 1px -3px 0 0;
			}
			* + html .fileinput-button {
			    margin: 1px 0 0;
			    padding: 2px 15px;
			}
			@media (max-width: 767px) {
			.files .btn span {
			    display: none;
			}
			.files .preview * {
			    width: 40px;
			}
			.files .name * {
			    display: inline-block;
			    width: 80px;
			    word-wrap: break-word;
			}
			.files .progress {
			    width: 20px;
			}
			.files .delete {
			    width: 60px;
			}
			}
			ul {
			    list-style-type: none;
			    padding: 0px;
			    margin: 0px;
			}
			
			
			
			
			
			
			.main{
			 	margin-top: 70px;
			}
			
			h1.title { 
				font-size: 50px;
				font-family: 'Passion One', cursive; 
				font-weight: 400; 
			}
			
			hr{
				width: 10%;
				color: #fff;
			}
			
			.form-group{
				margin-bottom: 15px;
			}
			
			label{
				margin-bottom: 15px;
			}
			
			input,
			input::-webkit-input-placeholder {
			    font-size: 11px;
			    padding-top: 3px;
			}
			
			.main-login{
			 	background-color: #fff;
			    /* shadows and rounded borders */
			    -moz-border-radius: 2px;
			    -webkit-border-radius: 2px;
			    border-radius: 2px;
			    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			
			}
			
			.main-center{
			 	margin-top: 30px;
			 	margin: 0 auto;
			 	max-width: 330px;
			    padding: 40px 40px;
			
			}
			
			.login-button{
				margin-top: 5px;
			}
			
			.login-register{
				font-size: 11px;
				text-align: center;
			}
						

			.colorgraph {
				height: 5px;
				border-top: 0;
				background: #c4e17f;
				border-radius: 5px;
				background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
				background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
				background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
				background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
			}
		</style>

</head>
<body>
	<div class="container">
		<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'> 
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
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>	
</body><!-- BODY 종료 -->
</html>

