import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Board {
	String[] colors = { "red", "blue", "green", "yellow" };

	public Mastermind() {
		Random rand = new Random();
		for (int i = 0; i < colors.length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index], i);
			board[0][i] = a;
		}
		initiateTurn();
	}

	@Override
	public void addPegs() {
		int r = 0;
		int b = 0;
		int g = 0;
		int y = 0;
		for (int i = 0; i < colors.length; i++) {
			if (board[0][i].color.equals("red")) {
				r++;
			}
			if (board[0][i].color.equals("blue")) {
				b++;
			}
			if (board[0][i].color.equals("green")) {
				g++;
			}
			if (board[0][i].color.equals("yellow")) {
				y++;
			}
		}
		for (int i = 0; i < colors.length; i++) {
			if (board[turn][i].color.equals(board[0][i].color)) {
				board[turn][i + 4] = new Peg("black");
				if (board[0][i].color.equals("red")) {
					r--;
				}
				if (board[0][i].color.equals("blue")) {
					b--;
				}
				if (board[0][i].color.equals("green")) {
					g--;
				}
				if (board[0][i].color.equals("yellow")) {
					y--;
				}
			}
		}
		for (int i = 0; i < colors.length; i++) {

			if (!board[turn][i].color.equals(board[0][i])) {

				if (board[turn][i].color.equals("red")) {
					if (r >= 1) {
						board[turn][i + 4] = new Peg("white");
					}
				}
				if (board[turn][i].color.equals("blue")) {
					if (b >= 1) {
						board[turn][i + 4] = new Peg("white");
					}
				}
				if (board[turn][i].color.equals("green")) {
					if (g >= 1) {
						board[turn][i + 4] = new Peg("white");
					}
				}
				if (board[turn][i].color.equals("yellow")) {
					if (y >= 1) {
						board[turn][i + 4] = new Peg("white");
					}
				}
			}
		}
	}

	@Override
	public boolean isCorrect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initiateTurn() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 4 colors:");
		for (int i = 0; i < colors.length; i++) {
			board[turn][i] = new Marble(in.next(), i);
		}
		addPegs();
		System.out.println("Secret code");
		for (int i = 0; i < colors.length; i++) {
			System.out.print(board[0][i] + " ");
		}
		System.out.println();
		System.out.print("Guess:");
		for (int i = 0; i < colors.length; i++) {
			System.out.print(board[turn][i] + " ");
		}
		System.out.print("Hints:");
		for (int i = 4; i < board[0].length; i++) {
			System.out.print(board[turn][i] + " ");
		}
		System.out.println();
		turn++;
		if (turn <= 2) {
			initiateTurn();
		}
	}
}
