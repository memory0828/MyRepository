<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
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
	<a href="modify?bno=${freeboard.bno}">[수정]</a>
	<a href="remove?bno=${freeboard.bno}">[삭제]</a>
	<a>[목록]</a>
</body>
</html>