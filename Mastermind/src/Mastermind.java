import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Board {
	private final boolean PRINT_FOR_DEBUGGING = true;

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
		// Random rand = new Random(SEED);
		Random rand = new Random();
		for (int i = 0; i < colors.length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index]);
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
			Marble a = new Marble(colors[index]);
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
	/**
	 * This method
	 */
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

				// for (int j = 0; j < colors.length; j++) {
				// // subtract from the count of the corresponding color
				// if (parallelM.getColor().equals(colors[j]))
				// colorCt[j] = colorCt[j] - 1;
				// }
				List<String> list = Arrays.asList(colors);
				Iterator<String> it = list.iterator();
				int n = 0;
				while (it.hasNext()) {
					if (parallelM.getColor().equals(it.next())) {
						System.out.println(colorCt[n]);
						colorCt[n] = colorCt[n] - 1;
						System.out.println(colorCt[n]);
					}
					n++;
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
	/**
	 * This method checks if the marble is in the right color and place
	 * 
	 * @return true if a black peg must be placed
	 * @return false if a white peg or no peg must be placed.
	 */
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
	/**
	 * This method starts the next turn
	 * 
	 * 
	 */
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
			System.out.println("Secret code: " + secretCode());
			System.out.print("Guess: ");
			for (int i = 0; i < colors.length; i++) {
				System.out.print(board[turn][i] + " ");
			}
			System.out.println();
		}
		System.out.println("Hints: " + getHints());
		turn++;

		if (isCorrect()) {
			youWin();
		} else if (turn > 10) {
			youLose();
		} else {
			// turn <= 10 initiateTurn();
		}

	}

	/**
	 * returns the secret code by calling the recursive method secCode(index)
	 * 
	 * @return the colors of the four marbles in the secret code
	 */
	public String secretCode() {
		return secCode(colors.length-1);
	}

	/**
	 * recursive method to return the secret code
	 * 
	 * @return the colors of the four marbles in the secret code
	 */
	public String secCode(int index) {
		if (index >= 0) {
			return secCode(index - 1) + " " + board[0][index];
		}
		return " ";
	}

	/**
	 * 
	 * @return the
	 */
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

	/**
	 * @return an array with the number of black pegs, white pegs, and null pegs
	 *         respectively, in the hints of the last turn taken
	 */
	public int[] getThePegs() {
		int[] temp = new int[] { 0, 0, 0 };
		for (int i = 0; i < 4; i++) {
			Peg x = (Peg) board[turn - 1][i + 4];
			if (x == null)
				temp[2]++;
			else if (x.isWhite())
				temp[1]++;
			else
				temp[0]++;
		}
		return temp;
	}
}
