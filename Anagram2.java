//--- this is official solution of anagram problem with time complexity = O(n^2) ("big O of n square")(n=length of array)
// it is not optimized solution as it takes more time bcoz of nesting of for loops
public class Anagram2 {

    public static void main(String[] args) {
        String a = "aab";
        String b =  "abc";
        
        boolean isAnagram = false;
        
        boolean visited[] = new boolean[b.length()];  //it defines situation for repeating characters in a + accounts for 
                                      //elements in b which has been already visited and do not consider it further...
        if(a.length() == b.length()) {      //check of length
            
            for(int i=0; i<a.length(); i++){   // checking one element of a in entire b array
                char c = a.charAt(i);          
                isAnagram = false;
                for(int j=0; j<b.length(); j++){   // iterating in entire b array
                    if(b.charAt(j) == c && !visited[j]){  // check if this index position non-visited
                        visited[j] = true;  // make its visited true
                        isAnagram = true;
                        break;
                    }
                }
                if(!isAnagram) break;  //if any single letter is not found then immediately move out of outer loop
            }                          // and declare "not anagram"
        }
        
        if(isAnagram) System.out.println("Yes they are Anagram");
        else System.out.println("Noo..they are not Anagrams");
    }
}

// for optimization: first sort the strings, then compare sorted strings. Java has built-in mtd for sorting of strings
// other opt. mtd(quick sort, merge sort..etc) has time complexity = big O of n log n... O(nlogn)