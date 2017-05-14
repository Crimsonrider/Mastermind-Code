import java.awt.EventQueue;

public class Driver {
	public static GUI currentGame;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			currentGame = new GUI();
			currentGame.setVisible(true);

		});
		// Marble m1 = new Marble("red", 1);
		// Marble m2 = new Marble("red", 2);
		// System.out.println("Testing matches method");
		// System.out.println(m1.matches(m2));
		//
		// Marble m3 = new Marble("red", 1);
		// Marble m4 = new Marble("blue", 2);
		// System.out.println(m3.matches(m4));

		Marble m1 = new Marble("red", 1);
		Marble m2 = new Marble("red", 2);
		System.out.println("Testing matches method");
		System.out.println(m1.matches(m2));

		// System.out.println("Testing isWhite():");
		// Peg p = new Peg("white");
		// System.out.println(p.isWhite());
		//
		// Peg x = new Peg("black");
		// System.out.println(x.isWhite());
		//
		// Peg y = new Peg("red");
		// System.out.println(y.isWhite());

		// Mastermind m = new Mastermind();
		//
		// System.out.println("Colors array");
		// for (String s : m.colors) {
		// System.out.print(s + " ");
		// }
		// System.out.println();
		//
		// System.out.print(m.secretCode());
		// System.out.println();
		//
		// System.out.println("Testing countColors()");
		// int[] colorCount = m.countColors();
		//
		// for (int i : colorCount) {
		// System.out.print(i + " ");
		// }
	}
}
