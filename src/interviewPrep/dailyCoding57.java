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


	// split words 
	
	public static String[] split(String s, int k) {
		
		
		
		
		String[] words = s.split(" ");
		
		for(String word : words) {
			if(word.length() > k) {
				System.out.println("NULLL");
				return null;
			}
		}
		
		
		double size = Math.ceil(s.length()/(double)k);
		//System.out.println(size);
		String[] kLetters = new String[(int)size];
		String newWord = words[0];
		int kLettersIDX = 0;
		for(String word: words) {
			if(newWord == word) continue;
			
			//System.out.println("word = " + word);

			if ((newWord.length() + word.length() + 1) > k) {
				//System.out.println(kLettersIDX);
				kLetters[kLettersIDX] = newWord;
				newWord = word;
				kLettersIDX++;
				
			}
			else {
				newWord = newWord.concat(" " + word);
				//System.out.println("new word =" + newWord);
			}
		}
		
		if(kLetters[kLetters.length-1] != newWord) {
			kLetters[kLetters.length-1] = newWord;
		}
		
		
		
		for(String word : kLetters) {
			System.out.println(word);
		}
		
		
		
		
		
		return kLetters;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//String s = "the quick brown fox jumps over the lazy dog";
		String s = "abcdefghijklmno";
		int k = 10;
		
		String[] res = split(s,k);
		
		
	}
}
