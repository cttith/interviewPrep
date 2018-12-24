package interviewPrep;
// only works if array is sorted
public class two_sum_ptrmethod {

	    public static int[] twoSum(int[] nums, int target) {
	        // 2 p ointer method
	        
	        int left = 0;
	        int right = nums.length-1;
	        int[] pos = new int[2];
	        int sum = 0;
	        while(left < right && sum != target){
	            int leftNum = nums[left];
	            int rightNum = nums[right];
	            sum = nums[left] + nums[right];
	            
	            if(sum == target){
	                pos[0] = left;
	                pos[1] = right;
	            }
	            else if(sum < target){
	                left++;
	            }
	            else{
	                right--;
	            }
	        }
	        return pos;
	    }
	
	    public static void main(String[] args) {
	    	int[] nums = {1,2,3,4,5};
	    	int target = 9;
	    	
	    	int[] res = twoSum(nums,target);
	    	
	    	for(int num : res) {
	    		System.out.println(num);
	    	}
	    }
}
