package ch13.exam03;

public class ProductExample {
	public static void main(String[] args) {
		//타입파라미터가 2개 이상일 경우 사용하는 방법
		Product<String, String> p1 = new Product<>();
		
		p1.setKind("Tv");
		p1.setModel("스마트");
		String kind1 = p1.getKind();
		String model1 = p1.getModel();
		
		//Tv는 내가 만든 클래스임
		Product<Tv, String> p2 = new Product<>();
		p2.setKind(new Tv());
		p2.setModel("완전평면");
		Tv kind2 = p2.getKind();
		String model2 = p2.getModel();
	}
}
