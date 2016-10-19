package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {
	private Connection conn;

	public void setConn(Connection conn) {
		//외부에서 커넥션을 받아서 이걸통해 저장함
		this.conn = conn;
	}
	
	public int update(Account account) throws SQLException{ //Dao에서는 반드시 이 throws로 예외처리하자
		String sql = "update account set abalance=? where ano=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		/*여기에서는 try catch를 하면안되고, throw를 써야한다.
		 *만약 이 메소드안에서 try catch로 예외를 다 잡아버리면 
		 *메인메소드가 있는 곳에서 롤백을 실행할 기회가 없다(이 Dao클래스를 가져다 쓰는게 main이잖아!)
		 *그래서
		 *★Dao설계시중의사항1. Dao를 만들어 사용할 떄는 절대 try/catch를 사용하면안된다.
		 *★Dao설계시중의사항2. Dao에 커넥션을 연결(만드는)하는 코드가 들어가면안된다.(안에 들어가있으면 예외가 그 메소드안에서 처리되서 트랜젝션 처리를 할수가없다)
		 *★Dao설계시중의사항3. 몇개의 행이 수행됬는지 호출하는 쪽에서 알수있도록 이렇게 리턴값을 돌려주도록 만든다.  
		 */
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		int rowNo = pstmt.executeUpdate();//이걸 처리한다음에 나온 실제처리된 행수를 리턴한다
		pstmt.close();
		return rowNo;		
	}
	
}
