
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix (rows then cols): ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        System.out.println("Enter matrix A:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                b[i][j] = sc.nextInt();
            }
        }
        System.out.println("Your Sum Matrix is: ");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j] + b[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
