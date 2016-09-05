package ch11.exam10;

public class StringSplitExample {
	public static void main(String[] args) {
		String text = "홍길동,이수홍,박연수,김자바-최명호";
		String[] names1 = text.split(","); // ,로 구분해서 각각을 배열에다 넣기
		for(String name : names1) {
			System.out.println("names1" + name);
		}
		
		String[] names2 = text.split(",|-");; // 응용 , |(구분) - 로 구분해서 각각을 배열에다 넣기
		for(String name : names2) {
			System.out.println("names2" + name);
		}		
	}
}