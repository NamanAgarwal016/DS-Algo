
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naman
 */
public class WhileLoops{ 
    //Sum of digits
    public static void main(String[] args){
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
           sum+=n%10;
            n/=10;
        }
        System.out.println(sum);
    }
    
}
