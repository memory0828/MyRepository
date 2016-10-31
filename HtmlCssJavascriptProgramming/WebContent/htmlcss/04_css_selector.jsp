<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %>
<!DOCTYPE html>
<html> 
<head> 
	<meta charset = "UTF-8">
	<style type="text/css">
		/* * { color:red; } */ /* ���� */
		div { background-color: yellow }  /*div �±� ���� */
		/*# = id�� �����Ѱ�
		  .  = class�� �׷��� �������Ѱ�*/
		#div2 { background-color: aqua } /*#�� ������ id�� �̸��� �̰��ΰ� */
		.div3 { background-color:olive } /* .�� ������ class(����)�� �̸��� �̰��ΰ� */
		
		#div, #p, #h1 { background-color: orange;} /* �̷��� �����Ҽ������� */
		
		#div5 p { background-color: blue } /* div5 �ȿ� �ִ� ��� p */
		#div6 > p { background-color: fuchsia; }  /*div6 �̰� �ٷ� �ؿ� �ִ� p */
		
		[checked] { color: green } /* []�� �� �ȿ� �� �Ӽ��� ���� ��� ������Ʈ�� */
		[selected=true] { color: green } /* []�� �� �ȿ� �� �Ӽ� �� �� ���� true���� ���� ������Ʈ�� */
		
		#form1 [checked] { background-color: red } /* id�� form1�� �� �ȿ� �ִ� checked�� �����͵� Ȱ���ؼ� �����غ� */
		
		a {color : black; text-decoration: none;  } 
		a:active { color:red } /* ��ũ�� Ŭ�� ������ */
		a:link { color:green } /* ��ũ�� �ѹ��� �湮������ ���� */
		a:hover { color:blue; text-decoration: underline; } /* ��ũ�� ���콺 �ø��� */

	</style> 
</head>
<body>
	CSS ������
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
		<a href="http://www.naver.com">���̹�</a><br/>
		<a href="http://www.nave1r.com">��Ĺ</a><br/>
	</div>
	

</body>
</html>
