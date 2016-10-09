package StarPRNT;
import java.io.IOException;
import java.util.Arrays;

public class StarEx04 {

   public static void main(String[] args) {
    	//삼각형
    	int star = 5;
    	int starmin = (star / 2) + 1;
    	for(int i=1, j=1; i<=5; i++){
    		for(int k=1; k<=(star-1)+j; k++){
    			if(k<=star-j)
    				System.out.print(" ");
    			else
    				System.out.print("*");
    		}
    		j++;
    		System.out.println();
    	}
		
    }

}
