package interviewPrep;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// return max length of array that contains continuous elements
// [ 1 , 99 , 4, 3, 2, 100 , 5] -> answer = max(length(1,2,3,4,5),length(99,100))
public class longest_continuous_subarray {
	
	public static int maxLength(int[] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : arr) {
			set.add(num);
		}
		
		int currLength = 0;
		int maxLength = 0;
		// if list contains a contiguous subarray, we can sort and get in nlogn time OR we can do it in O(n), 
		// 4 cases
		// we get num that falls in middle of contiguous subarrray 
		// num falls on left of subarray
		// num falls on right of subarray
		// num is alone
		
		// improve by pruning elements already searched [requires removing elements from set as we search, this leads to a ConcurrentModificationException error, UNLESS we use an iterator]
		/*
		 * 	for(final Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
			int num = iterator.next();
			System.out.println(num);
			LeftVal = LeftRecurse(num,set);
			RightVal = RightRecurse(num,set);
			currLength = (RightVal - LeftVal) + 1;
			while(RightVal >= LeftVal) {
				set.remove(RightVal);
				RightVal--;
			}
			maxLength = Math.max(currLength, maxLength);
		}
		 */

		int LeftVal, RightVal;
		for(int num : set) {
			if(!set.contains(num+maxLength)) continue;
			LeftVal = LeftRecurse(num,set);
			RightVal = RightRecurse(num,set);
			currLength = (RightVal - LeftVal) + 1;
			maxLength = Math.max(currLength, maxLength);
		}

		return maxLength;
		
	}
		
		public static int LeftRecurse(int left, Set<Integer> set) {
			if(!set.contains(left)) return left+1;
			//set.remove(left);
			return LeftRecurse(left-1,set);
		}
		
		public static int RightRecurse(int right, Set<Integer> set) {
			if(!set.contains(right)) return right-1;
			//set.remove(right);
			return RightRecurse(right+1,set);
		}
		
		
		public static void main(String[] args) {
			
			int[] arr = {99,100,3,2,5,4, 6};
			
			int len = maxLength(arr);
			
			System.out.println(len);
			
			
			
			
		}
		
}
	
	
	
	
	


