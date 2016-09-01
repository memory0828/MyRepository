package ch10.exam03;

public class Account {
	private long balance;

	public long getBalance() {
		return balance;
	}

	public void deposit(int money){
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException {
		if(balance >= money){
			balance -= money;
		}else {
			//예외발생 상황(사용자 정의)
			throw new BalanceInsufficientException("자고부족");
		}
	}
}
