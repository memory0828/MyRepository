package ch13.exam03;

public class Product<T,M> { //제네릭타입이 2개일경우. 즉 타입파라미터 수에 맞춰서 표시해주면됨
	private T kind;
	private M model;
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
}
