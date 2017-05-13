import javax.swing.ImageIcon;

public class Peg extends GamePiece {
	private ImageIcon thisIcon;

	/**
	 * Constructor creates a new peg object with the desired color
	 * 
	 * @param c
	 *            - color
	 */
	public Peg(String c) {
		color = c;
		if (c.equals("white")) {
			thisIcon = new ImageIcon("Mastermind/images/white.jpg");
		} else {
			thisIcon = new ImageIcon("Mastermind/images/black.jpg");
		}
	}

	/**
	 * This method checks if the peg is white
	 */
	public boolean isWhite() {
		return (getColor().equals("white"));
	}

	/**
	 * accessor method for the icon
	 * 
	 * @return thisIcon
	 */
	public ImageIcon getIcon() {
		return thisIcon;
	}

	/**
	 * @return the color of the peg
	 */
	public String toString() {
		return color;
	}
}
