public abstract class GamePiece {
	protected String color; // color of the piece

	/**
	 * This method checks if the color of the piece matches the color of another
	 * peice
	 * 
	 * @return true if both have the same color, false if they are different
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
	 * @param the
	 *            name of the new color in String format
	 */
	public void setColor(String c) {
		color = c;
	}

}
