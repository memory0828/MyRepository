package Algorithm;

public class NumChange {

    public static void main(String[] args) {
    	//2 8 16 10진수 변환
    	String t1 = Integer.toBinaryString(1234); //2진수
    	String t2 = Integer.toOctalString(1234); //8진수
    	String t3 = Integer.toHexString(1234); //16진수
    	
    	int i1 = Integer.parseInt(t1, 2 ); //2진수 -> 10진수로
    	int i2 = Integer.parseInt(t2, 8 ); //8진수 -> 10진수로
    	int i3 = Integer.parseInt(t3, 16 ); //16진수 -> 10진수로
    	
    	System.out.println(t1);
    	System.out.println(t2);
    	System.out.println(t3);
    }
}
