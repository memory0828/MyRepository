package ch02.exam02;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long v1 = 100;
		int v2 = (int)v1;
		System.out.println("v2:" + v2);
		
		byte v3 = (byte)v1;
		System.out.println("v3:" + v3);
		
		char v5 = 'A';
		int v6 ='A';
		int v7 ='한';
		System.out.println("v5:" + v5);
		System.out.println("v6:" + v6);
		System.out.println("v7:" + v7);
		
		byte v8 = 65;
		char v9 = 54620;
		System.out.println("v9:" + v9);
	}

}
