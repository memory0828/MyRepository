<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
	Exam02
	<hr/>
	<a href = "/myapp/exam02/join?mid=user1&mname=홍길동&mage=30">가입</a><br/>
	<a href = "/myapp/exam02/login?id=user1&password=12345">로그인</a><br/>	
	<a href = "/myapp/exam02/order?pid=5&pname=마우스&pprice=5000&pcompany=삼성">주문1</a><br/>	
	<a href = "/myapp/exam02/write?title=게시물제목&content=게시물 내용">글쓰기</a><br/>	
	<a href = "/myapp/exam02/update?bno=108&title=게시물제목&content=게시물 내용&count=3">글쓰기</a><br/>	
	<a href = "/myapp/exam02/send?bno=20&title=게시물제목&content=게시물 내용&hitcount=20">보내기</a><br/>	
</body>
</html>