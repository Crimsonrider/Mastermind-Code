
public abstract class Board {
	public int turn = 1;
	public final int turnLimit = 10;
	GamePiece[][] board = new GamePiece[11][8];
	// first row represents secret code, the rest are user guesses
	// 4 columns for the marbles/guesses and 4 for the pegs/hints

	/**
	 * adds pegs to give hints
	 */
	public abstract void addPegs();

	/**
	 * Checks if the guess is correct
	 * 
	 * @return true if all 4 marbles are the correct color and in the correct
	 *         position
	 */
	public abstract boolean isCorrect();

	/**
	 * prompts the user to start the next turn
	 */
	public abstract void initiateTurn();

	/**
	 * This method prints "You win! ^-^"
	 */
	public void youWin() {
		Driver.currentGame.messageBox.setText("You win");
		System.out.println("You win! ^-^");
	}

	/** 
	 * This method prints "You win! ^-^"
	 */
	public void youLose() {
		Driver.currentGame.messageBox.setText("You lose");
		System.out.println("You lose! D:");
	}
}
