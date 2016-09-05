package ch11.exam10;

import java.util.Arrays;

public class ArrayCopyExample {
	public static void main(String[] args) {
		char[] arr1 = {'J', 'A', 'V', 'A'};

		//배열복사 방법1
		char[] arr2 = new char[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println(Arrays.toString(arr2));  //★Arrays.toString 배열내용 리턴함
		
		//배열복사 방법2
		char[] arr3 = new char[arr1.length];
		//★System.arraycopy(복사할 배열, 복사할배열시작인덱스, 대상이될 배열, 대상이될배열의시작인덱스)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);	
		System.out.println(Arrays.toString(arr3));
		
		//배열복사 방법3
		char[] arr4 = Arrays.copyOf(arr1, arr1.length); //Arrays.copyOf : 쉬운 배열복사 
		System.out.println(Arrays.toString(arr4));		


	}
}
