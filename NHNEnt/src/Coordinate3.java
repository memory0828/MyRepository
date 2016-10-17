import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Coordinate3 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

		//정렬
		Collections.sort(numberList);
		
	
        //가장큰수만들기
/*		double data[] = new double[numberList.size()];
        for(int i=0; i< numberList.size(); i++){
        	if (numberList.get(i)>=10){
        		data[i] = numberList.get(i) / 10.0;
        		System.out.println(data[i]);
        	}else{
        		data[i] = (double)numberList.get(i) ; 
        		System.out.println(data[i]);
        	}
        }*/
		String data[] = new String[numberList.size()];
        for(int i=0; i< numberList.size(); i++){
        	data[i] = String.valueOf(numberList.get(i)) ; 
        }
        
        Arrays.sort(data);
        
        //가장작은수만들기
        String strMin = "";
        for(int i=0; i< data.length; i++){
    		strMin += data[i];
        }

        List<String> list = Arrays.asList(data);
        Collections.sort(list);
		Collections.reverse(list);
        String strMax = "";
        for(int i=0; i< list.size(); i++){
    		strMax = strMax + list.get(i);
    	}        
        
        //두수의 합
        System.out.println(Integer.parseInt(strMin) +Integer.parseInt(strMax)) ;
        
        
        
        
        
        

    }
}