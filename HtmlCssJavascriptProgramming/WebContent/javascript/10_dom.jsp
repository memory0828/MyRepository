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
		function onClickButton1(){
			console.log("onClickButon1() 실행");
			/* 이미 만들어진 dom객체에서 내가 이 객체를 가져와서 사용하겠다 */
			/* var div1 = document.getElementById("div1"); */ /* div1의 아이디로된 객체를 찾아서 반환 */
			/* 뭔가 찾아라~ 는 메소드를 써서 저 밑에 DIV를 찾아서쓴다
			document.getElementById(id)	id이름으로 찾아라
			document.getElementsByTagName(name)	태그이름으로 찾아라
			document.getElementsByClassName(name)	클래스이름으로 찾아라 */
			var div1 = document.querySelector("#div1");
			console.log(div1);
			/* 그럼 찾아서 뭐하겠다고?
			이 객체의 필드와 메소드를 사용하겠다! 이 객체안에없으면 부모 객체의 필드와 메소드를 사용!*/
			div1.innerHTML = "수정"; /* div의 부모는 DOM Elements고 .innerHTML는 부모의 필드 */
		}
	
		function onClickButton2(){
			console.log("onClickButon2() 실행");
			/* 이미 만들어진 dom객체에서 내가 이 객체를 가져와서 사용하겠다 */
			/* 또 img 객체를 얻어와라(이소에서는 img태그는 하나밖에 안쓰였으니.. 그냥이렇게 써봄) */
			/* 근데 .getElementsByTagName는 배열형태의 값이 반환되니깐 아래서 배열로 사용함 */
			/* var img = document.getElementsByTagName("img"); */
			/* 근데 이런 배열형태 반환은 img 태그가 엄청많이 쓰이니깐 별로 안쓰이고
			   id와 class를 가지고 쓰는 방식을 더 많이씀
			즉
			많이쓰임 : document.getElementById(id)	id이름으로 찾아라(반환하나)	
			잘안쓰임 : document.getElementsByTagName(name)	태그이름으로 찾아라(반환이 배열형태)
			많이쓰임 : document.getElementsByClassName(name)	클래스이름으로 찾아라(반환이 배열형태(class는 집합이기때문에)) 
			*/
			/* 이건 class이름으로 처리하는것 역시 배열형태로 받아서 처리 */
			/* var img = document.getElementsByClassName("photo");
			console.log(img);
			img[0].src = "../common/image/photo2.jpg" */
		
			/* 이렇게 DOM을 잘 조작하면 웹페이지가 동적으로 바뀌는데 이것을 ms사에서
			동적HTML 즉 DHTML이라고 칭한다 */
			
			/* 많이쓰임 : document.getElementById(id)	id이름으로 찾아라(반환하나)	
			잘안쓰임 : document.getElementsByTagName(name)	태그이름으로 찾아라(반환이 배열형태)
			많이쓰임 : document.getElementsByClassName(name)	클래스이름으로 찾아라(반환이 배열형태(class는 집합이기때문에)) 
			여기에 html5에 들어오면서 2가지가 더 추가됨
			
			다양한 조건으로서 찾아오기에는 위 방식이 불편한데
			위 방식대신 아래 방식으로 사용하면 다양한 조건으로 찾아오기가 가능하다
			document.querySelector(CSS selectors(선택자)) 객체 하나만 리턴되니깐 하나만 검색할때
				CSS selectors(선택자)안에 있는 다양한 문법을 모두 다 사용할 수 있음
			document.querySelectorAll() 여러개의 객체가 리턴되니깐(배열) 하나가 아니라여러개가 검색되는 상황일떄 */
			
			var img = document.querySelectorAll(".photo");
			console.log(img);
			img[0].src = "../common/image/photo2.jpg";
		}
		
		function onClickButton3(){
			var mid;
			var mpassword;
			
			//입력된 mid와 mpassword 얻는 방법1
 			var inputMid = document.querySelector("#form1 [name=mid]"); /* form의 id을 써서 [속성값]으로 얻는방법 */
			console.log(inputMid.value);
			var mid1 = document.querySelector("#form1 [name=mid]").value;
			console.log(mid1);
			var mid2 = document.querySelector("#IDmid").value; /* input의 id값으로 바로얻는방법 */
			console.log("id값으로 바로 얻기 : " + mid2);
			
			var inputMpassword = document.querySelector("#form1 [name=mpassword]"); /* form의 id을 써서 [속성값]으로 얻는방법 */
			console.log(inputMpassword.value);
			var mpassword1 = document.querySelector("#form1 [name=mpassword]").value;
			console.log(mpassword1);
			var mpassword2 = document.querySelector("#IDmpassword").value; /* input의 id값으로 바로얻는방법 */
			console.log("id값으로 바로 얻기 : " + mpassword2);
			
			//입력된 mid와 mpassword 얻는 방법2
			/* - form 태그부분에 name="form1name" 을 추가하면 아래와 같은 방법이 가능 */
			/* 즉 이렇게 쓰려면 form과 input에 name 속성이 있어야함 */
			var mid5 = document.form1name.mid.value;
			console.log("바로 얻는방법 : " + mid5);
			var mpassword5 = document.form1name.mpassword.value;
			console.log("바로 얻는방법 : " + mpassword5);
			/* 하지만 그렇게 추천하지 않는다 왜? 통일감이 없어서..... */
			
			/*이건 1차 유효성 검사(클라이언트 쪽에서 검증과정)
			  를 하기위한 방법으로 데이터를 얻고 1차적으로 데이터를 걸러내기 위해 */
			if(mid1 == "" ){
				alert("아이디를 입력하세요.");
			} else if(mpassword1 == ""){
				alert("비밀번호를 입력하세요.");
			}

			//서버 전송
			//방법1
			document.querySelector("#form1").submit();
			//방법2
			/* document.form1.submit(); */
			
		}
	</script>
	
</head>
<body>
	DOM 사용
	<br>JavaScript HTML DOM
	<br>http://www.w3schools.com/js/js_htmldom.asp
	<br>
	<a href="index.jsp">index로</a>
	<hr />
<pre>
	<b>JS HTML DOM와 책병행</b>
	DOM
	DOM Intro
	DOM Methods
	DOM Document
	DOM Elements
	DOM HTML
	DOM CSS
	DOM Animations
	DOM Events
	DOM EventListener
	DOM Navigation
	DOM Nodes
	DOM Nodelist
	
	이런타입들이 객체가 브라우저를 통해 자동으로 생성되고
	이걸 가지고 자바스크립트 프로그램이 돌아간다
</pre>
	<button onclick="onClickButton1()">버튼1</button>
	<div id="div1">최초 내용</div>
	
	<button onclick="onClickButton2()">버튼2</button>
	<div>
		<img src="../common/image/photo1.jpg" class="photo"/>
	</div>
	
	<button onclick="onClickButton3()">버튼3</button>
	<div>
		<form id="form1" name="form1name">
			아이디 : <input type="text" name="mid" id="IDmid"><br/>
			비밀번호 : <input type="password" name="mpassword" id="IDmpassword"><br/> 
		</form>
		<form id="form2" name="form2name">
			아이디 : <input type="text" name="mid"><br/>
			비밀번호 : <input type="password" name="mpassword"><br/> 
		</form>
	</div>




<script>	

</script>
	
	
	



</pre>
</body>
</html>
