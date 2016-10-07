public class StarEx03 {

	public static void main(String[] args) throws Exception {
		//갈매기 찍기
		int star = 9;
		int mid = (star/2) + 1; 
		for(int i=1, j=0; i<=9; i++){
			for(int k=1; k<=mid+j; k++){
				System.out.print((k<=j)?" ":"*");
			}			
			System.out.println();
			if(i<mid){
				j++;
			}else{
				j--;
			}
		}

		

	}

}
