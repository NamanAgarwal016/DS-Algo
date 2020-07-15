
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
public class Pattern1 {
   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println("* ");
        
        for(int i=1; i<=n-2; i++){
            System.out.print("* ");
            for(int j=1; j<=i-1; j++){
                System.out.print("  ");
            }
            System.out.print("* ");
            System.out.println("");
        }
        
        if(n>1){for(int i=1; i<=n; i++){
            System.out.print("* ");
        }}
    }
}
    

