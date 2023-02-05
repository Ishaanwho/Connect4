public class MyConnectFour {

	public MyConnectFour() {
		Welcome();
	}

	//  Displays the Welcome text, prompting user to interact
	private void Welcome() {

		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 (You) is Red (R), Player 2 (Computer) is Yellow (Y)");
		System.out.println("To play the game, type in the number of the column you want to drop your token in");
		System.out.println("A player wins by connecting 4 tokens in a row - vertically, horizontally or diagonally");
		System.out.println("");

		Board.print();
		Play.game();


	}

}
