package interviewPrep;





public class dailyCoding57 {


	// split words 
	
	public static String[] split(String s, int k) {
		
		
<<<<<<< Updated upstream
		
		
		String[] words = s.split(" ");
		
=======
>>>>>>> Stashed changes
		for(String word : words) {
			if(word.length() > k) {
				System.out.println("NULLL");
				return null;
			}
		}
<<<<<<< Updated upstream
		
		
=======
	
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		}
		
		if(kLetters[kLetters.length-1] != newWord) {
			kLetters[kLetters.length-1] = newWord;
		}
		
		
		
		for(String word : kLetters) {
			System.out.println(word);
=======
>>>>>>> Stashed changes
		}
		
		if(kLetters[kLetters.length-1] != newWord) {
			kLetters[kLetters.length-1] = newWord;
		}
		
		
		
		for(String word : kLetters) {
			System.out.println(word);
		}
		
		
		
<<<<<<< Updated upstream
=======
		
		
>>>>>>> Stashed changes
		return kLetters;
	}
	

	
	public static void main(String[] args) {
		
<<<<<<< Updated upstream
		//String s = "the quick brown fox jumps over the lazy dog";
		String s = "abcdefghijklmno";
=======
		String s = "the quick brown fox jumps over the lazy dog";
		//String s = "abcdefghijklmno";
>>>>>>> Stashed changes
		int k = 10;
		
		String[] res = split(s,k);
		
		
	}
}