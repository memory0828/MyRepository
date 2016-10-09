package StarPRNT;
import java.io.IOException;
import java.util.Arrays;

public class StarEx06 {
    public static void main(String[] args) {
    	//구멍뚤린 모래시계
    	int star = 5;
    	int starmin = (star / 2) + 1;
    	
    	for(int i=1,j=0; i<=star; i++ ){
    		for(int k=1; k<=star-j; k++){
    			if( (k == j+1) || (k == star-j) || (i==1) || (i==star) )
    				System.out.print("*");
    			else
    				System.out.print(" ");
    		}
    		System.out.println("");
    		
    		if(i < starmin){
    			j++;
    		}else{
    			j--;
    		}	
    	}
		
    }

}
