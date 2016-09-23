package ch18.exam09;

import java.io.File;
public class FileExample3 {
	public static void main(String[] args) throws Exception {
		File root = new File("C:/");
		File[] contents = root.listFiles();
		
		for(File file : contents){
			if( file.isDirectory() ) {
				System.out.print("<DIR>\t");
			}else{
				// file.length(); 파일크기을 알아냄 <- ★★★이거 잘 기억해라 많이 쓴다.				
				System.out.print(file.length() + "\t\t");
			}
			System.out.println(file.getName() );
		}
	}
}
