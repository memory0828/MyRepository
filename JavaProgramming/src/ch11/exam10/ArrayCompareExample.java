package ch11.exam10;

import java.util.Arrays;
public class ArrayCompareExample {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		System.out.println(arr1 == arr2); //false - 서로 다른배열 
		System.out.println(Arrays.equals(arr1, arr2)); //true - 배열끼리 값비교 : 서로 다른 배열일지라도 항목이 같으면 true 리턴
		int[] arr3 = {1,2,3};
		int[] arr4 = arr3;
		System.out.println(arr3 == arr4); //true - 서로 같은배열 
		System.out.println(Arrays.equals(arr3, arr4)); //true - 얕은 복제비교 : 배열끼리 값비교. 같은 참조영역의 배열일지라도 항목이 같으니 true리턴
		
		int[][] arr5 = { {1,2},{3,4} };
		int[][] arr6 = { {1,2},{3,4} };
		//p523 그림 참고
		System.out.println(arr5 == arr6); //false - 서로 다른배열 
		System.out.println(Arrays.equals(arr5, arr6)); //false??? -  얕은 복제비교 : 배열끼리 값비교인데, 1차원까지만 비교한다
		//위 두배열은 2차원인데 1차원만 두고 봤을 때 1차원 각각에는 참조번지가 들어가있다. 당연히 값이 틀릴수밖에없지
		//그럼 2차원안에 내용을 비교하는 방법은 없을깡? 있징 ㅋㅋ
		System.out.println(Arrays.deepEquals(arr5, arr6)); //true - 우오~~~ 깊은 복제비교		
	}
}
