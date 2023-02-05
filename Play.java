import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Play {
    static boolean win = false;
    static boolean resultR = false;
    static boolean resultY = false;
    private static BufferedReader input = new BufferedReader(new 
    InputStreamReader(System.in));

  public static void game(){

        // Game starts as long as there's no winner
        while (!win) {
            
            // Human Player 

            // Human player takes a turn only if the computer hasn't won
            if(!resultY)
            {
            String userInput = getUserInput();
            int move = Integer.parseInt(userInput);
            Board.placeToken('R', move - 1);
            resultR = checkWinner('R');
            }
    
            // Computer Player

            // The computer takes a turn only if the human player hasn't won
            if(!resultR) 
            {

            int min = 1, max = 7;
            // The computer makes a random move
            int rand = (int) (Math.random() * (max - min + 1) + min); 
            System.out.println("Computer is making it's move...");
            Board.placeToken('Y', rand - 1);
            resultY = checkWinner('Y');
            }

            Board.print();

            getResult();

            
    
        }

    }

     // Returns true if the player has won either horizontally, vertically, or diagonally
  public static boolean checkWinner(char player) { 

		boolean check1 = Board.checkHorizontal(0, false, player);
		boolean check2 = Board.checkVertical(0, false, player);
		boolean check3 = Board.checkDiagonal1(false, player);
		boolean check4 = Board.checkDiagonal2(false,player);

		return (check1 || check2 || check3 || check4);
	}

    //Method to calculate and display the result
  public static void getResult()
    {   
        // Checks if human player has won
        if (resultR) { 
            win = true;
            System.out.println("You Have Won!!!");

        //Checks if computer has won
        } else if (resultY) { 
            win = true;
            System.out.println("You lost.\nThe computer won!!!");
        }
    }



    // Method  to take the user input
	public static String getUserInput() { 
		String toReturn = null;
		try {
			toReturn = input.readLine();
		} catch (Exception e) {

		}
		return toReturn;
	}

    
    
}
