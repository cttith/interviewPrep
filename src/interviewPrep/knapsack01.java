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
	
	
	
	public static void main(String[] args) {
		
		int[] values = {1,2,3,4,5};
		int[] weights = {4,6,1,3,2};
		
		int capacity = 10;
		
		System.out.println(knapSack(capacity,values,weights,0));
		
		
		
	}
	
	
	
}
