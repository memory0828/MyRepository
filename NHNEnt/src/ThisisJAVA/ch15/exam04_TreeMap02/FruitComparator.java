package ThisisJAVA.ch15.exam04_TreeMap02;

import java.util.*;
public class FruitComparator implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.getPrice() - o2.getPrice();
	}

}
