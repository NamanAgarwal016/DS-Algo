
import java.util.Scanner;


public class AverageMarksOfStudents {
    public static void main(String[] args){
        System.out.println("Good Morning Teacher!!!");
        System.out.println("Enter No. of Students in your class: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
           System.out.println("Enter marks of Student " + (i+1) + ":");
           marks[i] = sc.nextInt();
           sum+=marks[i]; 
        }
        System.out.println("Your class average is: " + (float)(sum/n));
    } 
}
