public class Marble extends GamePiece {
	private boolean matched; // variable for the color of the guessed marble
	private int position; // position of the marble

	/**
	 * This constructor creates a marble with the desired color and position
	 * 
	 * @param color
	 *            - color of the new marble
	 * @param position
	 *            - position of the marble
	 */
	public Marble(String color, int position) {
		this.color = color;
		this.position = position;
		matched = false;
	}
	
	/**
	 * This accessor method returns if the marble already has a match
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
