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
	<div class="jumbotron">
		<form class="form-horizontal" method="post" action=""> <!-- action=""한것은 같은요청경로로 post방식으로 요청함 처리임 -->
		<fieldset>
		<!-- Form Name -->
		<legend>Id 찾기</legend>
		
		<div class="form-group">
		  <label class="col-md-4 control-label">이메일</label>  
		  <div class="col-md-4">
			<input type="email" class="form-control input-md" name="memail"/>${error}
		  </div>
		</div>
		<div class="form-group" >
		  <label class="col-md-4 control-label"></label>
		  <div class="col-md-4">
				<input type="submit"  class="btn btn-sm btn-primary btn-block" value="찾기">
		  </div>
		</div>
		
		</fieldset>		

		</form>

	</div>
</body>
</html>