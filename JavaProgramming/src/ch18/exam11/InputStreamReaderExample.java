package ch18.exam11;

import java.io.*;
public class InputStreamReaderExample {
	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		/*
		char d2 = (char)is.read();
		System.out.println(d2);
		*/ 
		//기존 방식대로 하면
		//위처럼하면 영어같은건 잘디지만 한국어 "가"같은거 입력하면 글씨가 깨짐
		//왜? 한국어는 2바이트인데 read()는 1바이트만 읽어서 넘기기 때문이다.
		//그래서
		/*
		byte[] values = new byte[100];
		int byteNum = is.read(values);
		String d3 = new String(values, 0, byteNum -2);
		System.out.println(d3);
		*/
		//위처럼 해야 되는데, 소스가 참......
		//그래서 아래 보조스트림이 필요

		//InputStream을 리더로 바꿔주는 보조!
		Reader rd = new InputStreamReader(is);
		char data = (char) rd.read();
		System.out.println(data);

	}
}
