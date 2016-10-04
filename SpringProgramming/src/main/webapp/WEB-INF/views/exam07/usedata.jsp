<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
<b>데이터 찾기</b><br/>
<hr/>
1. [httpServletRequest를 이용해서 찾기]<br/>
<!-- 표현식 -->
<!-- 선언없이 사용할 수 있는 변수 request, response, session JSP쓸떄는 많이 쓰는데, 스프링에서는 잘 안씀 -->
<!-- reqeust안에 data1로 저장되어있는 객체를 가지고와서 (String)로 변환해서 출력해라 -->
데이터1: <%=(String)request.getAttribute("data1") %><br/>
데이터2: <%=(String)request.getAttribute("data2") %><br/>
<br/>
2. [httpSession를 이용해서 찾기]<br/>
데이터1: <%=(String)session.getAttribute("data1") %><br/>
데이터2: <%=(String)session.getAttribute("data2") %><br/>
<br/>
3. [EL을 이용해서 찾기]<br/>
데이터1: ${data1}<br/>
데이터2: ${data2}<br/>
<br/>
</body>
</html>
