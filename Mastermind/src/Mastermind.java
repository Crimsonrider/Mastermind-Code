import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Board {
	private final boolean PRINT_FOR_DEBUGGING = true;
	private final long SEED = 1;

	String[] colors = { "red", "blue", "green", "yellow" }; // four color
															// options for the
															// marbles
	private int[] secretColorCount = { 0, 0, 0, 0 }; // indexes correspond to
														// colors array, tells
														// how many times the
														// color it corresponds
														// to is in the secret
														// code
	private Scanner in = new Scanner(System.in); // reads input

	/**
	 * This constructor creates the secret code using a Random object and a
	 * for-loop The secret code is the first four terms in the first row of the
	 * board array.
	 */
	public Mastermind() {
		Random rand = new Random(SEED);
		for (int i = 0; i < colors.length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index], i);
			board[0][i] = a;
			secretColorCount[index]++;
		}
	}

	/**
	 * This constructor creates the secret code using a Random object and a
	 * for-loop The secret code is the first four terms in the first row of the
	 * board array.
	 * 
	 * @param theSeed
	 *            -the seed for the random object
	 */
	public Mastermind(long theSeed) {
		Random rand = new Random(theSeed);
		for (int i = 0; i < colors.length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index], i);
			board[0][i] = a;
			secretColorCount[index]++;
		}
	}

	/**
	 * creates a copy of the original array of color counts
	 * 
	 * @return array of the count of each color in the secret code
	 */
	public int[] countColors() {
		int colorCt[] = new int[colors.length];

		for (int i = 0; i < colors.length; i++) {
			colorCt[i] = secretColorCount[i];
		}

		return colorCt;
	}

	@Override
	public void addPegs() {
		int[] colorCt = countColors();

		System.out.println("colorCt after copying secretColorCount:");
		for (int i = 0; i < 4; i++) {
			System.out.println("\t" + colorCt[i] + " " + colors[i]);
		}

		for (int i = 0; i < colors.length; i++) {
			Marble x = (Marble) board[turn][i]; // look at Marble in each index
												// of guess
			Marble parallelM = (Marble) board[0][i]; // look at Marble in each
														// index of secret code

			if (x.matches(parallelM)) {
				// if they match put a black peg
				board[turn][i + colors.length] = new Peg("black");

				for (int j = 0; j < colors.length; j++) {
					// subtract from the count of the corresponding color
					if (parallelM.getColor().equals(colors[j]))
						colorCt[j] = colorCt[j] - 1;
				}

				x.hasAMatch();
			}
		}

		// colorCt now contains the count for each marble color that is
		// available to be matched for a white peg

		System.out.println("colorCt after adding black pegs: ");
		for (int i = 0; i < 4; i++) {
			System.out.println("\t" + colorCt[i] + " " + colors[i]);
		}

		for (int i = 0; i < colors.length; i++) {
			Marble x = (Marble) board[turn][i];
			if (x.hasBeenMatched())
				continue;

			for (int j = 0; j < colors.length; j++) {
				if (x.getColor().equals(colors[j]) && colorCt[j] > 0) {
					board[turn][i + colors.length] = new Peg("white");
					colorCt[j]--;
				}
			}

		}

	}

	@Override
	public boolean isCorrect() {
		for (int i = 0; i < colors.length; i++) {
			if (((Peg) board[turn - 1][i + colors.length]) == null)
				return false;
			if (((Peg) board[turn - 1][i + colors.length]).isWhite())
				return false;
		}
		return true;
	}

	@Override
	public void initiateTurn() {
		/**
		 * System.out.println("Enter " + colors.length + " colors:"); String
		 * temp; for (int i = 0; i < colors.length; i++) { temp = in.next(); if
		 * (temp.toLowerCase().equals("quit")) System.exit(0); else
		 * board[turn][i] = new Marble(temp, i); }
		 */
		System.out.println("Turn " + turn);
		addPegs();
		if (PRINT_FOR_DEBUGGING) {
			System.out.print("Secret code: ");
			for (int i = 0; i < colors.length; i++) {
				System.out.print(board[0][i] + " ");
			}
			System.out.println();
			System.out.print("Guess: ");
			for (int i = 0; i < colors.length; i++) {
				System.out.print(board[turn][i] + " ");
			}
			System.out.println();
		}
		System.out.print("Hints: ");
		for (int i = colors.length; i < board[0].length; i++) {
			if (PRINT_FOR_DEBUGGING && board[turn][i] == null)
				System.out.print("none ");
			else
				System.out.print(board[turn][i] + " ");
		}
		System.out.println();
		turn++;
		/**
		 * if (isCorrect()) { youWin(); } else if (turn > 2) { youLose(); } else
		 * { // turn <= 2 initiateTurn(); }
		 */

	}

	public String secretCode() {
		String x = "";
		for (int i = 0; i < colors.length; i++) {
			x += board[0][i] + " ";
		}
		return x;
	}

	public String getHints() {
		String x = "";
		for (int i = colors.length; i < board[0].length; i++) {
			if (PRINT_FOR_DEBUGGING && board[turn - 1][i] == null)
				x += "none ";
			else
				x += board[turn - 1][i] + " ";
		}
		return x;
	}
}
