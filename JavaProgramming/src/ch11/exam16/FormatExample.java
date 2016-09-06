package ch11.exam16;

import java.text.DecimalFormat;
public class FormatExample {
	public static void main(String[] args) {
		double value = 123456789.12345;
		DecimalFormat df = new DecimalFormat("\u00A4 #,###.00");
		System.out.println(df.format(value));
	}
}
