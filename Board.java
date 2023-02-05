public class Board {
    
    private static char[][] board = new char[6][7];

    // Method to print out the board
    public static void print() { 
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'R') {
					System.out.print("| R ");
				} else if (board[i][j] == 'Y') {
					System.out.print("| Y ");
				} else {
					System.out.print("|   ");
				}
			}
			System.out.println("|  ");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}


    // Checks for 4 tokens in a row horizontally 
	static boolean checkHorizontal(int count, boolean hasWon, char player) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == player) {
					count = count + 1;
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}

		}
		return hasWon;
	}

    // Checks for 4 tokens in a row horizontally 
	static boolean checkVertical(int count, boolean hasWon, char player) {
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == player) {
					count = count + 1;
					if (count >= 4) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

    // Checks for 4 tokens in a row diagonally (/) 
	static boolean checkDiagonal1( boolean hasWon, char player)
	{
		for (int i = 0; i < board.length-3; i++) {
			for (int j = 0; j < board[0].length; j++) 
			{
				if (board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == player && board[i+3][j+3] == player) 
				{
					hasWon = true;
				} 
			}
		}
		return hasWon;

	}

    // Checks for 4 tokens in a row diagonally  (\)
	static boolean checkDiagonal2(boolean hasWon, char player)
	{
		for (int i = 3; i < board.length; i++) {
			for (int j = 0; j < board[0].length-3; j++) 
			{
				if (board[i][j] == player && board[i - 1][j + 1] == player && board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) 
				{
					hasWon = true;
				} 
			}
		}
		return hasWon;

	}


    // Method to place the token
	public static void placeToken(char player, int position) {
		boolean placed = false;
		if (player == 'R') {
			for (int i = board.length - 1; i >= 0; i--) {
				if (!placed) {
					if (board[i][position] == 'Y') {
						// skip
					} else if (board[i][position] != 'R') {
            // Place the token
						board[i][position] = 'R';
						placed = true;
					}
				}
			}
		} else {
			for (int i = board.length - 1; i >= 0; i--) {
				if (!placed) {
					if (board[i][position] == 'R') {
						// skip
					} else if (board[i][position] != 'Y') {
            // Place the token
						board[i][position] = 'Y';
						placed = true;
					}
				}
			}
		}
	}
}

