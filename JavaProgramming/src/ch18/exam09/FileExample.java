package ch18.exam09;

import java.io.File;
public class FileExample {
	public static void main(String[] args) {
		File file = new File("C:/Temp/aaa"); //File클래스는 디렉토리도 될수있고 파일도 될수 있다.
		if(file.exists()){ //그래서 디렉토리인지 검사 
			if(file.isDirectory()){
				System.out.println("디렉토리가 존재함");
			}else{
				System.out.println("파일이 존재함");
			}
		}else{
			System.out.println("존재하지않음");
		}

		File dir = new File("C:/Temp/aaa/bbb/ccc");
		//디렉토리 만들기
		dir.mkdir(); //끝의 ccc 디렉토리만 만들기 때문에 앞에 있는 디렉토리인 Temp/aaa/bbb/는 다 존재해야함
		dir.mkdirs(); //이건 디렉토리인 Temp/aaa/bbb/가 없어도 ccc까지 그냥 만들어짐 
		
		//디렉토리 지우기
		//dir.delete(); //끝의 ccc 디렉토리만 지워짐
		


	}
}
