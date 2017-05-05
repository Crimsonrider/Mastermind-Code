import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Board {
	String[] colors = { "red", "blue", "green", "yellow" };

	public Mastermind() {
		Random rand = new Random();
		for (int i = 0; i < board[0].length; i++) {
			int index = rand.nextInt(colors.length);
			Marble a = new Marble(colors[index], i);
			board[0][i] = a;
		}
		initiateTurn();
	}

	@Override
	public void addPegs() {
		// TODO Auto-generated method stub

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
		for (int i = 0; i < board[0].length; i++) {
			board[turn][i] = new Marble(in.next(), i);
		}
		for(int i = 0; i < board[0].length; i++){
			System.out.print(board[turn][i] + " ");
		}
		System.out.println();
		turn ++;
		if (turn <= 2) {
			initiateTurn();
		}
	}
}
