package strings_arrays_ques;

/* 
 * MUST MUST SEE: https://youtu.be/4jY57Ehc14Y
 */

public class KmpAlgorithm {
	public static void main(String args[]) {
		String txt = "onionionsplonionions";
		String pat = "onions";
		
		kmpAlgo(txt.toCharArray(), pat.toCharArray());
	}
	
	public static void kmpAlgo(char txt[], char pat[]) {
		int n = txt.length, m = pat.length;
		
		int lps[] = new int[m];
		computeLPS(pat, lps);
		
		int i = 0; // pointer on txt
		int j = 0; // pointer on pat
		while(i < n) {
			if(txt[i] == pat[j]) {
				i++;
				j++;
			} else {
				if(j != 0)
					j = lps[j-1];
				else				//j == 0, on starting index of pat
					i++;
			}
			
			if(j == m) {
				System.out.println("Match found at index: " + (i-j));
				
				//for continuing searching for all the pat in txt
				j = lps[j-1];
			}
		}
		
		System.out.println("search over!!");
	}
	
	public static void computeLPS(char pat[], int lps[]) {
		int m = pat.length;
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while(i < m) {
			if(pat[len] == pat[i]) {
				lps[i] = len + 1;
				len++;
				i++;
			} else {
				if(len != 0)
					len = lps[len-1];
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		//KHATAM!!
	}
}
