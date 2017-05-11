
public class Peg extends GamePiece {
	/**
	 * Constructor creates a new peg object with the desired color
	 * 
	 * @param c
	 *            - color
	 */
	public Peg(String c) {
		color = c;
	}

	/**
	 * checks if the peg is white
	 */
	public boolean isWhite() {
		return (getColor().equals("white"));
	}

	/**
	 * @return the color of the peg
	 */
	public String toString() {
		return color;
	}
}
