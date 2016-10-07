package ThisisJAVA.ch11.sec11_Arrays;

import java.util.Arrays;

public class Arrays01ArrayCopyExample {
	public static void main(String[] args) {
		char[] arr1 = {'J', 'A', 'V', 'A'};
		
		//방법1
		//                                 원본  복사길이
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		//방법2
		//                                      원본  시작인덱스(포함됨)  끝인덱스(포함안됨)
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr3));		
		
		//방법3
		char[] arr4 = new char[arr1.length];
		//                   원본 원본시작인덱스  타켓 타겟시작인덱스  복사개수
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for(int i=0; i<arr4.length; i++) {
			System.out.println("arr4[" + i + "]=" + arr4[i]);
		}
	}
}

