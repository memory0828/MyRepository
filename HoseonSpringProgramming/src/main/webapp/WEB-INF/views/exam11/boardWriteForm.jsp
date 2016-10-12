<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	[회원 가입 폼]<br/>
	<form method="post" action="/myapp/exam11/boardWrite">
		글쓴이 : <input type="text" name ="bwriter" value="늦가을"/><br/>
		제목 : <input type="text" name ="btitle" value="단풍은 어디에" /><br/>		
		내용 : <textarea row="5" cols="20" name="bcontent">단풍이 오기도 전에 겨울</textarea><br/>		
		<input type='submit' value='글쓰기'>
	</form>
</body>
</html>