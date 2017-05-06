
public abstract class Board {
	int turn = 1;
	GamePiece[][] board = new GamePiece[11][8]; // first row represents secret
												// code, the rest are for
												// guesses

	public abstract void addPegs();

	public abstract boolean isCorrect();

	public abstract void initiateTurn();

}
