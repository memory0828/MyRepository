package ch18.exam05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class WriterExample {
	public static void main(String[] args) throws Exception {
		Writer wt = new FileWriter("data.txt");
		String data = "날씨 좋음!";
		
		//주요메소드4. 방법
		wt.write(data);
		
		wt.flush();
		wt.close();
	}
}
