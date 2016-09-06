package ch11.exam15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date; //import할떄 여러군대 뜨는데, 여기 선생님께서 선택함
public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1); //해외 날자형식으로 나옴
		
		//날짜형식 지정하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); 
		String strNow2 = sdf.format(now);
		System.out.println(strNow2); //한국 날짜형식으로 나옴
		
		//Calendar cal = new Calendar(); 이거 안됨. Calendar는 추상메소드이라서 생성자접근못함. 그래서 
		Calendar cal = Calendar.getInstance(); //이렇게처리함
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; //0~11까지 리턴받기 때문에 +1을 더해줘야됨
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int amPm = cal.get(Calendar.AM_PM); //오전0 오후1
		int week = cal.get(Calendar.DAY_OF_WEEK);
	}
}

