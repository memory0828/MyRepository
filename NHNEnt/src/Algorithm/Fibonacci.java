package Algorithm;

public class Fibonacci {
    public static void main(String[] args) {
    	//피로나치 수열
    	int v1=0;
    	int v2=1;
    	int vsum = 0;
    	
    	for(int i=1; i<=12; i++){
	    	vsum = v1 + v2;
	    	v1 = v2;
	    	v2 = vsum;
	    	System.out.print(vsum + " / ");
    	}
    }
}
