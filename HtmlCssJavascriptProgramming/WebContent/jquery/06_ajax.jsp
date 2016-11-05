<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#btn1").on("click", function() {
				/*	jQuery.ajax( [settings ] ) 이 방식으로 사용
					http://api.jquery.com/jQuery.ajax/ 	*/
				$.ajax( {
					/* 서버로 url: "06_data1.jsp" 이 요청을 비동기적으로 하겠다. 즉 응답이 올때까지 기다리는게 아니라
					응답이 성공적으로 오게되면 function(data) {} 을 자동적으로 실행하겠다
					(data)여기에 서버에서 온 응답내용(응답HTTP의 본문부분만)이 매개값으로 들어옴
					(data)에는 HTML조각이 들어가있음 전체 HTML을 받아오는게 아니라 예)<div>요기</div>에 들어가는 조각을 받아오겠다*/
				 	/* 	● url (default: The current page)
				 		● Type: String */
					url: "06_data1.jsp", /* 속성값( javascript/09_object.jsp 참고 ) */
					/* 	● success
						● Type: Function( Anything data, String textStatus, jqXHR jqXHR ) */
					/* success: function(data, status, xhr) { 이렇게 3개의 매개변수를 받을수있으는데 2개는 잘 사용안한다, 그래서 자바스크립트에서는 꼭 3개의 매개변수라해도 1개만 사용가능함으로 나머지 2개는 생략해서 사용함*/
					success: function(data) { /* 메소드 형식( javascript/09_object.jsp 참고 ) */
						console.log("==============================");
						console.log("data안의 내용은? " + data);
						console.log("==============================");
						$("#div1").html(data);	
					}

				} );
			});
		} );
	
		function checkMid() {
			var mid = $("#mid").val();
			$.ajax({
				url: "06_data2.jsp", 
				data: "mid="+ mid, /* "06_data2.jsp?mid=xxx"을 뜻함 */
				/*data: "mid="+ mid + "&mnane=이건아님",  	  이렇게도 가능*/
				/*data: {"mid":mid, "mage":30 }, 					이렇게 넘겨도 똑같은 효과 */
				success: function(data) {
					console.log(data.trim());
					if(data.trim() == "true") {
						console.log("true일때");
						$("#bnt2Result").html("사용할 수 있음");				
					} else {
						console.log("flase일때");
						$("#bnt2Result").html("사용할 수 없음!!!");
					}
				}
			});
		}

		function getAd(kind, keyword) {
			$.ajax({
				url: "06_data3.jsp",
				data: {"kind":kind, "keyword":keyword},			
				/* methood: "post", */ /* 이렇게 전송방식도 바꿀수있음 */
				success: function(data) {
					$("#div3").html(data);				
				}
			});
		}
		
		function getJson() {
			$.ajax({
				url: "06_data4.jsp",
				success: function(data) {
					console.log("==============================");
					console.log("data안의 내용은? " + data);
					console.log(data);
					console.log(data.length);
					console.log(data[0]);
					console.log(data[0].alocation);
					console.log("==============================");
					var html = "";
					html += '<table>';
					html += '<tr>';
					html += '<td>';
					for(var i=0; i<data.length; i++) {
						html += 	'<div style="width:120px; height:130px; background-image:url('+ data[i].aimg + '); background-size: 120px 100px; margin: 5px; display: inline-block;">';
						html += 		'<div style="height:100px;" >';
						html += 			'<span style="color:white; font-size:12px">${photoBoard.bdate}</span>';
						html += 		'</div>';
						html += 		'<div>';
						html += 			'<table style="width:100%; height:30px; background-color: black; opacity: 0.5;">'; 
						html += 			'<tr>';
						html += 				'<td style="text-align: left; color:white">' + data[i].alocation + '</td>';
						html += 				'<td style="text-align: right; color:aqua">' + data[i].ahitcount + '</td>';
						html += 			'</tr>';
						html += 			'</table>';
						html += 		'</div>';
						html += 	'</div>';
					}
					html += '</td>';
					html += '</tr>';
					html += '</table>';
					
					$("#div4").html(html);	
				}
			});
		}
	</script>
	
</head>
<body>
	ajax(Asynchronous JavaScript and XML, 에이잭스) 통신
	<br>
	<br>http://api.jquery.com/category/ajax/
	<br>
	<a href="index.jsp">index로</a>
	<hr />


	<button id="btn1">버튼1</button>
	<div id="div1" style="height:100px; border:1px solid black;" ><!-- ajax처리내용이들어옴 --></div>
	
	<button id="btn2" onclick="checkMid()">아이디 중복 체크</button>
	<input id="mid" type="text" name="mid" value="user1"/>
	<span id="bnt2Result"></span>
	
	<br/><br/>
	<button id="btn3" onclick="getAd('book', 'java')">광고 정보 얻기</button>
	<div id="div3"></div>
	<div>이건 jQuery안의 ajax로 데이터를 html 조각으로 받아 처리한 방식</div>

	<br/><br/>
	<button id="btn4" onclick="getJson()">JSON 응답 이용</button>
	<div id="div4"></div>
	<div>이건 jQuery안의 ajax로 데이터를 json으로 받아 처리한 방식</div>
	
	
</body>
</html>
