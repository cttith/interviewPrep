package interviewPrep;

public class spiralMatrix {public class SpiralArray {
	
	
}
		public static void main(String[] args) {
			int[][] data = {{1,2,3,4,41},
							{5,6,7,8,81},
							{9,10,11,12,121},
							{13,14,15,16,161},
							{17,18,19,20,201}};
			int rowStart = 0; 
			int rowEnd = data.length-1;
			int colStart = 0; 
			int colEnd = data[0].length-1;
			while (rowEnd >= rowStart || colEnd >= colStart) {
			printSpiral(rowStart, rowEnd, colStart, colEnd, data);
			rowStart++; rowEnd--;
			colStart++; colEnd--;
			}
		}
		
		
		static void printSpiral(int rowStart, int rowEnd, int colStart, int colEnd, int[][] data) {
			int i = 0; 
			int j = 0;
			
			for (j = colStart; j<=colEnd; j++) {
				System.out.print(data[rowStart][j] +" ->");
			}
			
			System.out.println();
			
			for (i=rowStart+1; i<=rowEnd; i++) {
				System.out.print(data[i][colEnd] +" ->");
			}
			
			System.out.println();
			for (j=colEnd-1; j>colStart; j--) {
				System.out.print(data[rowEnd][j] +" ->");
			}
			
			System.out.println();
			
			for (i = rowEnd; i>rowStart; i--) {
				System.out.print(data[i][colStart] +" ->");
			}
			
			System.out.println();
		}
		
}
