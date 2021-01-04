package strings_arrays_ques;

public class Arrays {
    public static void main(String[] args){
        // datatype[] arrayName = new datatype[n]
        int[] arr;
        arr = new int[6];
        arr = new int[2];    // now length of arr becomes 2 `   
        
        int[] rollNos, classNos; // Here both are arrays
        int rollNo[], classNo;   // Here one is array, other is int variable
        
//        char arr1[] = new char[5];
//        System.out.println(arr1[5]); // it will give index out of bound exception, a RUN-TIME ERROR
//        
        double[] arr2 = {1,20.0,25,28.5}; // direct declaration & initialization, no need of length
        for(int i = 0; i < arr2.length; i++){   // arrayName.length is a field in arrays
            System.out.println(arr2[i]);
        }
    }
}
