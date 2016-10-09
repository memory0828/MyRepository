import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CharacterSequence {
    public static void main(String[] args) {
        String[] words = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int mo2Cnt = 0;
        int ja3Cnt = 0;
        for(int i=0; i<words.length; i++){
    		int moCnt=1;
    		int jaCnt=1;
 
        	for(int k=1; k<words[i].length(); k++){
        		char charWord1 = words[i].charAt(k-1);
        		char charWord2 = words[i].charAt(k);
        		char charWord3 = 'a';
        		if( k<(words[i].length()-1) ){ 
        			charWord3 = words[i].charAt(k+1);
        		}
        		if ( charWord1 == 'a' || charWord1 == 'e' || charWord1 == 'i' || charWord1 == 'o' || charWord1 == 'i'){
        			if ( charWord2 == 'a' || charWord2 == 'e' || charWord2 == 'i' || charWord2 == 'o' || charWord2 == 'i'){
        				moCnt=2;
        			}
        		}else{
        			if ( charWord2 != 'a' && charWord2 != 'e' && charWord2 != 'i' && charWord2 != 'o' && charWord2 != 'i'){
        				if ( charWord3 != 'a' && charWord3 != 'e' && charWord3 != 'i' && charWord3 != 'o' && charWord3 != 'i'){
        					jaCnt=3;
        				}
        			}
        		}
        	}
        	if(moCnt == 2) mo2Cnt++;
        	if(jaCnt == 3) ja3Cnt++;
        }
		System.out.println(mo2Cnt);
		System.out.println(ja3Cnt);

    }
}