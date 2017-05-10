import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ItemListener, ActionListener {
	public Mastermind game;
	
	String[] colors = {"none", "red", "blue", "green", "yellow"};
	JLabel turnCount;
	public JTextPane messageBox = new JTextPane();
	
	JPanel buttonBox = new JPanel();
		JButton go = new JButton("Go"), reset = new JButton("Reset");
	
	JPanel a1 = new JPanel(), a2 = new JPanel(), a3 = new JPanel(), a4 = new JPanel();
		JLabel a1M = new JLabel("Empty"), a2M = new JLabel("Empty"), a3M = new JLabel("Empty"), a4M = new JLabel("Empty");
		JComboBox<String> a1L = new JComboBox<String> (colors), a2L = new JComboBox<String> (colors), a3L = new JComboBox<String> (colors), a4L = new JComboBox<String> (colors);
	
	JPanel b1 = new JPanel(), b2 = new JPanel(), b3 = new JPanel(), b4 = new JPanel();
		JLabel b1M = new JLabel("Empty"), b2M = new JLabel("Empty"), b3M = new JLabel("Empty"), b4M = new JLabel("Empty");
		JComboBox<String> b1L = new JComboBox<String> (colors), b2L = new JComboBox<String> (colors), b3L = new JComboBox<String> (colors), b4L = new JComboBox<String> (colors);
		
	public GUI() {
		setTitle("Mastermind");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ImageIcon icon = new ImageIcon("images/Other/icon.png");
		//setIconImage(icon.getImage());
		this.game = new Mastermind(1);
		turnCount = new JLabel("Turn " + game.turn);
		
		initUI();
	}
	
	public void initUI() {
		messageBox.setText("This box contains hints for now.");
		messageBox.setEditable(false);
		
		go.addActionListener(this);
		reset.addActionListener(this);
		
		a1L.addItemListener(this);
		a2L.addItemListener(this);
		a3L.addItemListener(this);
		a4L.addItemListener(this);
		
		b1L.addItemListener(this);	b1L.setEnabled(false);
		b2L.addItemListener(this);	b2L.setEnabled(false);
		b3L.addItemListener(this);	b3L.setEnabled(false);
		b4L.addItemListener(this);	b4L.setEnabled(false);
		
		createButtonBox(buttonBox, turnCount, go, reset, messageBox);
		createBox(a1, a1L, a1M);
		createBox(a2, a2L, a2M);
		createBox(a3, a3L, a3M);
		createBox(a4, a4L, a4M);
		
		createBox(b1, b1L, b1M);
		createBox(b2, b2L, b2M);
		createBox(b3, b3L, b3M);
		createBox(b4, b4L, b4M);
		
		createLayout(a1, a2, a3, a4, b1, b2, b3, b4, buttonBox);
	}
	
	private void createButtonBox(JComponent... arg) {
		GroupLayout gl = new GroupLayout(arg[0]);
		arg[0].setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[1])
				.addComponent(arg[2])
				.addComponent(arg[3])
				.addComponent(arg[4])
		);
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[1])
				.addComponent(arg[2])
				.addComponent(arg[3])
				.addComponent(arg[4])
			);
	}
	
	private void createBox(JComponent... arg) {
		GroupLayout gl = new GroupLayout(arg[0]);
		arg[0].setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[1])
				.addComponent(arg[2])
		);
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[1])
				.addComponent(arg[2])
			);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[0])
								.addComponent(arg[1])
								.addComponent(arg[2])
								.addComponent(arg[3])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[4])
								.addComponent(arg[5])
								.addComponent(arg[6])
								.addComponent(arg[7])
						)
				)
				.addComponent(arg[8])
		);

		gl.setVerticalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[0])
							.addComponent(arg[1])
							.addComponent(arg[2])
							.addComponent(arg[3])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[4])
							.addComponent(arg[5])
							.addComponent(arg[6])
							.addComponent(arg[7])
						)
				)
				.addComponent(arg[8])
		);
		
		pack();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(a1L)) {
			a1M.setText((String) a1L.getSelectedItem());
		}
		else if (e.getSource().equals(a2L)) {
			a2M.setText((String) a2L.getSelectedItem());
		}
		else if (e.getSource().equals(a3L)) {
			a3M.setText((String) a3L.getSelectedItem());
		}
		else if (e.getSource().equals(a4L)) {
			a4M.setText((String) a4L.getSelectedItem());
		}
		
		else if (e.getSource().equals(b1L)) {
			b1M.setText((String) b1L.getSelectedItem());
		}
		else if (e.getSource().equals(b2L)) {
			b2M.setText((String) b2L.getSelectedItem());
		}
		else if (e.getSource().equals(b3L)) {
			b3M.setText((String) b3L.getSelectedItem());
		}
		else if (e.getSource().equals(b4L)) {
			b4M.setText((String) b4L.getSelectedItem());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(go)) {
			switch(game.turn) {
				case 1:
					game.board[1][0] = new Marble((String) a1L.getSelectedItem(), 0);
					game.board[1][1] = new Marble((String) a2L.getSelectedItem(), 1);
					game.board[1][2] = new Marble((String) a3L.getSelectedItem(), 2);
					game.board[1][3] = new Marble((String) a4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + game.turn);
					messageBox.setText(game.getHints());
					
					a1L.setEnabled(false);
					a2L.setEnabled(false);
					a3L.setEnabled(false);
					a4L.setEnabled(false);
					
					b1L.setEnabled(true);
					b2L.setEnabled(true);
					b3L.setEnabled(true);
					b4L.setEnabled(true);
					break;
				case 2:
					game.board[2][0] = new Marble((String) b1L.getSelectedItem(), 0);
					game.board[2][1] = new Marble((String) b2L.getSelectedItem(), 1);
					game.board[2][2] = new Marble((String) b3L.getSelectedItem(), 2);
					game.board[2][3] = new Marble((String) b4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + game.turn);
					messageBox.setText(game.getHints());
					break;
			}
			if (game.isCorrect()) {
				game.youWin();
			} 
			else if (game.turn > 2) {
				game.youLose();
			}
		}
		else if (e.getSource().equals(reset)) {
			this.game = new Mastermind(2);
			turnCount.setText("Turn " + game.turn);
			a1L.setSelectedIndex(0); a2L.setSelectedIndex(0); a3L.setSelectedIndex(0); a4L.setSelectedIndex(0);
			b1L.setSelectedIndex(0); b2L.setSelectedIndex(0); b3L.setSelectedIndex(0); b4L.setSelectedIndex(0);
			messageBox.setText("This box contains hints for now.");
			
			a1L.setEnabled(true);
			a2L.setEnabled(true);
			a3L.setEnabled(true);
			a4L.setEnabled(true);
			
			b1L.setEnabled(false);
			b2L.setEnabled(false);
			b3L.setEnabled(false);
			b4L.setEnabled(false);
		}
	}
	
}
