import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ItemListener {
	public Mastermind game;
	
	public GUI(Mastermind game) {
		setTitle("Mastermind");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ImageIcon icon = new ImageIcon("images/Other/icon.png");
		//setIconImage(icon.getImage());
		this.game = game;
		
		initUI();
	}
	
	public void initUI() {
		JLabel x = new JLabel(game.secretCode());
		
		createLayout(x);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup().addComponent(arg[0])

		);

		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
		
		pack();
	}

	public void itemStateChanged(ItemEvent arg0) {

	}

}
