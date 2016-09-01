package ch09.exam09;

public class Button {
	//클래스 안에 중첩 인터페이스
	public static interface OnClickListener {
		void onClick();
	}
	
	//필드 선언
	private OnClickListener onClickListener;
	//setter 메소드 하나 선언
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public void click(){
		if(onClickListener != null){ //위 필드의 값이 null이 아니면
			onClickListener.onClick();  
		}
	}
	//위임형~ 예외없음
}

