public class Marble extends GamePiece {
	public Marble(String color, int position) {
		super.color = color;
		super.position = position;
	}

	public String toString() {
		return color;
	}
}
