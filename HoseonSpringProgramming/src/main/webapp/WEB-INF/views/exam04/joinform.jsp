<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>	
	<meta charset = "UTF-8">
</head>
<body>
	<table>
		<tr><td>
			<center><font size = 3 color = red>[★게시물 등록폼★]</font></center><br/>
		</td></tr>			
		<tr><td>			
			<form method="post" action="/myapp/exam04/join">
				<hr/>
				제&nbsp;&nbsp;&nbsp;목 : <input type="text" name ="msubject" value="제목을 입력하세요" width="1000" /><br/>
				<hr/>
				글쓴이 : <input type="text" name ="mname" value="홍길동" /><br/>
				<hr/>
				<textarea rows="10" cols="50" name = "mcontents">내용을 입력하세요</textarea><br/>
				<input type='submit' value='글쓰기'>
			</form>
		</td></tr>
	</table>
</body>
</html>