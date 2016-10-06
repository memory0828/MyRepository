<%@ page contentType = "text/html;charset=UTF-8"  import ="com.mycompany.myapp.exam07.Board, java.util.*" %>
<!-- contentType이 잘못지정되면 페이지가 다운로드되는 등의 문제가 있으니 지정하는거 중요!-->
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 참고 위코드를 아래처럼 사용할수도 있다. 
< % @ page contentType = "text/html;charset=UTF-8" %> 
< % @ page import = "com.mycompany.myapp.exam07.Board" %> 
< % @ page import = "com.mycompany.myapp.exam07.*" %>
< % @ page import = "com.mycompany.myapp.exam07.*, java.util.*" %>
-->

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
	
	<b>HttpServletRequest에 저장된 거 가져다 쓰기</b><br/>
	<hr/>
	4-1. [EL사용해서 객체의 속성(필드) 값 얻기] - 10/06(목)<br/>
	EL = 익스프레션 랭귀지 = 표현언어<br/>
	<%-- HttpServletRequest 범위에서 board라는 객체를 가져와서 그 board가 가지고 있는 bno의 getter 매소드를 호출해서 bno의 값을 가지고 와라 --%>
	번호 : ${board.bno}<br/> 
	<%--
	보통은 . 은 객체접근 명령어인데 EL내부에서의 . 의 getter 매소드를 접근해라의 의미
	그래서 형태는 board.bno로 bno의 값을 읽어라지만, EL내부에서는 bno의 getter매소드를 접근해라.
	즉.  board.bno = board.getBno() 이다
	 --%>
	제목 : ${board.title}<br/>
	내용 : ${board.content}<br/>
	조회수 : ${board.hitcount}<br/>
	<%-- 즉, 컨트롤러에서 객체를 만들고 이 객체를 모델에 저장하니깐(HttpServletRequest) ,jsp에서 EL로 이렇게 찾아와서 이용을 할수있다는 학습!  --%>
	
	4-2. [EL을 사용안하고(JSP만 쓸때 쓰는 방식!) 객체의 속성(필드) 값 얻기] - 10/06(목)<br/>
	<!--
      근데 위 4-1처럼 EL을 안쓰고 자바코드만가지고 똑같이 나오게 할수있는데 EL을 쓰면 좀더 편리하다
      보통 JSP만 가지고 작업할 경우에는 자바코드만 가지고 처리한다 그럴떄 
      스플릿플릿(표현식) = <% %> 으로 처리함
      - 앞에서 나온거랑 차이 -
      <%-- --%> 이건 주석!
      < %=   % > 이건~ 이 < % = 다음 나오는 있는 값을 넣어라. 즉 하나의 값을 산출하는 코드가 들어감
                  그리고 이 안에서는 세미콜론( ; ) 을 붙이지 안흔다 붙이면 에러!
      < %@   % > 지시자를 사용하는데 어떤 지시자를 사용하느냐를 지정하는것
      				- 지시자의 종류 : page, 인클루드, 테그 라이브러리? 뒤에서 나올떄 설명아나옴
      				- page지시자 : jsp가 만들어내는 이 전체 페이지에 여향을 미치는 어떤 속성들..속성의값을 지정하는 것
      < % % > 이건 순수하게 자바코드만 실행해라는 기호. 값을 출력하려는 목적이 아니당
	-->
	
	<!-- 근런데 아래 코드처럼 
	< % Board board = new board(); % >
	 아무것도 없이 위 코드 넣으면 
	 Board cannot be resolved to a type 나오는데 이건 import가 안됐을 경우 나오는 에러 메시지 그래서 맨위에 넣어야함
 	-->
	<% Board board = (Board)request.getAttribute("board"); %> 	
 	<% if(board != null) { %>
		번호 : <br/> 
		제목 : <%=board.getTitle() %><br/>
		내용 : <%=board.getContent() %><br/>
		조회수 : <%=board.getHitcount() %><br/>
	<%} %>
	<br/>
	5. [컬렉션 이용하기(JSTL과 EL활용)] - 10/06(목)<br/>
	<!-- 
	JSTL 자바 스탄다드 테그 라이브러리
	태그 라이브러리중 표준적으로 사용할수 있는 즉. 어떠한 JSP든 공용적으로 사용할 수 있는 라이브러리
	조건을 세우거나 어떤 반복을 하거나 할떄 EL만 가지고 할수없으니깐
	taglib와 결함해서 많이 사용
	그래야 EL을 가지고 코딩할 수 있는 태그를 같이 써서 컬렉션을 처리할수 있음
	< %@ taglib prefix ="" uri = "" %>
	소스 앞부분에 이걸함으로서 여기서 제공해주는 태그들을 쓸수있다.
	   - prefix ="" uri = ""  이 역할은
	   - 네임스페이스 지정하는 역할(XML에서 나옴. 어러개를 사용할 경우 구분해주기 위해 )   
	< %@ taglib prefix ="네임스페이스 지정(접두사 지정)" uri = "해당 마크업의 네임스페이스 이름" %>
	< %@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
                              여기에 c를 쓰던 d를 쓰던 상관없다. 근데 일반적으로 core에 속하는 테그는 c를 많이 쓴다.	                     
 	-->
 	(1) JSP를 이용해서 컬랙션 활용하기<br/>
 	 <!-- boardlist 는 HttpServletRequest에 저장된 boardlist라는 이름의 객체임 -->
	<%List<Board> list1 = (List<Board>)request.getAttribute("boardlist"); %>
	<table style="border: 1px solid black; border-collapse: collapse; width: 600px">
		<tr style="background-color: #ffcc00"><th>번호</th><th>제목</th><th>내용</th><th>조회수</th></tr>
		<% if(list1 != null) { %>
			<%for(Board b1 : list1) { %> <!-- 밑에 나오는 자바코드에 테그가 섞여서 닫아줌 -->
		<tr>
			<td style="border: 1px solid black;"><%=b1.getBno() %></td> 
			<td style="border: 1px solid black;"><%=b1.getTitle() %></td>
			<td style="border: 1px solid black;"><%=b1.getContent() %></td>
			<td style="border: 1px solid black;"><%=b1.getHitcount() %></td>
		</tr>
			<% } %>
		<% } %>			
	</table>
	<br/>
	(2) JSTL과 EL활용해서 컬랙션 활용하기<br/>
 	 <!-- boardlist 는 HttpServletRequest에 저장된 boardlist라는 이름의 객체임 -->	
	<table style="border: 1px solid black; border-collapse: collapse; width: 600px">
		<tr style="background-color: #ffcc00"><th>번호</th><th>제목</th><th>내용</th><th>조회수</th></tr>
		<!-- 여기선 null검사 따로할 필요가없다 boardlist가 null이면 forEach가 아애 동작하지 않음.그래서 예외는 발생하지 않음 -->
		<c:forEach var="b2" items="${boardlist}">
		<tr>
			<td style="border: 1px solid black;">${b2.bno}</td> 
			<td style="border: 1px solid black;">${b2.title}</td>
			<td style="border: 1px solid black;">${b2.content}</td>
			<td style="border: 1px solid black;">${b2.hitcount}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>





