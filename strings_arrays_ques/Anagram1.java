package strings_arrays_ques;

// This is my approach to Anagram problem..not optimized..time complexity = big of n square..bubble/selection sort not 
// much efficient methods.
import java.util.Scanner;
public class Anagram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter two strings to check for anagrams: ");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        if(str1.length() != str2.length()) System.out.println("kam se kam length toh same daal..huhhh:( ");
        else{
            int length = str1.length();
            
            char[] arr1 = str1.toCharArray();   //convert string into character array
            char[] arr2 = str2.toCharArray();   
            
            int[] a1 = new int[length];  // for converting char array into ascii value array
            int[] a2 = new int[length];
            for(int i=0; i<length; i++){
                a1[i] = (int)arr1[i];    // converting char to its ascii value
                System.out.print(a1[i] + " ");
            }
            System.out.println("");
            for(int i=0; i<length; i++){
                a2[i] = (int)arr2[i];
                System.out.print(a2[i]+ " ");
            }
            System.out.println("");
            
            // applying selection sort to both a1 & a2 array to arrange them in increasing array
            for(int i=0; i<length-1; i++){
            int minIndex = i;   // Always searching only in the remaining unsorted array
            for(int j=i; j<length; j++){   //Searching for index which has smallest element
                if(a1[minIndex] > a1[j]) minIndex = j;
            }   //now smallest number's index got stored in minIndex.. now swapp
            int temp = a1[i];
            a1[i] = a1[minIndex];
            a1[minIndex] = temp; 
            }
            for(int item: a1) System.out.print(item + " ");
            System.out.println("");
            
            for(int i=0; i<length-1; i++){
            int minIndex = i;   // Always searching only in the remaining unsorted array
            for(int j=i; j<length; j++){   //Searching for index which has smallest element
                if(a2[minIndex] > a2[j]) minIndex = j;
            }   //now smallest number's index got stored in minIndex.. now swapp
            int temp = a2[i];
            a2[i] = a2[minIndex];
            a2[minIndex] = temp; 
            }
            for(int item: a2) System.out.print(item + " ");
            System.out.println("");
            
            
            boolean isAnagram = true;
            for(int i=0; i<length; i++){   // if both sorted arrays are exactly equal then only they are anagrams
                if(a1[i] != a2[i]){
                    isAnagram = false;
                    break;
                }
            }
            if(isAnagram) System.out.println("\nYESSSSSS....they are anagrams");
            else System.out.println("\nNooooo...they are not anagrams");
            
        }
    }
}
