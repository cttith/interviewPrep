package interviewPrep;
// given an array and a value k
// partition the list into 3 segments, <k, ==k , >k
public class partition_around_k {

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	// { 5, 5, 2, 6, 1} -> { L5, 5, C2, 6, R1 } => { 2, L5, 5, C6, R1 } => { 2, L5, 5, R1, C6}
	// { 1, 2, 5, 5, 6}
	
	// { 3 4 5 6 5 6} -> { 3, 4 L5, C6, 5, R6 } -> { 3, 4, L5, 6, CR5, 6 }  
	public static void partition(int[] nums, int k) {
		
		// swap elements @ current to right side if >k
		// swap elements @ current to left side if  <k
		// elements that are == k should fall in the middle [ kind of bubbling up/down the values that are ==k  ]
		
		// while current <= nums.length
		// need three pointers, left, right, current
		// if elements at current is less than k
				// swap current and left
				// current++;
				// left++;
		// else if element at current is greater than k
				// swap current and right
				// current++;												; don't increment b/c we need to see if the new current value needs to be moved
				// right--;
		// else if current == k
				// current++    <- leave alone the k value, b/c the swaps will have it pushed to the middle whether it be pushed up or pushed down
		
		
		int left = 0, current = 0;
		int right = nums.length-1;
		while(current <= right) {
			if(nums[current] < k) {
				swap(nums,current,left);
				left++;
				current++;
			}
			else if(nums[current] > k) {
				swap(nums,current,right);
				right--;
			}
			else {
				System.out.println("current++");
				current++;
			}
			for(int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		

		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {3, 4, 5, 6, 5, 6};
		//int[] arr = {5,5,2,6,1};
		int k = 5;
		
		
		partition(arr,k);
	/*	
		for(int num : arr) {
			System.out.print(num + " ");
		}
		*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
