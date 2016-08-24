package ch06.exam06;

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b1 = new Board(3);
		Board b2 = new Board(1, "제목");
		Board b3 = new Board("제목", 1);

		String temp = "abc";
		Board b4 = new Board(temp);
		System.out.println(temp);
		
		
		byte[] data = {65,66,67};
		String s1 = new String(data);
	}

}
