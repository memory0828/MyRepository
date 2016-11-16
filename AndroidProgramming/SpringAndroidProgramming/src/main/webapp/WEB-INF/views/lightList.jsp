<%@ page contentType="application/json;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="light" items="${list}"> <%-- ${list}는 el에서 등록된 객체 찾음 --%>
	{
		"image":"${light.image}", <%-- "${light.image}"에서 ""는 문자라서 ""로 감쌓음. 이거 잘까먹음 조심! --%>
		"imageLarge":"${light.imageLarge}", <%--복습 : .imageLarge에서 .의 getter 메소드 호출과 마찬가지 --%>
		"title":"${light.title}",
		"content":"${light.content}"
	}
	<c:if test="${!status.last}">,</c:if> <%--마지막번째 실행하는 내용이 아니라면 ,(콤마)를 넣어줘라--%>  
</c:forEach>
]