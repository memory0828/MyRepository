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
	글내용
	<hr/>
	<table>
		<tr>
			<td style="background-color: orange; width:70px">번호</td>
			<td>${freeboard.bno}</td>
		</tr>
		<tr>
			<td style="background-color: orange; width:70px">제목</td>
			<td>${freeboard.btitle}</td>									
		</tr>
		<tr>
			<td style="background-color: orange; width:70px">내용</td>
			<td>${freeboard.bcontent}</td>									
		</tr>
		<tr>
			<td style="background-color: orange; width:70px">글쓴이</td>
			<td>${freeboard.bwriter}</td>									
		</tr>
		<tr>
			<td style="background-color: orange; width:70px">조회수</td>
			<td>${freeboard.bhitcount}</td>									
		</tr>
		<tr>
			<td style="background-color: orange; width:70px">날짜</td>
			<td>${freeboard.bdate}</td>									
		</tr>		
	</table>
	<div>
		<c:if test="${login == freeboard.bwriter}">
			<a href="modify?bno=${freeboard.bno}">[수정]</a>
			<a href="remove?bno=${freeboard.bno}">[삭제]</a>
		</c:if>
			<a href="list">[목록]</a>
	</div>
</body>
</html>



