package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		//1. 어떤 JDBC Driver를 사용할 것인가(JDBC Driver 로딩)
		Class.forName("oracle.jdbc.OracleDriver"); //JDBC드라이버를 구동해주는 역할!
		//Class.forName("oracle.jdbc.driver.OracleDriver"); 옛날에 사용하던 경로~ 위에꺼랑 똑같은거임
		
		//2. 연결 요청을 해서 연결 객체를 얻기
		//java.sql 에 있는 DriverManager 클래스~ 
		/*어떤 DBMS를 사용하냐에 따라 다르게 메소드를 사용해야하는데 보통 1, 3번을 많이씀
		1번 static Connection	getConnection(String url)							url안에 ip,port,db명,계정,비밀번호 이 5가지 정보가 들어가있을때
		2번 static Connection	getConnection(String url, Properties info)		url(ip,port,db명)과 Properties 파일에 나머지 정보가 있을떄
		3번 static Connection	getConnection(String url, String user, String password)		url(ip,port,db명), 나머지 user, pass 입력
		3번을 오라클에서 쓰기 제일 좋음
		이 String url 안에 들어가는 문자열 형식은 DBMS마다 다르니깐 각 DBMS 공식홈에서 관련 정보를 찾아봐야함
		예) 구글에서 oracle jdbc connection url
			 1. 위 1번의 3개의 정보가 들어가 있는 url 방식
			 Connection conn = DriverManager.getConnection
  			 ("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");
  			
  			 3. 위 3번의 다섯개의 정보가 다들어가있는 url 방식
  			 Connection conn = DriverManager.getConnection
   			("jdbc:oracle:thin:scott/tiger@myhost:1521:orcl);
		*/
		Connection conn = DriverManager.getConnection
								  ("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345"); //1번방식으로 쓰자
		//Connection은 인터페이스
		/*어떤 JDBC를 쓰냐에 따라
		Class.forName("oracle.jdbc.OracleDriver");
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		이 두가지만 달라진다 나머지 밑에 내용은 다 똑같음
		*/
		
		//3. SQL문을 보내고 실행시킴
		PreparedStatement pstmt= conn.prepareStatement("select * from emp"); 		//실행할 준비가 완료되면 PreparedStatement pstmt 가 얻어진다
		ResultSet rs = pstmt.executeQuery(); 		//결과셋얻기
		
		//4. 결과셋에서 한 행씩 읽기
		while(rs.next()){ //next()는 커서를 이동했는데 그 이동한곳에 데이터가 있으면 true 없으면 false
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			System.out.println("empno" + ":" + ename);
		}
		
		//5. JDBC 관련 객체 닫기(메모리 리소스 해체)
		//안쓰는것들 닫아서 메모리 관리하기~
		rs.close();
		pstmt.close();
		conn.close();
	}
}
