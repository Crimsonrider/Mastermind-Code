import java.awt.EventQueue;

public class Driver {
	public static GUI currentGame;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			currentGame = new GUI();
			currentGame.setVisible(true);

		});
		
		Marble m1 = new Marble("red", 1);
		Marble m2 = new Marble("red", 2);
		System.out.println("Testing matches method");
		System.out.println(m1.matches(m2));

		Marble m3 = new Marble("red", 1);
		Marble m4 = new Marble("blue", 2);
		System.out.println(m3.matches(m4));

	}

}
