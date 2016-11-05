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
	<style type="text/css">
		a{
			text-decoration: none;
			color:black;
		}
		a:HOVER{
			color:green;
		}
	</style>
</head>
<body>

	<div class="" align="center">
		<h3>Photo Board</h3>
		<c:if test="${login != null}">
		<div style="width: 900px; margin-bottom:5px; padding: 0px; vertical-align: bottom;">
			<div style="width: 290px; display: inline-block; margin: 0px; " align="left">
				${pageNo} of ${totalPageNo} pages
			</div>
			<div style="width: 600px; display:inline-block; margin: 0px; " align="right" >
				<a href="write" class="btn btn-info btn-sm">write</a>
			</div>
		</div>
		</c:if>
		
		<table class="table" style="width: 900px; ">			
		<tbody>
		<tr>
			<td>
				<c:forEach var="photoBoard" items="${list}">
				<!-- 이아래건 게시물 추가후 5초의 딜레이가 생김 -->
				<!-- <div style="width:120px; height:130px; background-image:url(../resources/image/${photoBoard.savedfile}); background-size: 120px 100px; margin: 5px; display: inline-block;"> -->
				<!-- 이아래건 게시물 추가후 딜레이가 없이 바로 반영됨 이방법을 기억하자! -->
				<a href="info?bno=${photoBoard.bno}">
				<div class="img-rounded" style="width:205px; height:205px; background-image:url(showPhoto?savedfile=${photoBoard.savedfile}); background-size: 205px 205px; margin: 6px; display: inline-block;">				
					<div style="height:170px;" >
						<span style="color:white; font-size:12px">&nbsp;&nbsp;${photoBoard.bdate}</span>
					</div>
					<div>
						<table style="width:100%; height:30px; background-color: black; opacity: 0.5;"> 
							<tr>
								<td style="text-align: left; color:white">&nbsp;&nbsp;${photoBoard.btitle}</td>
								<td style="text-align: right; color:aqua">${photoBoard.bhitcount}&nbsp;</td>
							</tr>
						</table>
					</div>
				</div>
				</a>
				</c:forEach>
			</td> 
		</tr>
		</tbody>
		</table>

		<div style="width: 900px; margin-bottom: 50px" align="center">	
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
			&nbsp;
				<a href="list?pageNo=${i}"
					<c:if test="${pageNo==i}">style="color:red"</c:if> 
				>${i}</a>
			</c:forEach>
			<c:if test="${groupNo<totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
	</div> <!-- ./jumbotron -->
</body>
</html>