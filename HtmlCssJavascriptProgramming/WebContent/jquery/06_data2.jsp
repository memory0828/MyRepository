<%@ page contentType="text/html;charset=UTF-8"%>
<%
	boolean result = true;
	String mid = request.getParameter("mid"); /* mid로 넘겨받은 값을 받을 수 있음 */
	if( mid.equals("user1") ) {
		result = false;
	}
%>
<%=result%>