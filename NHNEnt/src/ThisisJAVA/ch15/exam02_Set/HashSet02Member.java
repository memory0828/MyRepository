package ThisisJAVA.ch15.exam02_Set;

public class HashSet02Member {
	private String name;
	private int age;
	
	public HashSet02Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		//해쉬코드 재정의
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		//equals 재정의
		if(obj instanceof HashSet02Member){
			HashSet02Member target = (HashSet02Member)obj;
			if(name.equals(target.name) && age == target.age ) {
				return true;
			}else{
				return false;				
			}
		}else{
			return false;
		}
	}
}
