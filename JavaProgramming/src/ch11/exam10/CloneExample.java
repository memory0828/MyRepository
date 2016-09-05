package ch11.exam10;

import java.util.Arrays;
public class CloneExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		int[] arr1 = {1,2,3};
		int[] arr2 = arr1.clone(); //clone는 Object클래스가 가진 매소드로 객체를 복사한다 
		System.out.println(arr1 == arr2); //false - 서로 다른 객체
		System.out.println(Arrays.equals(arr1, arr2)); //true - 똑같은 데이터니깐
		
		Member m1 = new Member("hong", "길동");
		/*1-1.
		 *m1.clone() <- 이거 지금 못씀. 왜냐 main메소드가 static라서, 또 clone이 프로텍티드라............. ㅎㅎㅎㅎ 알듯말듯
		 *clone이 프로텍티드로 되어있는 이유는 clone을 통한 복제가 기본적으로 public로 되어있다면, 언제든 복제가 가능한데
		 *그럴경우에는 그 클래스가 중요한 정보를 가지고있을땐 문제가 생기니깐. 기본인 프로텍티드로 정의되어있어
		 *재정의를 따로 안하는이상 외부에서 복제를 못하도록 만든다. 하지만 복제가 필요한경우에는 아래처럼 재정의를 하면됨
		 *즉,그래서 이소스에서는 복제가 가능해야하니
		 *m1의 모체클래스인 Member에서 clone를 접근제한자를 public로 바꾸며 재정의를 하고 
		 */
		
		/*2-1. 
		 *Member에 implements Cloneable(->이건 아무내용없는 인터페이스인데, JVM에게 이 클래스는 
		 *복제해도 좋아 내용을 전달하는 역활이당)을 달아주니
		 *그래서 "야 JVM이거 복제혀용해주자~ 로 JVM에게 전달하는 형태로 사용하는 것
		 */
		
		//3-1
		Member m2 = (Member)m1.clone(); //이렇게 사용가능해졌으며, clone의반환형은 Object임으로 이렇게 강제형변환해준다.
		//그래서 m1을 복사해서 m2를 만들었다.
		System.out.println(m1 == m2); //false - 서로 다른 객체니깐
		System.out.println(m1.equals(m2) ); //false - Object클래스를 상속받았아서 equals를 사용가능하나, 
																//재정의 안하는 이상 기본적으론 ==연산과 같으니, 서로다른객체니깐
		System.out.println(m1.toString().equals(m2.toString()) ); //true - 이건 toString명시했고, 복재한거라 값이 같으니깐~
		/*근데 Object의 clone는 기본적으로 얕은 복제니깐
		 * 필드중
		 * int age;는 기본형이라 m1 m2가 각각 가지고 있지만  
		 * String mid; String mname; String[] hobbys; 는 참조형임으로 동일한 메모리 번지를 가르킨다. 
		 * 이걸 방지하기 위해서는 깊은 복제를 해야하는데, 수업시간엔 다루지 않았다 
		 */
				
		/*4. 얕은 복제 VS 깊은 복제 p466~p469
		 * 얕은복제 : 단순히 필드 값만 복제(참조 타입 필드는 공유) = 값은 복제하는데 참조타입은 그 참조내용을 복사한다
		 * 깊은복제 : 필드값과 참조하고있는 객체도 복제 = 값도 복제하고 참조타입은 그 내용에 가서 내용을 복사한다.
		 */

	}
}
/*(참고)
*같은 파일임~ 그리고 파일이름과 다른 클래스앞에는 public를 붙일수없고, 컴파일하면 class파일이 두개 생긴다
*또 한파일안에 클래스가 두개있다고 연개되냐? 아니다 개별이다. 근데 보통 한파일에 같이 class을 작성하는 경우는
*기본서 책에나 있지 실무에서는 없다. ㅇㅋ?
 */
class Member implements Cloneable{ // 2-2 implements Cloneable 이걸달아야 클론을 사용할수있다(없으면 에러남) 
		String mid;
		String mname;
		int age;
		String[] hobbys;
		
		Member(String mid, String mname) {
			this.mid = mid;
			this.mname = mname;
		}
		
		@Override
		public String toString() {
			return mid + ":" + mname;
		}
		
		//1-2 clone 재정의
		@Override //protected->pubilc로 바꾸면서 재정의함(접근제한자는 더 큰놈으로는 재정의 가능하니깐~)
		public Object clone() throws CloneNotSupportedException {
			return super.clone(); //여기서 실제로 복제가 됨
		}
}
