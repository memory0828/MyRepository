import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Coordinate {
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
		
		//두값씩 묶기
		int[][] data = new int[(numberList.size()/2)][4];
		int index=0;
		for(int i=0; i< data.length; i++){
			data[i][0] = numberList.get(index);
			index+=1;
			data[i][1] = numberList.get(index);
			index+=1;
			//두쌍의 거리
			data[i][2] = data[i][1] - data[i][0];
			//두쌍의 합
			data[i][3] = data[i][0] + data[i][1];
		}	
        //비교하기
		int selectIndex=0;
		for(int i=1; i < (data.length); i++){
			if( data[selectIndex][2] > data[i][2] ){ 
					selectIndex = i;
			}else if(data[selectIndex][2] == data[i][2]) {
				if(data[selectIndex][3] > data[i][3] ){
					selectIndex = i;
				}
			}
		}

		//결과 출력
		System.out.println(data[selectIndex][0] + " " + data[selectIndex][1]);

    }
}