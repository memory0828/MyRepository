package ThisisJAVA.ch11.sec11_Arrays;

public class Arrays03_Member implements Comparable<Arrays03_Member> {
	String name;
	Arrays03_Member(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Arrays03_Member o) {
		return name.compareTo(o.name);
	}
}
