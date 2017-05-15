import java.awt.EventQueue;

/**
 * This class launches the Mastermind game and tests various methods from the other classes on the console
 * 
 */
public class Driver {
	public static GUI currentGame;

	/**
	 * Initializes currentGame and calls the test methods
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			currentGame = new GUI();
			currentGame.setVisible(true);

		});

		 gamepieceMatches();
		 pegIsWhite();
		 mastermindCountColors();
		 mastermindIsCorrect();
		 mastermindSecCode();
		 mastermindGetHints();
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
		for (int i = 0; i < 4; i++) {
			m.board[1][i + 4] = new Peg("black");
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
	 * Tests the secCode() method in the Mastermind class
	 */
	private static void mastermindSecCode() {
		System.out.println("TESTING secCode()");
		
		Mastermind m = new Mastermind();
		System.out.println("Secret Code");
		for (int i = 0; i < 4; i++) {
			System.out.println(" " + m.board[0][i] + " ");
		}
		System.out.println();
		
		System.out.print("Compared to: ");
		System.out.println(m.secretCode());
		
		System.out.println();
	}

	/**
	 * Tests the getHints() method in the Mastermind class.
	 */
	private static void mastermindGetHints() {
		System.out.println("TESTING getHints()");

		Mastermind m = new Mastermind();
		
		m.board[1][0] = new Marble("red");
		m.board[1][1] = new Marble("blue");
		m.board[1][2] = new Marble("green");
		m.board[1][3] = new Marble("yellow");
		
		m.addPegs();
		
		System.out.println("Secret code: " + m.secretCode());
		System.out.println("Hints:   " + m.getHints());
		
		System.out.println();
	}
	
	/**
	 * Tests the getThePegs() method in the Mastermind class
	 */
	private static void mastermindGetThePegs() {
		System.out.println("TESTING getThePegs()");

		Mastermind m = new Mastermind();
		int[] temp;

		System.out.println("Test case 1: 1 white, 3 black");
		m.board[1][4] = new Peg("black");
		m.board[1][5] = new Peg("white");
		m.board[1][6] = new Peg("black");
		m.board[1][7] = new Peg("black");
		m.turn++;
		temp = m.getThePegs();
		System.out.println("\t" + temp[0] + " blacks, " + temp[1] + " whites, " + temp[2] + " null.");

		System.out.println("Test case 2: 2 black, 1 white, and 1 null");
		m.board[2][4] = new Peg("black");
		m.board[2][5] = new Peg("white");
		m.board[2][6] = null;
		m.board[2][7] = new Peg("black");
		m.turn++;
		temp = m.getThePegs();
		System.out.println("\t" + temp[0] + " blacks, " + temp[1] + " whites, " + temp[2] + " null.");

		System.out.println("Test case 3: 3 white, 1 null");
		m.board[3][4] = null;
		m.board[3][5] = new Peg("white");
		m.board[3][6] = new Peg("white");
		m.board[3][7] = new Peg("white");
		m.turn++;
		temp = m.getThePegs();
		System.out.println("\t" + temp[0] + " blacks, " + temp[1] + " whites, " + temp[2] + " null.");

		System.out.println();
	}
}
