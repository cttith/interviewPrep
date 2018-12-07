package interviewPrep;


// given strings are they anagrams? (diff word, same letters)
// takeaway : utilize ascii values
public class anagram {

	public static boolean isAnagram(String str1, String str2) {
		
		if(str1.length() <= 0 || str2.length() <= 0 || str1.length() != str2.length()) {
			return false;
		}
		
		// need counts to cancel each other
		int[] count = new int[26]; 
		
		for(int i = 0; i < str1.length(); i++)
		{
			count[str1.charAt(i) - 'a']++;
			count[str2.charAt(i) - 'a']--;
		}
		
		for(int num : count) {
			if (num != 0) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "silent";
		String str2 = "listen";
		
		System.out.println(isAnagram(str1,str2));
		
	}
	
}
