/*1. 이건 그냥 보통 방식*/
function sum(from, to) {
	for(var i = from; i<=to; i++){
		var sum = 0;
		for(var i=from; i<=to; i++){
			sum += i;
		}
		return sum;
	}
} 

/*2. 이건 배포용으로 중복을 없애기 위한 방식*/
/*$는 변수인데 객체 그래서 $.sum(10,20) 이런식으로 사용가능*/
var $ = {
	sum : function(from, to) {
		for(var i = from; i<=to; i++){
			var sum = 0;
			for(var i=from; i<=to; i++){
				sum += i;
			}
			return sum;
		}
	} 
}
