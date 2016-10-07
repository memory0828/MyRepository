public class TEST {

    public static void main(String[] args) {
    	//모래시계
    	int star = 9;
    	int mid = (star/2)+1;
    	for(int i=1, j=0; i<=star; i++){
    		for(int k=1; k<=(star-j); k++){
    				System.out.print(   ((k<=j)?" ":"*")     );
    		}
    		if( i < mid ){
    			j++;
    		}else{
    			j--;
    		}
    		System.out.println();

    	}
    }
}
