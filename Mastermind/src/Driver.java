import java.awt.EventQueue;

public class Driver {
	public static GUI currentGame;

	public static void main(String[] args) {
		
		 EventQueue.invokeLater(() -> {
				currentGame = new GUI();
				currentGame.setVisible(true);
	            
	        });
			
	}

}
