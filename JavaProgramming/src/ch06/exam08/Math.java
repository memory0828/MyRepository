package ch06.exam08;

public class Math {
	//Field
	
	//Constructor
	
	//Method
	void printInfo(String info){
		System.out.println("수학 객체가 생성됨");
	}
	
	int max(int x, int y){
		if(x>y) {
			return x; 
		}else{
			return y;
		}
	}
	
	//호출할때 
	double avg1(int[] num){		
		int sum = 0;
		for(int i=0; i<num.length; i++){
			sum += num[i];
		}
		return (double)sum / num.length;
	}
	double avg2(int ... num){
		//사용 방식은 위와 동일
		//똑같은 타입의 매개변수를 받는데 그 수가
		//들쑥 날쑥할수 있는 매개변수를 사용할때는 이렇게 사용
		int sum = 0;
		for(int i=0; i<num.length; i++){
			sum += num[i];
		}
		return (double)sum / num.length;
	}	
}
