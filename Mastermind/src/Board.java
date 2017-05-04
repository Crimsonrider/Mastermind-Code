
public abstract class Board {
	int turn;
	GamePiece [][] board;
	public abstract void addPegs();
	public abstract boolean isCorrect();
	public abstract void initiateTurn();
	
}
