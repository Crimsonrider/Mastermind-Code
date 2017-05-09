
public abstract class Board {
	public int turn = 1;
	final int turnLimit = 10;
	public GamePiece[][] board = new GamePiece[11][8]; // first row represents secret
												// code, the rest are for
												// guesses

	public abstract void addPegs();

	public abstract boolean isCorrect();

	public abstract void initiateTurn();

	public void youWin() {
		System.out.println("You win! ^-^");
	}
	
	public void youLose() {
		System.out.println("You lose! D:");
	}
}
