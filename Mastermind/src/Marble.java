public class Marble extends GamePiece {
	private boolean matched;
	private int position;

	public Marble(String color, int position) {
		this.color = color;
		this.position = position;
		matched = false;
	}

	public boolean hasBeenMatched() {
		return matched;
	}

	public void hasAMatch() {
		matched = true;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int pos) {
		position = pos;
	}

	public String toString() {
		return color;
	}
}
