<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %>
<!DOCTYPE html>
<html> 
<head> 
	<meta charset = "UTF-8">
	<style type="text/css">
		/* * { color:red; } */ /* 전부 */
		div { background-color: yellow }  /*div 태그 전부 */
		/*# = id는 유일한값
		  .  = class는 그룹을 묶기위한것*/
		#div2 { background-color: aqua } /*#이 붙으면 id의 이름이 이거인거 */
		.div3 { background-color:olive } /* .이 붙으면 class(묶음)의 이름이 이거인거 */
		
		#div, #p, #h1 { background-color: orange;} /* 이렇게 나열할수도있음 */
		
		#div5 p { background-color: blue } /* div5 안에 있는 모든 p */
		#div6 > p { background-color: fuchsia; }  /*div6 이거 바로 밑에 있는 p */
		
		[checked] { color: green } /* []는 이 안에 들어간 속성을 가진 모든 엘리먼트들 */
		[selected=true] { color: green } /* []는 이 안에 들어간 속성 중 그 값이 true값을 가진 엘리먼트들 */
		
		#form1 [checked] { background-color: red } /* id가 form1인 것 안에 있는 checked을 가진것들 활용해서 조합해봄 */
		
		a {color : black; text-decoration: none;  } 
		a:active { color:red } /* 링크를 클릭 했을때 */
		a:link { color:green } /* 링크가 한번도 방문한적이 없는 */
		a:hover { color:blue; text-decoration: underline; } /* 링크에 마우스 올린거 */

	</style> 
</head>
<body>
	CSS 선택자
	<hr/>
	<div>A</div>
	<div id="div2">B</div>
	<div class="div3">C</div>
	<div class="div3">D</div>	
	<br/>
	
	<div id="div4">E</div>
	<p id="p1">F</p>
	<h3 id="h1">G</h3>
	<br/>

	<div id="div5">
		<p>A</p>
		<p>A</p>
	</div>
	<br/>

	<div id="div6">
		<div><p>A</p></div>
		<p>A</p>
	</div>	
	<br/>
		
	<div>
		<div checked="true">A</div>
		<div checked="false">B</div>
		
		<div selected="false">C</div>
		<div selected="true">D</div>
		<div selected="true">E</div>
	</div>	
	<br>
		
	<form id="form1">
		<div checked="true">A</div>
		<div>B</div>
		<div checked="false">C</div>
	</form>
	<br/>
	

	<div style="background-color: white">
		<a href="http://www.naver.com">네이버</a><br/>
		<a href="http://www.nave1r.com">톰캣</a><br/>
	</div>
	

</body>
</html>
