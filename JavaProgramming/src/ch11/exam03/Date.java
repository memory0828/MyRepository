package ch11.exam03;

import java.util.Calendar;
public class Date {
	@Override
	public String toString() {
		Calendar now = Calendar.getInstance();
		int year = now.get( Calendar.YEAR );
		int month = now.get( Calendar.MONTH ) + 1; //0~11이 리턴되기때문에 +1
		int day = now.get( Calendar.DAY_OF_MONTH ); //그 월의 일
		return year + "-" + month + "-" + day; //0000-0-0 식으로 리턴됨
	}
}
