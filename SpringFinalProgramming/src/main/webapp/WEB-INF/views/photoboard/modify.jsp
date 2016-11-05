<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap core CSS -->
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/justified-nav.css" rel="stylesheet">
	<!-- jquery추가하기 -->
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
	<!-- 부트스트랩 jquery추가하기 -->
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	</script>
   </head>
   <body>
      수정
      <hr/>
      <form method="post" enctype="multipart/form-data">
         <table>
            <tr>
               <td style="background-color: orange; width:70px">제목</td>
               <td><input type="text"name="btitle"style="width: 600px;"value="${photoboard.btitle}"/></td>
            </tr>
            <tr>
               <td style="background-color: orange; width:70px">내용</td>
               <td><textarea name="bcontent"style="width: 600px; height:200px;">${photoboard.bcontent}</textarea></td>
            </tr>
            <tr>
               <td style="background-color: orange; width:70px">사진</td>
               <td><input type ="file" name="photo"/>기존파일 : ${photoboard.savedfile}</td>
            </tr>
         </table>
        
         <input type="submit"value="수정"/>
      </form>
   </body>
</html>