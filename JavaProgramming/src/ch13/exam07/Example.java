package ch13.exam07;

public class Example {
	public static void main(String[] args) {
		int r1 = Util.compare(10, 20); //( )안의 내용은 자동박싱되는거알징? 
		int r2 = Util.compare(10, 20.5); //( )안의 내용은 자동박싱되는거알징?
		int r3 = Util.compare(new Integer(10), 20.5);
	}
}
