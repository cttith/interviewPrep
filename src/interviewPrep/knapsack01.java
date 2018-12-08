package interviewPrep;


// given capacity, value, weights
// return max value where weights <= capacity

public class knapsack01 {

	// take or leave
	public static int knapSack(int capacity, int[] values, int[] weights,int pos) {
		
	
		if(pos > values.length-1 || capacity == 0) return 0;
		
		if(weights[pos] > capacity) {
			return knapSack(capacity,values,weights,pos+1);
		}else {   // take or leave
			int res1 = knapSack(capacity,values,weights,pos+1);
			int res2 = values[pos] + knapSack(capacity-weights[pos],values,weights,pos+1);
			
			return(Math.max(res1,res2));
		}
		
	}
	
	// memo b/c a lot of repeated computations (given this position and capacity...)
	// top-down
	public static int knapSackDP(int capacity, int[] values, int[] weights, int pos, int memo[][]) {
		
		if(pos > values.length-1 || capacity == 0) return 0;
		
		if(memo[pos][capacity] != 0) {
			return memo[pos][capacity];
		}
		
		if(weights[pos] > capacity) {
			return knapSackDP(capacity,values,weights,pos+1,memo);
		}else {   // take or leave
			int res1 = knapSackDP(capacity,values,weights,pos+1,memo);
			int res2 = values[pos] + knapSackDP(capacity-weights[pos],values,weights,pos+1,memo);
			
			int result = (Math.max(res1,res2));
			memo[pos][capacity] = result;
			return result;
		}
	}
	
	// take it or leave it!!! [greedy]
	// table represents max value at item i w/ w being the weight accrued so far
	// optimize for maximum value at weight w for item i
	public static int knapSackDPbottomUp(int capacity, int[] values, int[] weights) {
		
		int[][] memo = new int[values.length+1][capacity+1];    // skip 0-th based
		
		for(int i = 0; i <= values.length; i++) {				// run for every value in array, building the table
			for(int w = 0; w <= capacity; w++) {				// run until capacity is met
				
				if(i == 0 || w == 0) {
					memo[i][w] = 0;
				}
				else if(weights[i-1] <= w) {	// if we can take value[i]
					memo[i][w] = Math.max(values[i-1] + memo[i-1][w-weights[i-1]] , memo[i-1][w]);  // [i-1] to grab value of previous knapSack
																									// [w-weights[i-1]] to find max value 
				}																					//  when weight is w-weights[i-1] 
				else {							// if we can't take, take the value of the previous max value (i-1)
					memo[i][w] = memo[i-1][w];
				}		
			}
		}
		
		return memo[values.length][capacity];
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] values = {1,2,3,4,5};
		int[] weights = {4,6,1,3,2};
		
		int capacity = 10;
		int[][] memo = new int[values.length+1][capacity+1];

		
		
		System.out.println(knapSack(capacity,values,weights,0));
		System.out.println(knapSackDP(capacity,values,weights,0,memo));
		System.out.println(knapSackDPbottomUp(capacity,values,weights));


		
		
		
	}
	
	
	
}
