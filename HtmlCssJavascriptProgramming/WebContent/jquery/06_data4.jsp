<%@ page contentType="application/json;charset=UTF-8"%>
[
	{"ano":1, "alocation":"독일", "ahitcount":10, "aimg":"../common/image/photo1.jpg" },
	{"ano":1, "alocation":"독일", "ahitcount":7, "aimg":"../common/image/photo1.jpg" },
	{"ano":1, "alocation":"독일", "ahitcount":15, "aimg":"../common/image/photo1.jpg" }
]
<%--
이상태로 브라우저에서 보면 에러가 안나면 정상적으로 온다는 뜻임
이렇게 요청에대한 응답으로 json 데이터를 문자열을 보내면, jQuery 안 ajax가 해석해서 객체형태로 만들어 주기때문에
데이터를 활용하기 좋다!(수업시간에서 확인함)
그래서 이런 것 때문에, 찰떡궁합이라고 하는거다
--%>