package interviewPrep;

import java.util.HashMap;

/*
 * Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less. 
 * You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: 
["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */

public class dailyCoding57 {

	// split words, if adjacent words length + (1*# words) <= 10 combine, else move on
	
	public static String[] split(String s, int k) {
		
		String[] words = s.split(" ");
		
		String[] kLetters = new String[words.length/k];
		
		int currLen = 0;
		int splitListidx = 0
		int startWordidx = 0;
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		for(int i = 0; i < words.length; i++) {
			hm.put(words[i], i);
		}
		
		for(int i = 0; i < words.length; i++) {
			
			if(words[i].length() + currLen + (1 * startWordidx - i) <= 10) {
				currLen += words[i].length();
				
			}else {
				String newString = "";
				for(int j = startWordidx; j < i; j++) {
					if(j == i-1) {
						newString = newString.concat(words[j]);
					}else {
					newString = newString.concat(words[j] + " ");
					}
				}
				
				kLetters[splitListidx] = newString;
				currLen = words[i].length();
				startWordidx = i;
				splitListidx++;
				
			}
		}
		
		
		
		
		
		return words;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String s = "the quick brown fox jumps over the lazy dog";
		int k = 10;
		
		split(s,k);
		
		
		
	}
}
