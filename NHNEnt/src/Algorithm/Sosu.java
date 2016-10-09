package Algorithm;

public class Sosu {

	public static void main(String[] args) {
    	//1~100 사이의 중 소수를 구하는것
    	int suk=0;
    	for(int i=1; i<=100; i++){
    		for(suk=1; suk<i; suk++){
    			if( suk != 1 && (i%suk == 0) ){
    				break;
    			}
    		}
    		if( i == suk ) System.out.print(i + " ");
    	
    	}
	}

}
