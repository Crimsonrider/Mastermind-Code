import javax.swing.ImageIcon;
/**
 * This class represents a Peg GamePiece on the board, which is used to give the player hints
 *
 */
public class Peg extends GamePiece {
	
	private ImageIcon thisIcon;

	/**
	 * Constructor initializes color and thisIcon based on the argument.
	 * Any Peg that is not white will have a black Peg icon.
	 * @param c - color
	 */
	public Peg(String c) {
		color = c;
		if (c.equals("white")) {
			thisIcon = new ImageIcon("images/white.jpg");
		} else {
			thisIcon = new ImageIcon("images/black.jpg");
		}
	}

	/**
	 * Checks to see if the Peg is white
	 * @return true if the Peg is white; false otherwise
	 */
	public boolean isWhite() {
		return (getColor().equals("white"));
	}

	/**
	 * Accessor method for the icon of the Peg
	 * 
	 * @return thisIcon
	 */
	public ImageIcon getIcon() {
		return thisIcon;
	}

	/**
	 * Returns the color of the Peg
	 * @return color
	 */
	public String toString() {
		return color;
	}
}
