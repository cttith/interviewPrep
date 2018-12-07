package interviewPrep;

public class buySellStock {

	public static int profit(int[] stocks) {
		
		int min = Integer.MAX_VALUE;
		int profit = 0;
		
		for(int i = 0; i < stocks.length; i++) {
			if(stocks[i] < min) {
				min = stocks[i];
			}
			
			profit = Math.max(profit, stocks[i] - min);
			
		}
		
		return profit;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] stock = {5,6,6,2,4,10};
		
		System.out.println(profit(stock));
	}
	
	
}
