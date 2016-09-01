package ch10.exam03;

public class BalanceInsufficientException extends RuntimeException{
	public BalanceInsufficientException(){
		
	}
	
	BalanceInsufficientException(String message){
		super(message);
	}
	
}
