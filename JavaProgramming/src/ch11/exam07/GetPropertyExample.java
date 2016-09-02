package ch11.exam07;
import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		
		String userName = System.getProperty("user.name");
		System.out.println(userName);
		
		String userHome = System.getProperty("user.home");
		System.out.println(userHome);
		
		//그럼 저 ("~~~")안에 들어가는 것들(=키이름)은 어떻게 알수있을까? 조사하면되지
		Properties props = System.getProperties();
		Set keys = props.keySet(); 
		for(Object objKeys : keys){
			//위의 keySet 안의 내용들은 String 타입이다. 그값을 받은게 keys니깐
			String key = (String)objKeys; //그래서 이렇게 강제형변환 캐스팅이 된다

			//System.getProperty의 전체내용 출력코드
			//즉, 내용들이 출력됨으로 이걸 통해 조사됨!
			System.out.print(key); //키이름과 와
			System.out.print(" : ");
			String value = System.getProperty(key);
			System.out.println(value); //그 키를 통해 알수있는 정보
		}
	}
}
