package ch05.exam02;

public class MainArgument {

	public static void main(String[] args) {
		//java MainArgument
		String v1 = args[0];
		String v2 = args[1];
		String result = v1 + v2;
		
		int intV1 = Integer.parseInt(v1);
		int intV2 = Integer.parseInt(v2);
		int intResult = intV1 + intV2;
		System.out.println("int_result = " + intResult);
		

	}

}
