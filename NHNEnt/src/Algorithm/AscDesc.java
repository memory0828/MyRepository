package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AscDesc {

    public static void main(String[] args) {
    
		Integer[] names = { 1, 2, 3, 9, 0, 100,200 };
		List<Integer> list = Arrays.asList(names);
		//오름차순
		//Collections.sort(list); 

		//내림차순
		Collections.sort(list);
		Collections.reverse(list);
		
		for(int t : list){
			System.out.print(t + " ");
		}
		
		System.out.println();
		Iterator it = list.iterator();
		while(it.hasNext()){
			int t2 = (int)it.next(); 
			System.out.print(t2 + " ");
		}
		
		/////////////////////////////////////////////////////////////////////////
		System.out.println();
		Integer[] arr = {4, 23, 12, 16, 91, 59, 73, 28, 33, 41,0,100};
		List<Integer> list2 = new ArrayList(Arrays.asList(arr));
		//오름차순
		//Collections.sort(list2);
		
		//내림차순
		Collections.sort(list2);
		Collections.reverse(list2);
		//System.out.println(list2.get(2)); 
		for(int i=0; i<list2.size(); i++){
			System.out.print(list2.get(i) + "/ ");
		}
    }
}
