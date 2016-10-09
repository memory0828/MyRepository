package helloworld;
/*어떤 수 N(1≤N≤1,000,000) 이 주어졌을 때, N의 다음 큰 숫자는 다음과 같습니다.

N의 다음 큰 숫자는 N을 2진수로 바꾸었을 때의 1의 개수와 같은 개수로 이루어진 수입니다.
1번째 조건을 만족하는 숫자들 중 N보다 큰 수 중에서 가장 작은 숫자를 찾아야 합니다.
예를 들어, 78을 2진수로 바꾸면 1001110 이며, 78의 다음 큰 숫자는 83으로 2진수는 1010011 입니다.
N이 주어질 때, N의 다음 큰 숫자를 찾는 nextBigNumber 함수를 완성하세요.
*/
///////////////////////////////////
//		다음 큰숫자
///////////////////////////////////
class TryHelloWorld_L3_01
{
    public int nextBigNumber(int n)
    {
        int answer = 0;
      	int no1Ncnt=0;
      	
		String t1 = Integer.toBinaryString(n); //2진수
		for( int i=0; i<t1.length(); i++){
			if( t1.substring(i, i+1).equals("1") ) no1Ncnt++;
		}
		System.out.println(t1);
		System.out.println(no1Ncnt);

      	for (int k=n+1; k<=1000000; k++){
      		String temp = Integer.toBinaryString(k); //2진수
      		int no1Targetcnt = 0;
    		for( int i=0; i<temp.length(); i++){
    			if( temp.substring(i, i+1).equals("1") ) no1Targetcnt++;
    		}
    		if( no1Ncnt == no1Targetcnt ){
    			answer = k;
    			break;
    		}
        }
        return answer;
    }
    public static void main(String[] args)
    {
        TryHelloWorld_L3_01 test = new TryHelloWorld_L3_01();
        int n = 78;
        System.out.println(test.nextBigNumber(n));
    }
}