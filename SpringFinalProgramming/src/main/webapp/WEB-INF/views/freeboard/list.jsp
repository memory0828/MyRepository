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
		<h3>Text Board</h3>
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
		
		<table class="table table-hover" style="width: 900px; ">
			<tr>
				<th style="width: 50px; text-align: center; ">No</th>
				<th style="text-align: center; ">제목</th>
				<th style="width: 150px; text-align: center; ">writer</th>
				<th style="width: 70px; text-align: center; ">HIT</th>
				<th style="width: 100px; text-align: center; ">Date</th>
			</tr>
			<tbody>
			<c:forEach var="freeBoard" items="${list}">
			<tr>
				<td style="width: 50px; text-align: center; ">${freeBoard.bno}</td> 
				<td style="text-align: left; ">
					<a href="info?bno=${freeBoard.bno}">${freeBoard.btitle}</a>
				</td>
				<td style="width: 150px; text-align: center; ">${freeBoard.bwriter}</td>
				<td style="width: 70px; text-align: center; ">${freeBoard.bhitcount}</td>
				<td style="width: 100px; text-align: center; ">${freeBoard.bdate}</td>
			</tr>
			</c:forEach>
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