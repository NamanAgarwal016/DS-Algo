package strings_arrays_ques;


import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a program for matrix multiplication.");
        System.out.println("Enter size of matrix A(rows * cols): ");
        int rowA = sc.nextInt();
        int colA = sc.nextInt();
        System.out.println("Enter size of matrix B(rows * cols): ");
        int rowB = sc.nextInt();
        int colB = sc.nextInt();
        if (colA != rowB) {
            System.out.println("Invalid matrix multiplication");
        } else {
            int[][] a = new int[rowA][colA];
            int[][] b = new int[rowB][colB];
            int[][] product = new int[rowA][colB];
            System.out.println("Enter matrix A:");
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.println("Enter matrix B:");
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            System.out.println("Your Product Matrix is: ");
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colB; j++) {
                    for (int k = 0; k < colA; k++) {
                        product[i][j] = product[i][j] + a[i][k] * b[k][j];
                    }
                    System.out.print(product[i][j] + "\t");
                }
                System.out.println("");
            }
        }

    }
}
