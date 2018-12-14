package interviewPrep;


/*
 Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
             
             (sliding window technique)
             - while (start < s.length())
             	- if arr[end] == 1
             		- arr[start]--;
             		- start++;
             	- else
             		- arr[end]++;
             		- end++;
            	
             
 */
public class LongestSubstring_no_repeating_Char {

	
	public static int longestSubstring(String s) {
		
		int[] charArr = new int[128];
		int startIndex = 0, endIndex = 0;
		int curr_length = 0;
		int max_length = 0;
		int startLong = 0;
		int endLong = 0;
		

		while(endIndex < s.length()) {
			
			if(charArr[(int)s.charAt(endIndex)] == 1) {
				charArr[(int)s.charAt(startIndex)]--;				
				curr_length--;
				startIndex++;					// slide start index to right by 1
			}
			else {
				charArr[(int)s.charAt(endIndex)]++;		
				endIndex++;
				curr_length++;
			}
		
			if(curr_length > max_length) {
				max_length = curr_length;
				startLong = startIndex;
				endLong = endIndex;
			}
		}
		
		
		System.out.println("Longest substring w/o repeating character is : " + s.substring(startLong, endLong));
		return max_length;
	
	
	}
	
	
	public static void main(String[] args) {
		
		//String s = "abcabcbb";
		//String s = "abcabcbb";
		String s = "pwwkew";
		int res = longestSubstring(s);
		
		System.out.println("Length : " + res);
		
		
		
	}

}
