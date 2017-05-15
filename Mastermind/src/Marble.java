/**
 * This class represents a Marble GamePiece on the board, which make up the secret code and player guesses
 * 
 */
public class Marble extends GamePiece {
	private boolean matched; //used for the guess Marbles; true once they have a corresponding hint/secret Marble

	/**
	 * This constructor creates a marble of the given color and sets matched to false
	 * 
	 * @param color  - color of the new marble
	 */
	public Marble(String color) {
		this.color = color;
		matched = false;
	}

	/**
	 * This accessor method returns whether the marble already has a match.
	 * Marbles in the secret code will not have a match; only guess Marbles will.
	 * 
	 * @return true if the marble already has a match; false otherwise
	 */
	public boolean hasBeenMatched() {
		return matched;
	}

	/**
	 * This method sets matched to true.
	 */
	public void hasAMatch() {
		matched = true;
	}

	/**
	 * Returns the color of the marble
	 * 
	 * @return color
	 */
	public String toString() {
		return color;
	}
}