import java.awt.EventQueue;

public class Driver {
	

	public static void main(String[] args) {
		 Mastermind test = new Mastermind();
		
		 EventQueue.invokeLater(() -> {
			 
	            GUI ex;
				ex = new GUI(test);
				ex.setVisible(true);
	            
	        });
		 

			test.initiateTurn();
			
	}

}
