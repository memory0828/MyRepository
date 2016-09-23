package ch15.exam06;

//대소비교 기능이 없는 클래스
public class Fruit {
	public String name;
	public int price;
	
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + "(" + price + ")";
	}

}
