<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
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
	자유 게시판
	<hr/>
	<c:if test="${login != null}"><a href="write">[글쓰기]</a></c:if>
	
	<table style="border: 1px solid black; border-collapse: collapse; width: 600px">
		<tr style="background-color: #ffcc00">
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="freeBoard" items="${list}">
		<tr>
			<td style="border: 1px solid black;">${freeBoard.bno}</td> 
			<td style="border: 1px solid black;">
				<a href="info?bno=${freeBoard.bno}">${freeBoard.btitle}</a>
			</td>
			<td style="border: 1px solid black;">${freeBoard.bwriter}</td>
			<td style="border: 1px solid black;">${freeBoard.bhitcount}</td>
			<td style="border: 1px solid black;">${freeBoard.bdate}</td>
		</tr>
		</c:forEach>
	</table>
	<div stytle="width:600px">
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
</body>
</html>