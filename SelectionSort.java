// SelectionSort is Superior to BubbleSort..as less number of swapps are there

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-1, 8, 0, -100, 6};
        int n = arr.length;
        
        for(int i=0; i<n-1; i++){
            int minIndex = i;   // Always searching only in the remaining unsorted array
            for(int j=i; j<n; j++){   //Searching for index which has smallest element
                if(arr[minIndex] > arr[j]) minIndex = j;
            }   //now smallest number's index got stored in minIndex.. now swapp
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp; 
        }
        for(int item: arr) System.out.print(item + " ");
    }    
}
