package Algorithm;
public class NumSum01 {

    public static void main(String[] args) {
    	/*각 자리수의 값을 더하여 출력하는 프로그램을 작성
    	예) 4567 => 4+5+6+7 => 22를 출력하는 문제*/
    	int d = 4567;
    	System.out.println(reSum(d));
    
    }
    
    public static int reSum(int data){
    	//재귀호출이용
    	if(data >0){
    		int sum = data%10;
    		sum += reSum(data/10);
    		return sum;
    	}else{
    		return 0;
    	}	
    }

	public static int doWhileSum(int value){
		//while이용
		int sum=0;
		do{
			sum += value%10;
			value /= 10;
		}while(value>0);
		return sum;
	}
}
