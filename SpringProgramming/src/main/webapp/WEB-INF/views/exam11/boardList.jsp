<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
<b>Exam11 : 서비스 계층과 데이터(퍼시스턴스(=데이터가 계속적으로 지속적으로 사용해 한다)) 계층)</b><br/>
<b></b><br/>

	<table style="border: 1px solid black; border-collapse: collapse; width: 600px">
		<tr style="background-color: #ffcc00"><th>제목</th><th>내용</th><th>글쓴이</th></tr>
		<c:forEach var="board" items="${boardlist}">
		<tr>
			<td style="border: 1px solid black;">${board.btitle}</td> 
			<td style="border: 1px solid black;">${board.bcontent}</td>
			<td style="border: 1px solid black;">${board.bwriter}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>