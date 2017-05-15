/**
 * This class represents a game piece on the game board that has a specific
 * color
 *
 */
public abstract class GamePiece {
	protected String color; // color of the piece

	/**
	 * This method checks if the color of other matches the color of this
	 * GamePiece
	 * @param other - the GamePiece to be checked against this one
	 * @return true if both have the same color; false if they are different
	 */
	public boolean matches(GamePiece other) {
		return this.color.equals(other.getColor());
	}

	/**
	 * This accessor method gets the color of the piece
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * This mutator method sets the color of the piece
	 * 
	 * @param c - the name of the new color
	 */
	public void setColor(String c) {
		color = c;
	}

}
