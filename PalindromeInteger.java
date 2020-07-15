
import java.util.Scanner;
public class PalindromeInteger {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int reverseIt = 0;
        while(temp != 0){
            reverseIt = reverseIt*10 + (temp%10);
            temp = temp/10;
        }
        if(reverseIt == n)System.out.println("Palindrome Number!!!");
        else System.out.println("Better luck next time"); 
    }
}
