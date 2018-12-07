package interviewPrep;

import java.util.HashMap;

// return first unique character in a string
// hashmap
public class firstUniqueChar {
	
	public static char firstUnique(String str) {
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		
		for(int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if(hm.containsKey(currChar)){
				hm.put(currChar, -1);
			}
			else {
				hm.put(currChar, 1);
			}
		}
		
		for(char curr : hm.keySet()) {
			if( hm.get(curr) == 1) {
				return curr;
			}
		}
		
		return '0';
	}
	
	
	public static void main(String[] args) {
		
		
		String str1 = "lllloooop";
		
		System.out.println(firstUnique(str1));
		
	}

}
