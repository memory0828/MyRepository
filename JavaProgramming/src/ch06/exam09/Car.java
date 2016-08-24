package ch06.exam09;

public class Car {
	//필드
	int gas;
	Car(){}
	Car(int[] v){
		for(int i=0; i<v.length; i++){
			v[i] = 10;
		}
	}
	//생성자
	
	void Set1(int[] v){
		for(int i=0; i<v.length; i++){
			v[i] = 20;
		}
	}	
	
	void Set2(int ...v){
		for(int i=0; i<v.length; i++){
			v[i] = 30;
		}
	}	
	
	void Set3(int a){
		a = 1;
	}		

	void Set4(String argsStr){
		argsStr = "바뀜";
	}
	void Set5(String[] argsStr){
		for(int i=0; i<argsStr.length; i++){
			argsStr[i] = "바뀜";
		}
	}
	
	
	//메소드
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다."); 
			return false;
		}
		System.out.println("gas가 있습니다."); 
		return true;
	}
	
	
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return;
			}
		}
	}
	
	
}
