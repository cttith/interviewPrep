package interviewPrep;

import java.util.HashMap;

/*
 * TinyURL is a URL shortening service where you enter a URL such as
 *  https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

ideas
- definitely using a hashmap
- means I would need a way to do  1:1 key,pair
- I could subtract one from each ascii value of the original string... that would lead to a long result...
- 
 */
public class Encode_decode_tinyurl {

	HashMap<String,String> map = new HashMap<String,String>();
	
	public static void encode(String s) {
		
		StringBuilder encoded_string = new StringBuilder();
		s.
		char[] charArr = s.toCharArray();
		
		for(int i = 0; i < charArr.length; i++) {
			encoded_string.append((char)((int)charArr[i]/2 +1));
		}
		
		System.out.println("Encoded String = " + encoded_string);
		
	}
	
	public static void decode(String s) {
		
	}
	
	
	public static void main(String[] args) {
		
		String s = "https://leetcode.com/problems/design-tinyurl";
		
	}
	
	
	
	
	
	
}
