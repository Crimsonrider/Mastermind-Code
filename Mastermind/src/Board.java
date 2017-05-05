
public abstract class Board {
	int turn = 1;
	GamePiece [][] board  =new GamePiece[11][4];
	public abstract void addPegs();
	public abstract boolean isCorrect();
	public abstract void initiateTurn();
	
}
