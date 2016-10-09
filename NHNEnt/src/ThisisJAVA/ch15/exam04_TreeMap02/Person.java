package ThisisJAVA.ch15.exam04_TreeMap02;
//대소 비교 기능이 있는
//implements Comparable을 구현한 클래스
public class Person implements Comparable<Person> {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	@Override
	public int compareTo(Person o) {
		//나이로 대소 비교를 해주자
		return (age - o.age);
		/* 같은 기능
		if(age<o.age) return -1;
		else if(age == o.age) return 0;
		else  return 1;
		*/
	}
}