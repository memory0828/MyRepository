package Algorithm;

public class numMaxComonYakSu_MinComonBaeSu {

    public static void main(String[] args) {
    	//최대 공약수 구하기
    	int d1 = 280;
    	int d2 = 30;
    	
    	//한 수 의 약수 구하기
    	/*
    	for(int i=1; i<=d1; i++){
    		if(d1%i == 0){
    			System.out.print(i + " ");
    		}
    	}
    	*/
    	//두 수의 공약수 구하기 + //두 수의 최소공배수 구하기
    	int cmax = 0;
    	int d1mok = 0;
    	int d2mok = 0;    	
    	for(int i=1; i<=Math.min(d1, d2); i++){
    		if((d1%i == 0) && (d2%i ==0 )){
    			d1mok = d1/i; //몫
    			d2mok = d2/i; //몫
    			cmax = i;
    			System.out.print(i + " ");
    		}
    	}
    	System.out.println();
    	System.out.println(d1 + "와 " + d2 + "의 최대 공약수 : " + cmax);
    	System.out.println("최대공약수의 몫 : " + d1mok + "|" + d2mok);
    	
    	//두 수의 최소공배수 구하기
    	int cmin = 0;
    	cmin = cmax * d1mok * d2mok;
    	System.out.println();
    	System.out.println(d1 + "와 " + d2 + "의 최소 공배수 : " + cmin);
    	
    }
}
