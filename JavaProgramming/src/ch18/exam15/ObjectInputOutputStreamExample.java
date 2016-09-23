package ch18.exam15;

import java.io.*;
public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		//1.객체 직렬화
		FileOutputStream fos = new FileOutputStream("data.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Member member = new Member("angel", "김천사", "12345", 26);
		oos.writeObject(member);
		oos.flush();
		oos.close();
		fos.close();
		
		//1.객체 역직렬화(복원)
		FileInputStream fis = new FileInputStream("data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Member member2 = (Member)ois.readObject();
		fis.close();
		ois.close();
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMage());

		System.out.println(member2.getMpassword()); //이건 transient로 지정되어 있어서 복원안됨(null나옴)

		System.out.println(member2.getmnation()); // 이건 한국이 나오지만 static로 저장되어있는거 나오는거지 
															  // 직렬화했던걸 역직렬화해서 복원으로 나오는 데이터가 아님
		System.out.println(Member.getmnation());  // 즉, 이거와 같음
	}
}
