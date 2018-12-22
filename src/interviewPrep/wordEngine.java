package interviewPrep;

import java.io.*;
import java.util.*;

class wordEngine {

 public static String[][] wordCountEngine(String document) {
    // change punctuation, split string, then remove punctuation
    document = document.toLowerCase();
    String[] words = document.split(" ");
   /* for(int i = 0; i < document.length; i++){
      char currChar = document.charAt(i);
      if(!Character.isLetter(currChar) && currChar !=){
          document.replace(currChar, "");
      }
    }
*/    
    String[] newWords = new String[words.length];
    int pos = 0;
    for(String word : words){
      StringBuilder sb = new StringBuilder(word);
      for(int i = 0; i < sb.length(); i++){
        char currChar = sb.charAt(i);
        if(!Character.isLetter(currChar)){
            sb.deleteCharAt(i);
        }
      }
      newWords[pos] = sb.toString();
      pos++;
    }
    
  Map<String, Integer> freqMap = new HashMap<String,Integer>();
  freqOfWords(freqMap,newWords);
    String[][] bucket = new String[largest_count+1][];
    for(int i = 0; i < largest_count; i++) {
    	bucket[i] = null;
    }
    
   for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
	    String[] tmpArr = bucket[entry.getValue()];
	    
	    if (tmpArr == null) {
	    	tmpArr = new String[largest_count+1];
	    }
	    
	    int size_of_bucket = tmpArr.length;
	    tmpArr[size_of_bucket] = entry.getKey();
        bucket[entry.getValue()] = tmpArr;
        System.out.println("entry = " + entry.getKey());
   }
    
    for(String[] ans : bucket){
    	if(ans == null) continue;
      System.out.println("word = " + ans);
    }
   
   
    String[][] res = new String[freqMap.size()][];
    return res;
  
}
  // find freq of words
  static int largest_count = 0;
 public static Map<String,Integer> freqOfWords(Map<String,Integer> map, String[] words){
   int currCount = 0;
    for(String word : words){
      if(map.containsKey(word)){
        map.put(word,map.get(word)+1);
        currCount = map.get(word);
      }else{
        map.put(word,1);
        currCount = 1;
      }
      
      if(currCount > largest_count){
        largest_count = currCount;
      }
    }
    // sorts map by Integer 
    return map;
  
  }

  public static void main(String[] args) {
      String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
      wordCountEngine(document);
  }

}