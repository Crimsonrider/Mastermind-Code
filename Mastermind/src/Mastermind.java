import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Board {
	private final boolean PRINT_FOR_DEBUGGING = true;
	private final long SEED = 1;

	String[] colors = { "red", "blue", "green", "yellow" };
	private int[] secretColorCount = { 0, 0, 0, 0 };
	private Scanner in = new Scanner(System.in);

	public Mastermind() {
		Random rand = new Random(SEED);
		for (int i = 0; i < colors.length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index], i);
			board[0][i] = a;
			secretColorCount[index]++;
		}
	}

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

		for (int i = 0; i < colors.length; i++) {
			Marble x = (Marble) board[turn][i];
			Marble parallelM = (Marble) board[0][i];

			if (x.matches(parallelM)) {

				board[turn][i + colors.length] = new Peg("black");

				for (int j = 0; j < colors.length; j++) {
					if (parallelM.getColor().equals(colors[j]))
						colorCt[j] = colorCt[j] - 1;
				}

				x.hasAMatch();
			}

		}

		// colorCt now contains the count for each marble color that is
		// available to be matched for a white peg

		for (int i = 0; i < colors.length; i++) {
			Marble x = (Marble) board[turn][i];
			if (x.hasBeenMatched())
				continue;

			for (int j = 0; j < colors.length; j++) {
				if (x.getColor().equals(colors[j]) && colorCt[j] > 0)
					board[turn][i + colors.length] = new Peg("white");
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

		System.out.println("Enter " + colors.length + " colors:");
		String temp;
		for (int i = 0; i < colors.length; i++) {
			temp = in.next();
			if (temp.toLowerCase().equals("quit"))
				System.exit(0);
			else
				board[turn][i] = new Marble(temp, i);
		}
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
			System.out.print("Hints: ");
			for (int i = colors.length; i < board[0].length; i++) {
				if (board[turn][i] == null)
					System.out.print("none ");
				else
					System.out.print(board[turn][i] + " ");
			}
			System.out.println();
		}

		turn++;
		if (isCorrect()) {
			youWin();
		} else if (turn > 2) {
			youLose();
		} else { // turn <= 2
			initiateTurn();
		}
	}
}
