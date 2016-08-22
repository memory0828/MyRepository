package ch05.exam02;

public class ArrayInReferenceCompare {

	public static void main(String[] args) {
		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "홍길동";
		names[2] = new String("홍길동");

	}

}
