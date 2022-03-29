
public class SudokuSolverMain {
	
	public static final int size =9;

	public static void main(String[] args) {
		
		// Zero represents blank spots or spots to be solved
		int [][] board = {
		        {7, 0, 2, 0, 5, 0, 6, 0, 0},
		        {0, 0, 0, 0, 0, 3, 0, 0, 0},
		        {1, 0, 0, 0, 0, 9, 5, 0, 0},
		        {8, 0, 0, 0, 0, 0, 0, 9, 0},
		        {0, 4, 3, 0, 0, 0, 7, 5, 0},
		        {0, 9, 0, 0, 0, 0, 0, 0, 8},
		        {0, 0, 9, 7, 0, 0, 0, 0, 5},
		        {0, 0, 0, 2, 0, 0, 0, 0, 0},
		        {0, 0, 7, 0, 4, 0, 2, 0, 3} 
		      };
		System.out.println("Given Suduku To Solve");
		printBoard(board);
		System.out.println();
		
		if(solveBoard(board))
		{
			System.out.println("Solved Suduku");
			printBoard(board);
		}
		else
		{
			System.out.println("Cannot Solve! Try Again");
		}

	}

	private static void printBoard(int[][] board) {
		for(int row=0;row<size;row++)
		{
			if(row%3==0 &&row!=0)
			{
				System.out.println("-----------");
			}
			for(int col=0;col<size;col++)
			{
				if(col%3==0 && col!=0)
				{
					System.out.print("|");
				}
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
	
		private static boolean numberinRow(int [][] board, int number, int row)
		{
			for(int i=0;i<size;i++) {
				if(board[row][i]==number)
				{
					return true;
				}
			}
			return false;
		}
		
		private static boolean numberinColumn(int [][] board, int number, int col)
		{
			for(int i=0;i<size;i++) {
				if(board[i][col]==number)
				{
					return true;
				}
			}
			return false;
		}
		
		private static boolean numberinBox(int [][]board, int number, int row, int col)
		{
			int srow= row-row%3;
			int scol=col-col%3;
			
			for(int i=srow;i<srow+3;i++) {
				for(int j=scol;j<scol+3;j++){
					if(board[i][j]==number)
					{
						return true;
					}
				}
			}
			return false;
		}
		
		private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		    return !numberinRow(board, number, row) &&
		        !numberinColumn(board, number, column) &&
		        !numberinBox(board, number, row, column);
		  }
		
		private static boolean solveBoard(int[][] board) {
		    for (int row = 0; row <size; row++) 
		    {
		      for (int column = 0; column < size; column++) 
		      {
		        if (board[row][column] == 0) 
		        {
		          for (int numberToTry = 1; numberToTry <= size; numberToTry++) 
		          {
		            if (isValidPlacement(board, numberToTry, row, column)) 
		            {
		              board[row][column] = numberToTry;
		              
		              if (solveBoard(board)) 
		              {
		                return true;
		              }
		              else 
		              {
		                board[row][column] = 0;
		              }
		            }
		          }
		          return false;
		        }
		      }
		    }
		    return true;
		  }

}
