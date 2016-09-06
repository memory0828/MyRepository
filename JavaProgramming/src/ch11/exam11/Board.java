package ch11.exam11;

public class Board implements Comparable{
	private int bno;
	private String title;

	public Board(int bno, String title) {
		this.bno = bno;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + "]";
	}

	@Override
	public int compareTo(Object o) {
		Board b1 = (Board)o;
		return b1.bno - bno;
	}
}

