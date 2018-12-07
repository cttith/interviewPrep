package interviewPrep;

import java.util.Scanner;

// dp fib
// 1 1 2 3 5 8
public class fibDP {

	
	
	public static int fibDP(int n, int[] memo) {
		
		if(memo[n] != 0) return memo[n];		// array = 0 when initialized
		
		int result = fibDP(n-1, memo) + fibDP(n-2, memo);
		
		memo[n] = result;
		
		return result;
		

	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int seq = input.nextInt();
		
		int memo[] = new int[seq+1];
		memo[0] = 1; memo[1] = 1;
		System.out.println(fibDP(seq,memo));
		
	}
	
	
	
	
	
}
