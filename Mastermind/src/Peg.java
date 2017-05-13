import javax.swing.ImageIcon;

public class Peg extends GamePiece {
	private ImageIcon thisIcon;
	
	public Peg(String c) {
		color = c;
		if (c.equals("white")) {
			thisIcon = new ImageIcon("Mastermind/images/white.jpg");
		}
		else {
			thisIcon = new ImageIcon("Mastermind/images/black.jpg");
		}
	}
	
	public boolean isWhite() {
		return (getColor().equals("white"));
	}
	
	public ImageIcon getIcon() {
		return thisIcon;
	}

	public String toString() {
		return color;
	}
}
