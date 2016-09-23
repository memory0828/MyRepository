package ch18.exam03;

import java.io.*;
public class CopyExample {
	//카피 프로그램
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("pic.gif"); //pic.gif파일은 이미 존재해야함
		OutputStream os = new FileOutputStream("pic2.gif");
		byte[] values = new byte[1024];
		int byteNum = -1;
		
		while( (byteNum = is.read(values)) != -1)  {
			//byteNum이 들어가는 이유는
			//마지막 끝에 데이터는 공백이 남기때문에 잃어들인 데이터 갯수만큼만 처리하도록
			os.write(values, 0, byteNum); 
		}
		is.close();
		
		os.flush();
		os.close();
	}
}
