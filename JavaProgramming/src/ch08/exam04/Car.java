package ch08.exam04;

public class Car {
	Tire[] t = { 
			new HankookTire(),
			new HankookTire(),
			new HankookTire(),
			new HankookTire()
			};
	
	/*Tire f_L = new HankookTire();
	Tire f_R = new HankookTire();
	Tire b_L = new HankookTire();
	Tire b_R = new HankookTire();
	*/
	void run(){
		for(int i=0; i<t.length;i++)
			t[i].roll();

	}
}
