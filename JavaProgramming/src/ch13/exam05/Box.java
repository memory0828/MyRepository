package ch13.exam05;

public class Box<T> {
	private T t;
	public T get() {
		return this.t;
	}
	public void set(T t) {
		this.t = t;
	}
}
