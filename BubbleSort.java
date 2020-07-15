 // Fully optimized Bubble Sort

public class BubbleSort {
    public static void main(String[] args) {
        
//        System.out.println("No. of elements in your array: ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        
//        System.out.println("Enter elements in your array: ");
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
int[] arr = {-1, 8, 0, -100, 6};
int n = arr.length;

        boolean isSwapped ; // optimization1.. checks already sorted array in each iteration
        int count = 0;
        
        for (int k = 0; k < n-1; k++) {  // number of iteration to sort any array = no. of elements
            // with every iteration biggest element comes to end...sorting from backward
            // max no. of iterations needed to sort = n-1
            // Code for sorting by swapping larger with smaller.
            isSwapped = false;
            for (int i = 0; i < n-1-k ; i++) {  
// optimization2..cond (n-1-i)...using the fact that largest no. comes to last..
// therefore decrease inner loop iterations ...run the loop less no. of times                  
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSwapped = true; // Entering in IF cond mearr its not sorted
                }
            }
            if(isSwapped == false) break;
            else count++;
        }
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println("\nNo. of iteration used to sort = " + count);
    }
}
