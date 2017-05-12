import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ItemListener, ActionListener {
	public Mastermind game;
	
	String[] colors = {"none", "red", "blue", "green", "yellow"};
	ImageIcon[] marbles = {new ImageIcon(), new ImageIcon("Mastermind/images/Red.jpg"), new ImageIcon("Mastermind/images/Blue.jpg"), new ImageIcon("Mastermind/images/Green.jpg"), new ImageIcon("Mastermind/images/Yellow.jpg")};
	
	JLabel turnCount;
	public JTextPane messageBox = new JTextPane();
	
	JPanel buttonBox = new JPanel();
		JButton go = new JButton("Go"), reset = new JButton("Reset");
	
	JPanel a1 = new JPanel(), a2 = new JPanel(), a3 = new JPanel(), a4 = new JPanel();
		JLabel a1M = new JLabel(), a2M = new JLabel(), a3M = new JLabel(), a4M = new JLabel();
		JComboBox<String> a1L = new JComboBox<String> (colors), a2L = new JComboBox<String> (colors), a3L = new JComboBox<String> (colors), a4L = new JComboBox<String> (colors);
	
	JPanel b1 = new JPanel(), b2 = new JPanel(), b3 = new JPanel(), b4 = new JPanel();
		JLabel b1M = new JLabel(), b2M = new JLabel(), b3M = new JLabel(), b4M = new JLabel();
		JComboBox<String> b1L = new JComboBox<String> (colors), b2L = new JComboBox<String> (colors), b3L = new JComboBox<String> (colors), b4L = new JComboBox<String> (colors);
		
	JPanel c1 = new JPanel(), c2 = new JPanel(), c3 = new JPanel(), c4 = new JPanel();
		JLabel c1M = new JLabel(), c2M = new JLabel(), c3M = new JLabel(), c4M = new JLabel();
		JComboBox<String> c1L = new JComboBox<String> (colors), c2L = new JComboBox<String> (colors), c3L = new JComboBox<String> (colors), c4L = new JComboBox<String> (colors);
		
	JPanel d1 = new JPanel(), d2 = new JPanel(), d3 = new JPanel(), d4 = new JPanel();
		JLabel d1M = new JLabel(), d2M = new JLabel(), d3M = new JLabel(), d4M = new JLabel();
		JComboBox<String> d1L = new JComboBox<String> (colors), d2L = new JComboBox<String> (colors), d3L = new JComboBox<String> (colors), d4L = new JComboBox<String> (colors);

	JPanel e1 = new JPanel(), e2 = new JPanel(), e3 = new JPanel(), e4 = new JPanel();
		JLabel e1M = new JLabel(), e2M = new JLabel(), e3M = new JLabel(), e4M = new JLabel();
		JComboBox<String> e1L = new JComboBox<String> (colors), e2L = new JComboBox<String> (colors), e3L = new JComboBox<String> (colors), e4L = new JComboBox<String> (colors);

	JPanel f1 = new JPanel(), f2 = new JPanel(), f3 = new JPanel(), f4 = new JPanel();
		JLabel f1M = new JLabel(), f2M = new JLabel(), f3M = new JLabel(), f4M = new JLabel();
		JComboBox<String> f1L = new JComboBox<String> (colors), f2L = new JComboBox<String> (colors), f3L = new JComboBox<String> (colors), f4L = new JComboBox<String> (colors);

	JPanel g1 = new JPanel(), g2 = new JPanel(), g3 = new JPanel(), g4 = new JPanel();
		JLabel g1M = new JLabel(), g2M = new JLabel(), g3M = new JLabel(), g4M = new JLabel();
		JComboBox<String> g1L = new JComboBox<String> (colors), g2L = new JComboBox<String> (colors), g3L = new JComboBox<String> (colors), g4L = new JComboBox<String> (colors);
		
	JPanel h1 = new JPanel(), h2 = new JPanel(), h3 = new JPanel(), h4 = new JPanel();
		JLabel h1M = new JLabel(), h2M = new JLabel(), h3M = new JLabel(), h4M = new JLabel();
		JComboBox<String> h1L = new JComboBox<String> (colors), h2L = new JComboBox<String> (colors), h3L = new JComboBox<String> (colors), h4L = new JComboBox<String> (colors);
		
	JPanel j1 = new JPanel(), j2 = new JPanel(), j3 = new JPanel(), j4 = new JPanel();
		JLabel j1M = new JLabel(), j2M = new JLabel(), j3M = new JLabel(), j4M = new JLabel();
		JComboBox<String> j1L = new JComboBox<String> (colors), j2L = new JComboBox<String> (colors), j3L = new JComboBox<String> (colors), j4L = new JComboBox<String> (colors);
	
	JPanel k1 = new JPanel(), k2 = new JPanel(), k3 = new JPanel(), k4 = new JPanel();
		JLabel k1M = new JLabel(), k2M = new JLabel(), k3M = new JLabel(), k4M = new JLabel();
		JComboBox<String> k1L = new JComboBox<String> (colors), k2L = new JComboBox<String> (colors), k3L = new JComboBox<String> (colors), k4L = new JComboBox<String> (colors);

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
		
		c1L.addItemListener(this);	c1L.setEnabled(false);
		c2L.addItemListener(this);	c2L.setEnabled(false);
		c3L.addItemListener(this);	c3L.setEnabled(false);
		c4L.addItemListener(this);	c4L.setEnabled(false);
		
		d1L.addItemListener(this);	d1L.setEnabled(false);
		d2L.addItemListener(this);	d2L.setEnabled(false);
		d3L.addItemListener(this);	d3L.setEnabled(false);
		d4L.addItemListener(this);	d4L.setEnabled(false);
		
		e1L.addItemListener(this);	e1L.setEnabled(false);
		e2L.addItemListener(this);	e2L.setEnabled(false);
		e3L.addItemListener(this);	e3L.setEnabled(false);
		e4L.addItemListener(this);	e4L.setEnabled(false);
		
		f1L.addItemListener(this);	f1L.setEnabled(false);
		f2L.addItemListener(this);	f2L.setEnabled(false);
		f3L.addItemListener(this);	f3L.setEnabled(false);
		f4L.addItemListener(this);	f4L.setEnabled(false);
		
		g1L.addItemListener(this);	g1L.setEnabled(false);
		g2L.addItemListener(this);	g2L.setEnabled(false);
		g3L.addItemListener(this);	g3L.setEnabled(false);
		g4L.addItemListener(this);	g4L.setEnabled(false);
		
		h1L.addItemListener(this);	h1L.setEnabled(false);
		h2L.addItemListener(this);	h2L.setEnabled(false);
		h3L.addItemListener(this);	h3L.setEnabled(false);
		h4L.addItemListener(this);	h4L.setEnabled(false);
		
		j1L.addItemListener(this);	j1L.setEnabled(false);
		j2L.addItemListener(this);	j2L.setEnabled(false);
		j3L.addItemListener(this);	j3L.setEnabled(false);
		j4L.addItemListener(this);	j4L.setEnabled(false);
		
		k1L.addItemListener(this);	k1L.setEnabled(false);
		k2L.addItemListener(this);	k2L.setEnabled(false);
		k3L.addItemListener(this);	k3L.setEnabled(false);
		k4L.addItemListener(this);	k4L.setEnabled(false);
		
		createButtonBox(buttonBox, turnCount, go, reset, messageBox);
		createBox(a1, a1L, a1M);
		createBox(a2, a2L, a2M);
		createBox(a3, a3L, a3M);
		createBox(a4, a4L, a4M);
		
		createBox(b1, b1L, b1M);
		createBox(b2, b2L, b2M);
		createBox(b3, b3L, b3M);
		createBox(b4, b4L, b4M);
		
		createBox(c1, c1L, c1M);
		createBox(c2, c2L, c2M);
		createBox(c3, c3L, c3M);
		createBox(c4, c4L, c4M);
		
		createBox(d1, d1L, d1M);
		createBox(d2, d2L, d2M);
		createBox(d3, d3L, d3M);
		createBox(d4, d4L, d4M);
		
		createBox(e1, e1L, e1M);
		createBox(e2, e2L, e2M);
		createBox(e3, e3L, e3M);
		createBox(e4, e4L, e4M);
		
		createBox(f1, f1L, f1M);
		createBox(f2, f2L, f2M);
		createBox(f3, f3L, f3M);
		createBox(f4, f4L, f4M);
		
		createBox(g1, g1L, g1M);
		createBox(g2, g2L, g2M);
		createBox(g3, g3L, g3M);
		createBox(g4, g4L, g4M);
		
		createBox(h1, h1L, h1M);
		createBox(h2, h2L, h2M);
		createBox(h3, h3L, h3M);
		createBox(h4, h4L, h4M);
		
		createBox(j1, j1L, j1M);
		createBox(j2, j2L, j2M);
		createBox(j3, j3L, j3M);
		createBox(j4, j4L, j4M);
		
		createBox(k1, k1L, k1M);
		createBox(k2, k2L, k2M);
		createBox(k3, k3L, k3M);
		createBox(k4, k4L, k4M);
		
		createLayout(a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4, e1, e2, e3, e4,
				f1, f2, f3, f4, g1, g2, g3, g4, h1, h2, h3, h4, j1, j2, j3, j4, k1, k2, k3, k4, buttonBox);
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
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[8])
								.addComponent(arg[9])
								.addComponent(arg[10])
								.addComponent(arg[11])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[12])
								.addComponent(arg[13])
								.addComponent(arg[14])
								.addComponent(arg[15])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[16])
								.addComponent(arg[17])
								.addComponent(arg[18])
								.addComponent(arg[19])
						)
						//row f
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[20])
								.addComponent(arg[21])
								.addComponent(arg[22])
								.addComponent(arg[23])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[24])
								.addComponent(arg[25])
								.addComponent(arg[26])
								.addComponent(arg[27])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[28])
								.addComponent(arg[29])
								.addComponent(arg[30])
								.addComponent(arg[31])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[32])
								.addComponent(arg[33])
								.addComponent(arg[34])
								.addComponent(arg[35])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[36])
								.addComponent(arg[37])
								.addComponent(arg[38])
								.addComponent(arg[39])
						)
				)
				.addComponent(arg[40])
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
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[8])
							.addComponent(arg[9])
							.addComponent(arg[10])
							.addComponent(arg[11])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[12])
							.addComponent(arg[13])
							.addComponent(arg[14])
							.addComponent(arg[15])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[16])
							.addComponent(arg[17])
							.addComponent(arg[18])
							.addComponent(arg[19])
					)
					//row f
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[20])
							.addComponent(arg[21])
							.addComponent(arg[22])
							.addComponent(arg[23])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[24])
							.addComponent(arg[25])
							.addComponent(arg[26])
							.addComponent(arg[27])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[28])
							.addComponent(arg[29])
							.addComponent(arg[30])
							.addComponent(arg[31])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[32])
							.addComponent(arg[33])
							.addComponent(arg[34])
							.addComponent(arg[35])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[36])
							.addComponent(arg[37])
							.addComponent(arg[38])
							.addComponent(arg[39])
					)
				)
				.addComponent(arg[40])
		);
		
		pack();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(a1L)) {
			a1M.setIcon(marbles[a1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(a2L)) {
			a2M.setIcon(marbles[a2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(a3L)) {
			a3M.setIcon(marbles[a3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(a4L)) {
			a4M.setIcon(marbles[a4L.getSelectedIndex()]);
		}
		
		else if (e.getSource().equals(b1L)) {
			b1M.setIcon(marbles[b1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(b2L)) {
			b2M.setIcon(marbles[b2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(b3L)) {
			b3M.setIcon(marbles[b3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(b4L)) {
			b4M.setIcon(marbles[b4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(c1L)) {
			c1M.setIcon(marbles[c1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(c2L)) {
			c2M.setIcon(marbles[c2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(c3L)) {
			c3M.setIcon(marbles[c3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(c4L)) {
			c4M.setIcon(marbles[c4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(d1L)) {
			d1M.setIcon(marbles[d1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(d2L)) {
			d2M.setIcon(marbles[d2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(d3L)) {
			d3M.setIcon(marbles[d3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(d4L)) {
			d4M.setIcon(marbles[d4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(e1L)) {
			e1M.setIcon(marbles[e1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(e2L)) {
			e2M.setIcon(marbles[e2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(e3L)) {
			e3M.setIcon(marbles[e3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(e4L)) {
			e4M.setIcon(marbles[e4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(f1L)) {
			f1M.setIcon(marbles[f1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(f2L)) {
			f2M.setIcon(marbles[f2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(f3L)) {
			f3M.setIcon(marbles[f3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(f4L)) {
			f4M.setIcon(marbles[f4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(g1L)) {
			g1M.setIcon(marbles[g1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(g2L)) {
			g2M.setIcon(marbles[g2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(g3L)) {
			g3M.setIcon(marbles[g3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(g4L)) {
			g4M.setIcon(marbles[g4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(h1L)) {
			h1M.setIcon(marbles[h1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(h2L)) {
			h2M.setIcon(marbles[h2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(h3L)) {
			h3M.setIcon(marbles[h3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(h4L)) {
			h4M.setIcon(marbles[h4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(j1L)) {
			j1M.setIcon(marbles[j1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(j2L)) {
			j2M.setIcon(marbles[j2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(j3L)) {
			j3M.setIcon(marbles[j3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(j4L)) {
			j4M.setIcon(marbles[j4L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(k1L)) {
			k1M.setIcon(marbles[k1L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(k2L)) {
			k2M.setIcon(marbles[k2L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(k3L)) {
			k3M.setIcon(marbles[k3L.getSelectedIndex()]);
		}
		else if (e.getSource().equals(k4L)) {
			k4M.setIcon(marbles[k4L.getSelectedIndex()]);
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
					turnCount.setText("Turn 2");
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
					turnCount.setText("Turn 3");
					messageBox.setText(game.getHints());
					
					b1L.setEnabled(false);
					b2L.setEnabled(false);
					b3L.setEnabled(false);
					b4L.setEnabled(false);
					
					c1L.setEnabled(true);
					c2L.setEnabled(true);
					c3L.setEnabled(true);
					c4L.setEnabled(true);
					break;
				case 3:
					game.board[3][0] = new Marble((String) c1L.getSelectedItem(), 0);
					game.board[3][1] = new Marble((String) c2L.getSelectedItem(), 1);
					game.board[3][2] = new Marble((String) c3L.getSelectedItem(), 2);
					game.board[3][3] = new Marble((String) c4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn 4");
					messageBox.setText(game.getHints());
					
					c1L.setEnabled(false);
					c2L.setEnabled(false);
					c3L.setEnabled(false);
					c4L.setEnabled(false);
					
					d1L.setEnabled(true);
					d2L.setEnabled(true);
					d3L.setEnabled(true);
					d4L.setEnabled(true);
					break;
				case 4:
					game.board[4][0] = new Marble((String) d1L.getSelectedItem(), 0);
					game.board[4][1] = new Marble((String) d2L.getSelectedItem(), 1);
					game.board[4][2] = new Marble((String) d3L.getSelectedItem(), 2);
					game.board[4][3] = new Marble((String) d4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 5);
					messageBox.setText(game.getHints());
					
					d1L.setEnabled(false);
					d2L.setEnabled(false);
					d3L.setEnabled(false);
					d4L.setEnabled(false);
					
					e1L.setEnabled(true);
					e2L.setEnabled(true);
					e3L.setEnabled(true);
					e4L.setEnabled(true);
					break;	
				case 5:
					game.board[5][0] = new Marble((String) e1L.getSelectedItem(), 0);
					game.board[5][1] = new Marble((String) e2L.getSelectedItem(), 1);
					game.board[5][2] = new Marble((String) e3L.getSelectedItem(), 2);
					game.board[5][3] = new Marble((String) e4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 6);
					messageBox.setText(game.getHints());
					
					e1L.setEnabled(false);
					e2L.setEnabled(false);
					e3L.setEnabled(false);
					e4L.setEnabled(false);
					
					f1L.setEnabled(true);
					f2L.setEnabled(true);
					f3L.setEnabled(true);
					f4L.setEnabled(true);
					break;
				case 6:
					game.board[6][0] = new Marble((String) f1L.getSelectedItem(), 0);
					game.board[6][1] = new Marble((String) f2L.getSelectedItem(), 1);
					game.board[6][2] = new Marble((String) f3L.getSelectedItem(), 2);
					game.board[6][3] = new Marble((String) f4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 7);
					messageBox.setText(game.getHints());
					
					f1L.setEnabled(false);
					f2L.setEnabled(false);
					f3L.setEnabled(false);
					f4L.setEnabled(false);
					
					g1L.setEnabled(true);
					g2L.setEnabled(true);
					g3L.setEnabled(true);
					g4L.setEnabled(true);
					break;
				case 7:
					game.board[7][0] = new Marble((String) g1L.getSelectedItem(), 0);
					game.board[7][1] = new Marble((String) g2L.getSelectedItem(), 1);
					game.board[7][2] = new Marble((String) g3L.getSelectedItem(), 2);
					game.board[7][3] = new Marble((String) g4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 8);
					messageBox.setText(game.getHints());
					
					g1L.setEnabled(false);
					g2L.setEnabled(false);
					g3L.setEnabled(false);
					g4L.setEnabled(false);
					
					h1L.setEnabled(true);
					h2L.setEnabled(true);
					h3L.setEnabled(true);
					h4L.setEnabled(true);
					break;
				case 8:
					game.board[8][0] = new Marble((String) h1L.getSelectedItem(), 0);
					game.board[8][1] = new Marble((String) h2L.getSelectedItem(), 1);
					game.board[8][2] = new Marble((String) h3L.getSelectedItem(), 2);
					game.board[8][3] = new Marble((String) h4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 9);
					messageBox.setText(game.getHints());
					
					h1L.setEnabled(false);
					h2L.setEnabled(false);
					h3L.setEnabled(false);
					h4L.setEnabled(false);
					
					j1L.setEnabled(true);
					j2L.setEnabled(true);
					j3L.setEnabled(true);
					j4L.setEnabled(true);
					break;
				case 9:
					game.board[9][0] = new Marble((String) j1L.getSelectedItem(), 0);
					game.board[9][1] = new Marble((String) j2L.getSelectedItem(), 1);
					game.board[9][2] = new Marble((String) j3L.getSelectedItem(), 2);
					game.board[9][3] = new Marble((String) j4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn " + 10);
					messageBox.setText(game.getHints());
					
					j1L.setEnabled(false);
					j2L.setEnabled(false);
					j3L.setEnabled(false);
					j4L.setEnabled(false);
					
					k1L.setEnabled(true);
					k2L.setEnabled(true);
					k3L.setEnabled(true);
					k4L.setEnabled(true);
					break;
				case 10:
					game.board[10][0] = new Marble((String) k1L.getSelectedItem(), 0);
					game.board[10][1] = new Marble((String) k2L.getSelectedItem(), 1);
					game.board[10][2] = new Marble((String) k3L.getSelectedItem(), 2);
					game.board[10][3] = new Marble((String) k4L.getSelectedItem(), 3);
					game.initiateTurn();
					turnCount.setText("Turn -");
					messageBox.setText(game.getHints());
					
					k1L.setEnabled(false);
					k2L.setEnabled(false);
					k3L.setEnabled(false);
					k4L.setEnabled(false);
					
					go.setEnabled(false);
					break;
			}
			if (game.isCorrect()) {
				game.youWin();
			} 
			else if (game.turn > game.turnLimit) {
				game.youLose();
			}
		}
		else if (e.getSource().equals(reset)) {
			this.game = new Mastermind(2);
			turnCount.setText("Turn " + game.turn);
			a1L.setSelectedIndex(0); a2L.setSelectedIndex(0); a3L.setSelectedIndex(0); a4L.setSelectedIndex(0);
			b1L.setSelectedIndex(0); b2L.setSelectedIndex(0); b3L.setSelectedIndex(0); b4L.setSelectedIndex(0);
			c1L.setSelectedIndex(0); c2L.setSelectedIndex(0); c3L.setSelectedIndex(0); c4L.setSelectedIndex(0);
			messageBox.setText("This box contains hints for now.");
			
			a1L.setEnabled(true);
			a2L.setEnabled(true);
			a3L.setEnabled(true);
			a4L.setEnabled(true);
			
			b1L.setEnabled(false);
			b2L.setEnabled(false);
			b3L.setEnabled(false);
			b4L.setEnabled(false);
			
			c1L.setEnabled(false);
			c2L.setEnabled(false);
			c3L.setEnabled(false);
			c4L.setEnabled(false);
			
			d1L.setEnabled(false);
			d2L.setEnabled(false);
			d3L.setEnabled(false);
			d4L.setEnabled(false);
			
			e1L.setEnabled(false);
			e2L.setEnabled(false);
			e3L.setEnabled(false);
			e4L.setEnabled(false);
			
			f1L.setEnabled(false);
			f2L.setEnabled(false);
			f3L.setEnabled(false);
			f4L.setEnabled(false);
			
			g1L.setEnabled(false);
			g2L.setEnabled(false);
			g3L.setEnabled(false);
			g4L.setEnabled(false);
			
			h1L.setEnabled(false);
			h2L.setEnabled(false);
			h3L.setEnabled(false);
			h4L.setEnabled(false);
			
			j1L.setEnabled(false);
			j2L.setEnabled(false);
			j3L.setEnabled(false);
			j4L.setEnabled(false);
			
			k1L.setEnabled(false);
			k2L.setEnabled(false);
			k3L.setEnabled(false);
			k4L.setEnabled(false);
		}
	}
	
}
