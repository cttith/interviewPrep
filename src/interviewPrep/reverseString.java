package interviewPrep;


// given a string, reverse it

// take aways: strings are immutable in java
// string buffer or string builder are also valid 
// buffer : synchronized methods
// builder : asynchronized methods
public class reverseString {

	public static String reverseStr(String str) {
		char[] characters = str.toCharArray();
		
		int begin = 0;
		int end = str.length() - 1;
		
		while(begin < end) {
			char temp = characters[begin];
			characters[begin++] = characters[end];
			characters[end--] = temp;
		}
		
		return new String(characters);
	}
	
	public static void main(String[] args) {
		
		String test = "cougars";
		System.out.println(reverseStr(test));
	}
	
}
