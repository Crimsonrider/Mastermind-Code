
public abstract class GamePiece {
	protected String color;
	
	public boolean matches(GamePiece other) {
		return this.color.equals(other.getColor());
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
}
