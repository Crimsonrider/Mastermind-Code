
public class Peg extends GamePiece {
	public Peg(String c) {
		color = c;
	}
	
	public boolean isWhite() {
		return (getColor().equals("white"));
	}

	public String toString() {
		return color;
	}
}
