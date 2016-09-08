package ch13.exam05;

import java.util.Date;
public class BoxingMethodExample {
	public static void main(String[] args) {
		//이렇게 사용하는거임 알지? ㅋ
		//new Integer(30)을 넘김으로 결국 반환값이 Box<Integer>이 되니깐~^^
		Box<Integer> box1 = Util.boxing(new Integer(30));
		Box<Date> box2 = Util.boxing(new Date());
		Box<String> box3 = Util.boxing("TV"); 
	}
}
