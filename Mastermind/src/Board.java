
/**
 * This class represents a game board with a turn limit and pegs/hints
 */
public abstract class Board {

	public int turn = 1;
	public final int turnLimit = 10;

	GamePiece[][] board = new GamePiece[11][8];
	// first row represents secret code, the rest are user guesses
	// 4 columns for the marbles/guesses and 4 for the pegs/hints

	/**
	 * Adds Peg objects to the final four columns of the current row
	 */
	public abstract void addPegs();

	/**
	 * Checks if the guess is correct
	 * 
	 * @return true if all 4 marbles are the correct color and in the correct
	 *         position; false otherwise
	 */
	public abstract boolean isCorrect();

	/**
	 * Begins the next turn and increments the turn count
	 */
	public abstract void initiateTurn();

	/**
	 * This method prints and displays "You win! ^-^"
	 */
	public void youWin() {
		Driver.currentGame.messageBox.setText("You win! ^-^");
		System.out.println("You win! ^-^");
	}

	/**
	 * This method prints and displays "You lose! D:"
	 */
	public void youLose() {
		Driver.currentGame.messageBox.setText("You lose! D:");
		System.out.println("You lose! D:");
	}
}
