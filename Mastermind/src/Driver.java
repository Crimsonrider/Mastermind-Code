import java.awt.EventQueue;

public class Driver {
	public static GUI currentGame;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			currentGame = new GUI();
			currentGame.setVisible(true);

		});

		gamepieceMatches();
		pegIsWhite();
		mastermindCountColors();
		mastermindIsCorrect();
		mastermindInitiateTurn();
		mastermindGetThePegs();

	}

	/**
	 * Tests the matches(GamePiece other) method in the GamePiece class
	 */
	private static void gamepieceMatches() {
		System.out.println("TESTING matches(GamePiece other)");

		System.out.println("Test case 1: red & red");
		Marble m1 = new Marble("red");
		Marble m2 = new Marble("red");
		System.out.println("\t" + m1.matches(m2));

		System.out.println("Test case 2: red & blue");
		Marble m3 = new Marble("red");
		Marble m4 = new Marble("blue");
		System.out.println("\t" + m3.matches(m4));

		System.out.println();
	}

	/**
	 * Tests the isWhite() method in the Peg class
	 */
	private static void pegIsWhite() {
		System.out.println("TESTING isWhite()");

		System.out.println("Test case 1: white");
		Peg p = new Peg("white");
		System.out.println("\t" + p.isWhite());

		Peg x = new Peg("black");
		System.out.println("\t" + x.isWhite());

		Peg y = new Peg("red");
		System.out.println("\t" + y.isWhite());

		System.out.println();
	}

	/**
	 * Tests the countColors() method in the Mastermind class. Only provides 1
	 * test case, but each time it is called, the case will be different.
	 */
	private static void mastermindCountColors() {
		System.out.println("TESTING countColors()");

		Mastermind m = new Mastermind();

		System.out.println("Secret code:" + m.secretCode());

		int[] colorCount = m.countColors();
		for (int i = 0; i < colorCount.length; i++) {
			System.out.println("\thas " + colorCount[i] + " " + m.colors[i]);
		}

		System.out.println();
	}

	/**
	 * Tests the isCorrect() method in the Mastermind class
	 */
	private static void mastermindIsCorrect() {
		System.out.println("TESTING isCorrect()");

		Mastermind m = new Mastermind();

		System.out.println("Test case 1: all black");
		for (int i=0; i<4; i++) {
			m.board[1][i+4] = new Peg("black");
		}
		m.turn++;
		System.out.println("\t" + m.isCorrect());
		
		System.out.println("Test case 2: some black");
		m.board[1][4] = new Peg("black");
		m.board[1][5] = new Peg("white");
		m.board[1][4] = new Peg("red");
		m.board[1][4] = new Peg("black");
		m.turn++;
		System.out.println("\t" + m.isCorrect());
		
		System.out.println("Test case 3: no black");
		m.board[1][4] = new Peg("none");
		m.board[1][5] = new Peg("white");
		m.board[1][4] = new Peg("red");
		m.board[1][4] = new Peg("white");
		m.turn++;
		System.out.println("\t" + m.isCorrect());
		
		System.out.println();
	}

	/**
	 * Tests the initiateTurn() method in the Mastermind class
	 */
	private static void mastermindInitiateTurn() {

	}

	/**
	 * Tests the getThePegs() method in the Mastermind class
	 */
	private static void mastermindGetThePegs() {

	}
}
