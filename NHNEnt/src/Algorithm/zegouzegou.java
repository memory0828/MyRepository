package Algorithm;

public class zegouzegou {

    public static void main(String[] args) {
    	//지그재그 출력
    	int line=1;
    	int num=1;
    	for(line=1; line<=5; line++){
	    	if( line % 2 == 0 ){
	    		//짝수행
	    		for(int i=(num+5); i>num; i--){
	    			System.out.print(i+"\t");
	    		}
	    		num+=6;
	    		System.out.println();
	    	}else{
	    		//홀수행
	    		for(int i=num; i<=num+4; i++){
	    			System.out.print(i+"\t");
	    		}
	    		num+=4;
	    		System.out.println();
	    	}
    	}
    }
}
