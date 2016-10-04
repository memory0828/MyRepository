<%@ page contentType = "text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
</head>
<body>
<b>Exam06 - 요청 처리 메소드의 매개 변수 타입</b><br/>
큰 주제 : 매개변수에 뭐가 들어갈수있느냐?<br><br/>
1) 개별 파라미터 값을 받을 수 있는 변수 선언<br/>
2) @RequestParam 이노테이션<br/>
3) 커맨드 객체(파라미터 값을 객체로 받음) 선언<br/>
4) <a href="/myapp/exam06/method1?mid=xxx&mname=yyy">HttpServletRequest 변수 선언이 올수 있다.  - 9/30, 10/4</a><br/>
5) <a href="/myapp/exam06/method2">HttpServletResponse 변수 선언이 올수 있다. - 10/4</a><br/>
6) <a href="/myapp/exam06/method3">RequestHeader 변수 선언이 올수 있다. - 10/4</a><br/>
<b>7) CookieValue 변수 선언이 올수 있다. - 10/4</b><br/>
 7-1) <a href="/myapp/exam06/method4CreateCookie">Cookie 생성 - 10/4</a><br/>
 7-2) <a href="/myapp/exam06/method4ReceiveCookieHow1">Cookie 받기 방법1 - 10/4</a><br/>
 7-3) <a href="/myapp/exam06/method4ReceiveCookieHow2">Cookie 받기 방법2 - 10/4</a><br/>
 7-4) <a href="/myapp/exam06/method4DeleteCookie">Cookie 삭제 - 10/4</a><br/>
<b>8) HttpSession 변수 선언이 올수 있다. - 10/4</b><br/>
 8-1) <a href="/myapp/exam06/method5SetObject">HttpSession에서 객체 저장 - 10/4</a><br/>
 8-2) <a href="/myapp/exam06/method5GetObject">HttpSession에서 객체 얻기 - 10/4</a><br/>
 8-3) <a href="/myapp/exam06/method5RemoveObject">HttpSession에서 객체 삭제 - 10/4</a><br/> 
</body>
</html>
