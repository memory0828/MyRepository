package ch05.exam02;

public class ArrayCreateByeValueList1 {

	public static void main(String[] args) {
		
		int[] scores1 = {83,90,87};
		int sum = 0;
		for(int i=0; i<scores1.length; i++){
			sum += scores1[i];
		}
		float avg = (float)sum / scores1.length;
	}

	
}
