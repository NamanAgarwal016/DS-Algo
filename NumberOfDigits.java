
import java.util.Scanner;


/**
 *
 * @author Naman
 */
public class NumberOfDigits {
    // To find no. of digits in number N = log(N) + 1 (here base of log is 10)
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numberOfDigits = (int)Math.log10(n) + 1;
        System.out.println(numberOfDigits);
    }
}    

