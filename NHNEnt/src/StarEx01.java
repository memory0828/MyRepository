import java.io.IOException;
import java.util.Arrays;

public class StarEx01 {

	public static void main(String[] args) throws Exception {
		//다이아몬드 별찍기
		int star = 7;
		int mid = (star/2) + 1; 
		for(int i=1, j=0; i<=star; i++){
			for(int k=1; k<=(mid+j); k++){
					System.out.print((k < mid-j)?" ":"*");
			}
			j += (i<mid)?1:-1;
			System.out.println();
			
		}
		
	}

}
