
import java.util.Scanner;
public class StringReverseByWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String ans = "";
        int i = a.length() - 1;
        
        while(i >= 0){
            while(i >= 0 && a.charAt(i) == ' ') i-- ;   // for eliminating last spaces of word
            int j = i;                                  // setting j at one end of word
            
            if(i<0) break; //when sentence has trailing whitespaces at starting then i will go -1, if that happens we have
                         // to stop the loop ; if not code this then one whitespace will come. 
            while(i >= 0 && a.charAt(i) != ' ') i-- ;   // moving i at starting of word 
            if(ans.isEmpty()){                          
                ans = ans.concat(a.substring(i+1, j+1));  // extracting that word and putting in ans.
            }
            else{
                ans = ans.concat(" " + a.substring(i+1, j+1));
            }
        }
        
        System.out.println(ans);
        
    }
}
