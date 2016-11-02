<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		* {
			margin:0px;
			padding:0px;
		}
	</style>
	<script type="text/javascript">

	
	
	</script>
	
</head>
<body>
	String 객체의 메소드
	<br>JavaScript String Methods
	<br>http://www.w3schools.com/js/js_string_methods.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
<b>1. String Length</b>
	var txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var sln = txt.length; 이건 메소드가 아닌 필드다
	이렇게 사용가능

<script>	
	var v1 = "abc";
	console.log("v1의 length : " + v1.length);
</script>
	
<b>2. Finding a String in a String, Searching for a String in a String</b>
	둘다 값음 / 포함이 되면 해당위치를 리턴, 위치가 없으면 -1리턴
<script>	
	var str = "Please locate where 'locate' occurs!";
	console.log(str.indexOf("where"));
	console.log(str.indexOf("java")); /* 없으니 -1 */
	console.log(str.search("locate"));
</script>

<b>3. Extracting String Parts</b>
	substring(start, end)
	slice(start, end) substring과 똑같음
	substr(start, length)
<script>	
	var str = "Apple, Banana, Kiwi";
	console.log(str.substring(7,13)); /* 시작인덱스, 끝인덱스 */
	console.log(str.substr(7,6)); /* 시작인덱스, 길이 */
</script>

<b>4. Replacing String Content</b>
<script>	
	str = "Please visit Microsoft!";
	console.log(str.replace("Microsoft","W3Schools"));
</script>

<b>5. Converting to Upper and Lower Case</b>
	var text1 = "Hello World!";       // String
	var text2 = text1.toUpperCase();  // text2 is text1 converted to upper
	
	var text1 = "Hello World!";       // String
	var text2 = text1.toLowerCase();  // text2 is text1 converted to lower

<b>6. The concat() Method</b>
	결합. 근데 잘안씀
	var text1 = "Hello";
	var text2 = "World";
	text3 = text1.concat("	",text2);
	이걸 
	text3 = text1 + "	" + text2; 이렇게 사용가능함으로 잘안씀

<b>7. The charAt() Method</b>
	charAt은 한문자를 뽑아내는것
<script>	
	var str = "Apple, Banana, Kiwi";
	console.log(str.charAt(7));
</script>

<b>Converting a String to an Array</b>
	구분자 기준으로 구분해서 배열항목으로 리턴하는 기능
	var txt = "a,b,c,d,e";   // String
	txt.split(",");          // Split on commas
	txt.split(" ");          // Split on spaces
	txt.split("|");          // Split on pipe
<script>	
	var txt = "10:20:30";
	var txt2 = txt.split(":");
	console.log(txt2);
	console.log(txt2[0]);
	console.log(txt2[1]);
	console.log(txt2[2]);
</script>


그외 다른 메소드들은 
W3Schools - JavaScript - 완전한 Reference(DOC)
http://www.w3schools.com/jsref/default.asp
에서 찾아봐






</pre>
</body>
</html>
