
import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.println("Enter any number");
            n = sc.nextInt();
        }while(n != 0);
        System.out.println("Out of Loop.  yeah!!!");
    }
}
