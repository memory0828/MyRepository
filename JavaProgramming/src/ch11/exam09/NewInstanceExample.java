package ch11.exam09;

public class NewInstanceExample {
	//이 예제에서 원래대로면 main뒤에 throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	//가 붙어야하는데, 간편하게 Exception으로 끝낼수있다. 결국 모든 예외는 Exception로 처리할수있으니깐 
	public static void main(String[] args) throws Exception {
		//args로 들어올건 SendAction, ReceiveAction 이다 이건 Action인터페이스 구현 클래스
		Class clazz = Class.forName("ch11.exam09." + args[0]); //"ch11.exam09."이건 나중에 인수넘어올때 앞에 붙어야하는거 미리 써놓은거임 
		//clazz.newInstance(); 하면 args[0]에 들어온걸로 기본생성자를 호출해 객체를 만들어준다.
		//그리고 이 상황에서는 오로지 기본생성자만 호출할수있는데, 다른생성자를 호출하려면 리플랙션을 사용해야한다
		Object obj = clazz.newInstance();	
		Action action = (Action)obj; //Action은 인터페이스. 이 인터페이스로 캐스팅하고
		//위 소스는 이 소스와 동일 Action a = (Action) clazz.newInstance();
		
		action.execute(); //이걸통해 구현 객체의 메소드를 실행한다		
		//그러나 이 소스는 보완해야할 부분이 두가지있다. 일단 인수값이 많을때와,
		//Action 인터페이스로 구현된 클래스가 넘어오지 않을경우다.
		//이 예제를 통해서 왜 인터페이스가 객체 사용방법을 통일한다는 개념 이해했다.
	}
}
