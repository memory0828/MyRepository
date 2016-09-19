package ch15.exam04;

import java.io.*;
import java.util.*;
public class PropertiesExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//현재 시스템 언어 설정 알아내기
		Locale cLocal = Locale.getDefault();
		System.out.println(cLocal);
		
		String path = null;
		if(cLocal == Locale.KOREA) {
			//한국어
			path = PropertiesExample.class.getResource("ko.properties").getPath();
		}else if( cLocal == Locale.US){
			//미국어
			path = PropertiesExample.class.getResource("en.properties").getPath();
		}
		
		Properties ppt = new Properties();
		ppt.load(new FileReader(path));
		System.out.println( ppt.getProperty("apptitle") );
		System.out.println( ppt.getProperty("btnJoin") );
		System.out.println( ppt.getProperty("btnLogin") );
		System.out.println( ppt.getProperty("btnCancel") );
	}
}
