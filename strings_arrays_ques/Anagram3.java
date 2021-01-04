package strings_arrays_ques;

// more optimized mtd havind time complexity= O(nlogn)
// comparing the number of occurences of a character
public class Anagram3 {

    public static void main(String[] args) {
        String a = "aab @# 12 34";
        String b = "#3214   @aba";
        
        boolean isAnagram = true;
        
        int[] al = new int[256]; // total no. of characters universal = 256, assuming each position in this aaray is
     //   int[] bl = new int[256];//assigned to a char..whichever found in string ..will be increased by 1
        
        for(char c: a.toCharArray()){ //using for-each loop to convert a into char array then increasing the index
            int index = (int)c; //corresponding to ascii value of that char by 1.....increasing frequency of char
            al[index]++;
        }
        for(char c: b.toCharArray()){ 
            int index = (int)c;    // for each character in b we will do decrement
            al[index]--;           // the frequency at that corresponding index
        }
        
        for(int i=0; i<256; i++){  //checking if all positions are 0..if not then not anagram
            if(al[i] != 0){
                isAnagram = false;
                break;
            }
        }
        
        if(isAnagram) System.out.println("Yes they are Anagram");
        else System.out.println("Noo..they are not Anagrams");
    }
}
