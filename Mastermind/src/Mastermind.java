import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a game of Mastermind with 10 turns
 *
 */
public class Mastermind extends Board {
	private final boolean PRINT_FOR_DEBUGGING = true;

	String[] colors = { "red", "blue", "green", "yellow" };
	// four color options of the marbles
	private int[] secretColorCount = { 0, 0, 0, 0 };
	// indexes correspond to colors array, tells how many times the color it
	// corresponds to is in the secret code
	private Scanner in = new Scanner(System.in); // used to read input

	/**
	 * This constructor creates the secret code using a Random object and a
	 * for-loop and initializes secretColorCount. The secret code is the first
	 * four terms in the first row of the board array.
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
	 * This constructor creates the secret code using a Random object based on
	 * the given seed and a for-loop and initializes secretColorCount. The
	 * secret code is the first four terms in the first row of the board array.
	 * 
	 * @param theSeed
	 *            -the seed for the Random object
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
	 * Returns a copy of secretColorCount
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
	 * Adds Pegs based on the user's guess. Black Pegs indicate a Marble is
	 * perfect and white Pegs indicate a Marble is the correct colour but in the
	 * incorrect position. No Peg will be added if a Marble is completely wrong.
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
	 * Checks the Pegs in the previous row to see if the user's guess was
	 * correct.
	 * 
	 * @return true if all Pegs are black; false otherwise
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
	 * Conducts the turn by calling addPegs(), printing the secret code & guess
	 * if desired, printing the hints, and incrementing turn
	 * Precondition: Marbles have been added to the current row
	 */
	public void initiateTurn() {

		// System.out.println("Enter " + colors.length + " colors:");
		// String temp;
		// for (int i = 0; i < colors.length; i++) {
		// temp = in.next();
		// if (temp.toLowerCase().equals("quit"))
		// System.exit(0);
		// else
		// board[turn][i] = new Marble(temp);
		// }

		addPegs();

		System.out.println("Turn " + turn);

		if (PRINT_FOR_DEBUGGING) {
			System.out.println("Secret code:" + secretCode());
			System.out.print("Guess: " + getGuess());
		}

		System.out.println("Hints: " + getHints());

		turn++;

	}

	/**
	 * Uses secCode(int) to return the secret code as a String
	 * 
	 * @return the colors of the four marbles in the secret code
	 */
	public String secretCode() {
		return secCode(colors.length - 1);
	}

	/**
	 * Recursive method to return the secret code as a String
	 * @param index - index of the Marble to begin at
	 * @return the colors of the four marbles in the secret code
	 */
	public String secCode(int index) {
		if (index >= 0) {
			return secCode(index - 1) + " " + board[0][index];
		}
		return " ";
	}

	/**
	 * Returns the guess inputted by the user as a String
	 * 
	 * @return the colors of the four marbles in the last guess
	 */
	public String getGuess() {
		String x = "";
		for (int i = 0; i < colors.length; i++) {
			x += board[turn][i] + " ";
		}
		return x + "\n";
	}

	/**
	 * Returns hints for the last guess as a String
	 * 
	 * @return the colors of the Pegs in the last turn
	 */
	public String getHints() {
		String x = "";
		for (int i = 4; i < 8; i++) {
			if (PRINT_FOR_DEBUGGING && board[turn][i] == null)
				x += "none ";
			else
				x += board[turn][i].getColor() + " ";
		}
		return x;
	}

	/**
	 * Returns the count of black, white, and null Pegs of the last turn 
	 * @return an array with the number of black pegs, white pegs, and null pegs
	 *         respectively, from the hints of the last turn taken
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
