<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String kind = request.getParameter("kind");
	String keyword = request.getParameter("keyword");
%>
<table>
	<tr>
		<td>
			<%for(int i=1; i<=3; i++) { %>
			<div style="width:120px; height:130px; background-image:url('../common/image/photo<%=i%>.jpg'); background-size: 120px 100px; margin: 5px; display: inline-block;">				
				<div style="height:100px;" >
					<span style="color:white; font-size:12px">${photoBoard.bdate}</span>
				</div>
				<div>
					<table style="width:100%; height:30px; background-color: black; opacity: 0.5;"> 
						<tr>
							<td style="text-align: left; color:white"><%=kind%></td>
							<td style="text-align: right; color:aqua"><%=keyword+i%></td>
						</tr>
					</table>
				</div>
			</div>
			<% } %>
		</td> 
	</tr>
</table>