package ch10.exam01;

public class Example2 {
	public static void main(String[] args){
		try{
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
		// }catch(Exception e) { } 여기다가 삽입하면 아래코드들이 도달할수없는 에러를 컴파일러가 알린다
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력된 수가 틀립니다");
		}catch(NumberFormatException e) {
			System.out.println("입력된 숫자가 아닙니다");
		}catch(Exception e) { //이렇게 삽입하면 에러가 없다. 그래서 순서를 생각해야한다
			System.out.println("전체 에러");
		}
	}
}
