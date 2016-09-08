package ch13.exam09;

public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity){
		this.name = name;
		//this.students = new T[capacity]; //타입파라미터로는 패열을 만들수없어서
		//아직 타입이 결정안된 타입파라미터로 선언된 배열은
		//일단 오브젝트 베열로 만들어놓고 그걸 타입파라미터 로 형변환해야만 배열로 쓸수있다
		this.students = (T[])new Object[capacity];
	}
	
	public String getName() { return name; }
	public T[] getStudents() { return students; }
	
	public void add(T t){
		for(int i=0; i<students.length; i++){
			if(students[i] == null){
				students[i] = t;
				break;
			}
		}
	}
}
