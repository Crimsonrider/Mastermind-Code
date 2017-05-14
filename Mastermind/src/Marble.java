public class Marble extends GamePiece {
	private boolean matched; // variable for the color of the guessed marble

	/**
	 * This constructor creates a marble with the desired color and position
	 * 
	 * @param color
	 *            - color of the new marble
	 */
	public Marble(String color) {
		this.color = color;
		matched = false;
	}

	/**
	 * This accessor method returns whether the marble already has a match.
	 * Marbles in the secret code will not have a match; only guess Marbles will.
	 * 
	 * @return true if the marble already has a match, false otherwise
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