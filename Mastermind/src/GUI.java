import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
/**
 * This class creates the UI for the game.
 *
 */
public class GUI extends JFrame implements ItemListener, ActionListener {
	public Mastermind game; //the active game shown
	
	private String[] colors = {"none", "red", "blue", "green", "yellow"}; //used for the dropdown lists
	private ImageIcon[] marbles = {new ImageIcon(), new ImageIcon("images/Red.jpg"), 
			new ImageIcon("images/Blue.jpg"), new ImageIcon("images/Green.jpg"), 
			new ImageIcon("images/Yellow.jpg")}; //used to represent marbles
	
	private JPanel buttonBox = new JPanel(); //contains the indented items
		private JLabel turnCount; //displays current turn of the game; beyond 10 is -
		public JLabel messageBox = new JLabel(); //displays messages to the player such as on win or loss
		private JButton go = new JButton("Go"), reset = new JButton("Reset"); 
	
	private JPanel a1 = new JPanel(), a2 = new JPanel(), a3 = new JPanel(), a4 = new JPanel();
		private JLabel a1M = new JLabel(), a2M = new JLabel(), a3M = new JLabel(), a4M = new JLabel();
		private JComboBox<String> a1L = new JComboBox<String> (colors), a2L = new JComboBox<String> (colors), a3L = new JComboBox<String> (colors), a4L = new JComboBox<String> (colors);
		
	private JPanel b1 = new JPanel(), b2 = new JPanel(), b3 = new JPanel(), b4 = new JPanel();
		private JLabel b1M = new JLabel(), b2M = new JLabel(), b3M = new JLabel(), b4M = new JLabel();
		private JComboBox<String> b1L = new JComboBox<String> (colors), b2L = new JComboBox<String> (colors), b3L = new JComboBox<String> (colors), b4L = new JComboBox<String> (colors);
	
	private JPanel c1 = new JPanel(), c2 = new JPanel(), c3 = new JPanel(), c4 = new JPanel();
		private JLabel c1M = new JLabel(), c2M = new JLabel(), c3M = new JLabel(), c4M = new JLabel();
		private JComboBox<String> c1L = new JComboBox<String> (colors), c2L = new JComboBox<String> (colors), c3L = new JComboBox<String> (colors), c4L = new JComboBox<String> (colors);
		
	private JPanel d1 = new JPanel(), d2 = new JPanel(), d3 = new JPanel(), d4 = new JPanel();
		private JLabel d1M = new JLabel(), d2M = new JLabel(), d3M = new JLabel(), d4M = new JLabel();
		private JComboBox<String> d1L = new JComboBox<String> (colors), d2L = new JComboBox<String> (colors), d3L = new JComboBox<String> (colors), d4L = new JComboBox<String> (colors);

	private JPanel e1 = new JPanel(), e2 = new JPanel(), e3 = new JPanel(), e4 = new JPanel();
		private JLabel e1M = new JLabel(), e2M = new JLabel(), e3M = new JLabel(), e4M = new JLabel();
		private JComboBox<String> e1L = new JComboBox<String> (colors), e2L = new JComboBox<String> (colors), e3L = new JComboBox<String> (colors), e4L = new JComboBox<String> (colors);

	private JPanel f1 = new JPanel(), f2 = new JPanel(), f3 = new JPanel(), f4 = new JPanel();
		private JLabel f1M = new JLabel(), f2M = new JLabel(), f3M = new JLabel(), f4M = new JLabel();
		private JComboBox<String> f1L = new JComboBox<String> (colors), f2L = new JComboBox<String> (colors), f3L = new JComboBox<String> (colors), f4L = new JComboBox<String> (colors);

	private JPanel g1 = new JPanel(), g2 = new JPanel(), g3 = new JPanel(), g4 = new JPanel();
		private JLabel g1M = new JLabel(), g2M = new JLabel(), g3M = new JLabel(), g4M = new JLabel();
		private JComboBox<String> g1L = new JComboBox<String> (colors), g2L = new JComboBox<String> (colors), g3L = new JComboBox<String> (colors), g4L = new JComboBox<String> (colors);
		
	private JPanel h1 = new JPanel(), h2 = new JPanel(), h3 = new JPanel(), h4 = new JPanel();
		private JLabel h1M = new JLabel(), h2M = new JLabel(), h3M = new JLabel(), h4M = new JLabel();
		private JComboBox<String> h1L = new JComboBox<String> (colors), h2L = new JComboBox<String> (colors), h3L = new JComboBox<String> (colors), h4L = new JComboBox<String> (colors);
		
	private JPanel j1 = new JPanel(), j2 = new JPanel(), j3 = new JPanel(), j4 = new JPanel();
		private JLabel j1M = new JLabel(), j2M = new JLabel(), j3M = new JLabel(), j4M = new JLabel();
		private JComboBox<String> j1L = new JComboBox<String> (colors), j2L = new JComboBox<String> (colors), j3L = new JComboBox<String> (colors), j4L = new JComboBox<String> (colors);
	
	private JPanel k1 = new JPanel(), k2 = new JPanel(), k3 = new JPanel(), k4 = new JPanel();
		private JLabel k1M = new JLabel(), k2M = new JLabel(), k3M = new JLabel(), k4M = new JLabel();
		private JComboBox<String> k1L = new JComboBox<String> (colors), k2L = new JComboBox<String> (colors), k3L = new JComboBox<String> (colors), k4L = new JComboBox<String> (colors);

	private JPanel aPegsA = new JPanel(), aPegsB = new JPanel();
		private JLabel aPeg1 = new JLabel("1"), aPeg2 = new JLabel("2"), aPeg3 = new JLabel("3"), aPeg4 = new JLabel("4");
	private ArrayList <JLabel> aPegs = new ArrayList<JLabel>(Arrays.asList(aPeg1, aPeg2, aPeg3, aPeg4));
			
	private JPanel bPegsA = new JPanel(), bPegsB = new JPanel();
		private JLabel bPeg1 = new JLabel("1"), bPeg2 = new JLabel("2"), bPeg3 = new JLabel("3"), bPeg4 = new JLabel("4");
	private ArrayList <JLabel> bPegs = new ArrayList<JLabel>(Arrays.asList(bPeg1, bPeg2, bPeg3, bPeg4));	
	
	private JPanel cPegsA = new JPanel(), cPegsB = new JPanel();
		private JLabel cPeg1 = new JLabel("1"), cPeg2 = new JLabel("2"), cPeg3 = new JLabel("3"), cPeg4 = new JLabel("4");
	private ArrayList <JLabel> cPegs = new ArrayList<JLabel>(Arrays.asList(cPeg1, cPeg2, cPeg3, cPeg4));	
	
	private JPanel dPegsA = new JPanel(), dPegsB = new JPanel();
		private JLabel dPeg1 = new JLabel("1"), dPeg2 = new JLabel("2"), dPeg3 = new JLabel("3"), dPeg4 = new JLabel("4");
	private ArrayList <JLabel> dPegs = new ArrayList<JLabel>(Arrays.asList(dPeg1, dPeg2, dPeg3, dPeg4));	
			
	private JPanel ePegsA = new JPanel(), ePegsB = new JPanel();
		private JLabel ePeg1 = new JLabel("1"), ePeg2 = new JLabel("2"), ePeg3 = new JLabel("3"), ePeg4 = new JLabel("4");
	private ArrayList<JLabel> ePegs = new ArrayList<JLabel>(Arrays.asList(ePeg1, ePeg2, ePeg3, ePeg4));
	
	private JPanel fPegsA = new JPanel(), fPegsB = new JPanel();
		private JLabel fPeg1 = new JLabel("1"), fPeg2 = new JLabel("2"), fPeg3 = new JLabel("3"), fPeg4 = new JLabel("4");
	private ArrayList<JLabel> fPegs = new ArrayList<JLabel>(Arrays.asList(fPeg1, fPeg2, fPeg3, fPeg4));
	
	private JPanel gPegsA = new JPanel(), gPegsB = new JPanel();
		private JLabel gPeg1 = new JLabel("1"), gPeg2 = new JLabel("2"), gPeg3 = new JLabel("3"), gPeg4 = new JLabel("4");
	private ArrayList<JLabel> gPegs = new ArrayList<JLabel>(Arrays.asList(gPeg1, gPeg2, gPeg3, gPeg4));
	
	private JPanel hPegsA = new JPanel(), hPegsB = new JPanel();
		private JLabel hPeg1 = new JLabel("1"), hPeg2 = new JLabel("2"), hPeg3 = new JLabel("3"), hPeg4 = new JLabel("4");
	private ArrayList<JLabel> hPegs = new ArrayList<JLabel>(Arrays.asList(hPeg1, hPeg2, hPeg3, hPeg4));
	
	private JPanel jPegsA = new JPanel(), jPegsB = new JPanel();
		private JLabel jPeg1 = new JLabel("1"), jPeg2 = new JLabel("2"), jPeg3 = new JLabel("3"), jPeg4 = new JLabel("4");
	private ArrayList<JLabel> jPegs = new ArrayList<JLabel>(Arrays.asList(jPeg1, jPeg2, jPeg3, jPeg4));
	
	private JPanel kPegsA = new JPanel(), kPegsB = new JPanel();
		private JLabel kPeg1 = new JLabel("1"), kPeg2 = new JLabel("2"), kPeg3 = new JLabel("3"), kPeg4 = new JLabel("4");
	private ArrayList<JLabel> kPegs = new ArrayList<JLabel>(Arrays.asList(kPeg1, kPeg2, kPeg3, kPeg4));

	/**
	 * Performs general set-up: 
	 *  sets title and icon of window, 
	 *  initialises a Mastermind game with no seed,
	 * 	intialises turnCount,
	 * 	calls initUI()
	 */
	public GUI() {
		setTitle("Mastermind");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon gameIcon = new ImageIcon("images/black.jpg");
		setIconImage(gameIcon.getImage());
		this.game = new Mastermind();
		turnCount = new JLabel("Turn " + game.turn);
		
		initUI();
	}
	
	
	/**
	 * Performs operative set-up:
	 *  sets ActionListeners and ItemListeners,
	 *  adds basic components to panels,
	 *  disables components in rows 2-10 of the game
	 *  calls various layout methods
	 */
	public void initUI() {
		
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
		
		createBox(aPegsA, aPeg1, aPeg2);
		createBox(aPegsB, aPeg3, aPeg4);
		
		createBox(bPegsA, bPeg1, bPeg2);
		createBox(bPegsB, bPeg3, bPeg4);
		
		createBox(cPegsA, cPeg1, cPeg2);
		createBox(cPegsB, cPeg3, cPeg4);
		
		createBox(dPegsA, dPeg1, dPeg2);
		createBox(dPegsB, dPeg3, dPeg4);
		
		createBox(ePegsA, ePeg1, ePeg2);
		createBox(ePegsB, ePeg3, ePeg4);
		
		createBox(fPegsA, fPeg1, fPeg2);
		createBox(fPegsB, fPeg3, fPeg4);
		
		createBox(gPegsA, gPeg1, gPeg2);
		createBox(gPegsB, gPeg3, gPeg4);
		
		createBox(hPegsA, hPeg1, hPeg2);
		createBox(hPegsB, hPeg3, hPeg4);
		
		createBox(jPegsA, jPeg1, jPeg2);
		createBox(jPegsB, jPeg3, jPeg4);
		
		createBox(kPegsA, kPeg1, kPeg2);
		createBox(kPegsB, kPeg3, kPeg4);
		
		createLayout(a1, a2, a3, a4, aPegsA, aPegsB, 
				b1, b2, b3, b4, bPegsA, bPegsB, 
				c1, c2, c3, c4, cPegsA, cPegsB, 
				d1, d2, d3, d4, dPegsA, dPegsB,
				e1, e2, e3, e4, ePegsA, ePegsB,
				f1, f2, f3, f4, fPegsA, fPegsB,
				g1, g2, g3, g4, gPegsA, gPegsB,
				h1, h2, h3, h4, hPegsA, hPegsB, 
				j1, j2, j3, j4, jPegsA, jPegsB, 
				k1, k2, k3, k4, kPegsA, kPegsB,
				buttonBox);
	}
	
	/**
	 * Adds JComponents 2-5 to JComponent 1 in a vertical line
	 * Precondition: the first argument can contain other components
	 * @param arg - set of JComponents
	 */
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
	
	/**
	 * Adds JComponents 2 and 3 to JComponent 1 in a vertical line, centered
	 * Precondition: the first argument can contain other components
	 * @param arg - set of JComponents
	 */
	private void createBox(JComponent... arg) {
		GroupLayout gl = new GroupLayout(arg[0]);
		arg[0].setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		
		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[1], Alignment.CENTER)
				.addComponent(arg[2], Alignment.CENTER)
		);
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[1])
				.addComponent(arg[2])
			);
	}

	/**
	 * Adds JComponents 1-60 to the content pane in a grid format (10 rows, 6 columns)
	 * and JComponent 61 to the right of the grid
	 * @param arg - set of JComponents
	 */
	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		pane.setPreferredSize(new Dimension(750, 850));
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[0]) //first box in first row
								.addComponent(arg[1])
								.addComponent(arg[2])
								.addComponent(arg[3]) //last box in first row
								.addComponent(arg[4]) //first hint box in first row
								.addComponent(arg[5]) //second hint box in first row
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[6])
								.addComponent(arg[7])
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
								.addComponent(arg[16])
								.addComponent(arg[17])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[18])
								.addComponent(arg[19])
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
								.addComponent(arg[28])
								.addComponent(arg[29])
						)
						//row f
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[30])
								.addComponent(arg[31])
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
								.addComponent(arg[40])
								.addComponent(arg[41])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[42])
								.addComponent(arg[43])
								.addComponent(arg[44])
								.addComponent(arg[45])
								.addComponent(arg[46])
								.addComponent(arg[47])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[48])
								.addComponent(arg[49])
								.addComponent(arg[50])
								.addComponent(arg[51])
								.addComponent(arg[52])
								.addComponent(arg[53])
						)
						.addGroup(gl.createSequentialGroup()
								.addComponent(arg[54]) //first box in last row
								.addComponent(arg[55])
								.addComponent(arg[56])
								.addComponent(arg[57]) //last box in last row
								.addComponent(arg[58]) //first hint box in last row
								.addComponent(arg[59]) //second hint box in last row
						)
					)
					.addComponent(arg[60])
		);

		gl.setVerticalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[0]) //first box in first row
							.addComponent(arg[1])
							.addComponent(arg[2])
							.addComponent(arg[3]) //last box in first row
							.addComponent(arg[4]) //first hint box in first row
							.addComponent(arg[5]) //second hint box in first row
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[6])
							.addComponent(arg[7])
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
							.addComponent(arg[16])
							.addComponent(arg[17])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[18])
							.addComponent(arg[19])
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
							.addComponent(arg[28])
							.addComponent(arg[29])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[30])
							.addComponent(arg[31])
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
							.addComponent(arg[40])
							.addComponent(arg[41])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[42])
							.addComponent(arg[43])
							.addComponent(arg[44])
							.addComponent(arg[45])
							.addComponent(arg[46])
							.addComponent(arg[47])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[48])
							.addComponent(arg[49])
							.addComponent(arg[50])
							.addComponent(arg[51])
							.addComponent(arg[52])
							.addComponent(arg[53])
					)
					.addGroup(gl.createParallelGroup()
							.addComponent(arg[54]) //first box in last row
							.addComponent(arg[55])
							.addComponent(arg[56])
							.addComponent(arg[57]) //last box in last row
							.addComponent(arg[58]) //first hint box in last row
							.addComponent(arg[59]) //second hint box in last row
					)
				)
				.addComponent(arg[60]) //button box
		);
		
		pack();
	}

	/**
	 * Determines the source of the event and
	 * sets the icon of the corresponding marble
	 * into the correct slot (visual only)
	 */
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
	
	
	/**
	 * Determines the source of the event
	 * (either the go button or the reset button),
	 * and either interacts with the Mastermind game based on the current turn and
	 * checks for a win or loss,
	 * or resets the game by enabling and disabling various components and 
	 * creating a new Mastermind game
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(go)) {
			switch(game.turn) {
				case 1:
					//set the colours selected into the board
					game.board[1][0] = new Marble((String) a1L.getSelectedItem());
					game.board[1][1] = new Marble((String) a2L.getSelectedItem());
					game.board[1][2] = new Marble((String) a3L.getSelectedItem());
					game.board[1][3] = new Marble((String) a4L.getSelectedItem());
					//have the Mastermind game evaluate the guess and increment the turn count
					game.initiateTurn();
					
					//updates turnCount and hints for this turn
					turnCount.setText("Turn 2");
					setPegs();
					
					//disables lists for the turn that just passed
					a1L.setEnabled(false);
					a2L.setEnabled(false);
					a3L.setEnabled(false);
					a4L.setEnabled(false);
					
					//enables lists for the next turn
					b1L.setEnabled(true);
					b2L.setEnabled(true);
					b3L.setEnabled(true);
					b4L.setEnabled(true);
					
					break;
				case 2:
					game.board[2][0] = new Marble((String) b1L.getSelectedItem());
					game.board[2][1] = new Marble((String) b2L.getSelectedItem());
					game.board[2][2] = new Marble((String) b3L.getSelectedItem());
					game.board[2][3] = new Marble((String) b4L.getSelectedItem());
					game.initiateTurn();

					turnCount.setText("Turn 3");
					setPegs();
					
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
					game.board[3][0] = new Marble((String) c1L.getSelectedItem());
					game.board[3][1] = new Marble((String) c2L.getSelectedItem());
					game.board[3][2] = new Marble((String) c3L.getSelectedItem());
					game.board[3][3] = new Marble((String) c4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn 4");
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[4][0] = new Marble((String) d1L.getSelectedItem());
					game.board[4][1] = new Marble((String) d2L.getSelectedItem());
					game.board[4][2] = new Marble((String) d3L.getSelectedItem());
					game.board[4][3] = new Marble((String) d4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 5);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[5][0] = new Marble((String) e1L.getSelectedItem());
					game.board[5][1] = new Marble((String) e2L.getSelectedItem());
					game.board[5][2] = new Marble((String) e3L.getSelectedItem());
					game.board[5][3] = new Marble((String) e4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 6);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[6][0] = new Marble((String) f1L.getSelectedItem());
					game.board[6][1] = new Marble((String) f2L.getSelectedItem());
					game.board[6][2] = new Marble((String) f3L.getSelectedItem());
					game.board[6][3] = new Marble((String) f4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 7);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[7][0] = new Marble((String) g1L.getSelectedItem());
					game.board[7][1] = new Marble((String) g2L.getSelectedItem());
					game.board[7][2] = new Marble((String) g3L.getSelectedItem());
					game.board[7][3] = new Marble((String) g4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 8);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[8][0] = new Marble((String) h1L.getSelectedItem());
					game.board[8][1] = new Marble((String) h2L.getSelectedItem());
					game.board[8][2] = new Marble((String) h3L.getSelectedItem());
					game.board[8][3] = new Marble((String) h4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 9);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[9][0] = new Marble((String) j1L.getSelectedItem());
					game.board[9][1] = new Marble((String) j2L.getSelectedItem());
					game.board[9][2] = new Marble((String) j3L.getSelectedItem());
					game.board[9][3] = new Marble((String) j4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn " + 10);
					setPegs();
					//messageBox.setText(game.getHints());
					
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
					game.board[10][0] = new Marble((String) k1L.getSelectedItem());
					game.board[10][1] = new Marble((String) k2L.getSelectedItem());
					game.board[10][2] = new Marble((String) k3L.getSelectedItem());
					game.board[10][3] = new Marble((String) k4L.getSelectedItem());
					game.initiateTurn();
					turnCount.setText("Turn -");
					setPegs();
					//messageBox.setText(game.getHints());
					
					k1L.setEnabled(false);
					k2L.setEnabled(false);
					k3L.setEnabled(false);
					k4L.setEnabled(false);
					
					break;
			}
			//checks with Mastermind game to see if the guess was correct
			if (game.isCorrect()) {
				go.setEnabled(false);
				game.youWin();
			} 
			//checks to see if the turn has exceeded the limit
			else if (game.turn > game.turnLimit) {
				go.setEnabled(false);
				game.youLose();
			}
		}
		//if the user clicked reset
		else if (e.getSource().equals(reset)) {
			
			//create new game
			this.game = new Mastermind();
			
			//empty everything
			turnCount.setText("Turn " + game.turn);
			messageBox.setText("");
			a1L.setSelectedIndex(0); a2L.setSelectedIndex(0); a3L.setSelectedIndex(0); a4L.setSelectedIndex(0);
			b1L.setSelectedIndex(0); b2L.setSelectedIndex(0); b3L.setSelectedIndex(0); b4L.setSelectedIndex(0);
			c1L.setSelectedIndex(0); c2L.setSelectedIndex(0); c3L.setSelectedIndex(0); c4L.setSelectedIndex(0);
			d1L.setSelectedIndex(0); d2L.setSelectedIndex(0); d3L.setSelectedIndex(0); d4L.setSelectedIndex(0);
			e1L.setSelectedIndex(0); e2L.setSelectedIndex(0); e3L.setSelectedIndex(0); e4L.setSelectedIndex(0);
			f1L.setSelectedIndex(0); f2L.setSelectedIndex(0); f3L.setSelectedIndex(0); f4L.setSelectedIndex(0);
			g1L.setSelectedIndex(0); g2L.setSelectedIndex(0); g3L.setSelectedIndex(0); g4L.setSelectedIndex(0);
			h1L.setSelectedIndex(0); h2L.setSelectedIndex(0); h3L.setSelectedIndex(0); h4L.setSelectedIndex(0);
			j1L.setSelectedIndex(0); j2L.setSelectedIndex(0); j3L.setSelectedIndex(0); j4L.setSelectedIndex(0);
			k1L.setSelectedIndex(0); k2L.setSelectedIndex(0); k3L.setSelectedIndex(0); k4L.setSelectedIndex(0);
			
			for (int i=1; i<=4; i++) {
				aPegs.get(i-1).setIcon(new ImageIcon());
				aPegs.get(i-1).setText(i+"");
				bPegs.get(i-1).setIcon(new ImageIcon());
				bPegs.get(i-1).setText(i+"");
				cPegs.get(i-1).setIcon(new ImageIcon());
				cPegs.get(i-1).setText(i+"");
				dPegs.get(i-1).setIcon(new ImageIcon());
				dPegs.get(i-1).setText(i+"");
				ePegs.get(i-1).setIcon(new ImageIcon());
				ePegs.get(i-1).setText(i+"");
				fPegs.get(i-1).setIcon(new ImageIcon());
				fPegs.get(i-1).setText(i+"");
				gPegs.get(i-1).setIcon(new ImageIcon());
				gPegs.get(i-1).setText(i+"");
				hPegs.get(i-1).setIcon(new ImageIcon());
				hPegs.get(i-1).setText(i+"");
				jPegs.get(i-1).setIcon(new ImageIcon());
				jPegs.get(i-1).setText(i+"");
				kPegs.get(i-1).setIcon(new ImageIcon());
				kPegs.get(i-1).setText(i+"");
			}

			//re-enable go button and row a lists
			go.setEnabled(true);
			
			a1L.setEnabled(true);
			a2L.setEnabled(true);
			a3L.setEnabled(true);
			a4L.setEnabled(true);
			
			//disable all other lists
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
	
	/**
	 * Interacts with the Mastermind game to set hints for the user,
	 * displaying black pegs, white pegs, or no pegs, respectively,
	 * based on the number of the next turn
	 */
	private void setPegs() {
		//both arrays are size 3 where index 0 is black, 1 is white, and 2 is null
		int[] temp = game.getThePegs(); //holds the count of each type of peg
		ImageIcon[] pegs = new ImageIcon[] {new ImageIcon("images/Black.jpg"), 
				new ImageIcon("images/white.jpg"), new ImageIcon()}; //holds the image of each type of peg
		int i; //holds the index of the first peg that hasn't been changed
		switch(game.turn) {
			case 2:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) { //there's still another peg of this type to add
						aPegs.get(i).setIcon(pegs[j]); //set icon of this type
						aPegs.get(i).setText(""); //remove number of hint
						i++; //move to next peg
						temp[j]--; //decrement peg count for this type
					}
				}
				break;
			case 3:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						bPegs.get(i).setIcon(pegs[j]);
						bPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 4:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						cPegs.get(i).setIcon(pegs[j]);
						cPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 5:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						dPegs.get(i).setIcon(pegs[j]);
						dPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;	
			case 6:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						ePegs.get(i).setIcon(pegs[j]);
						ePegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 7:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						fPegs.get(i).setIcon(pegs[j]);
						fPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 8:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						gPegs.get(i).setIcon(pegs[j]);
						gPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 9:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						hPegs.get(i).setIcon(pegs[j]);
						hPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 10:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						jPegs.get(i).setIcon(pegs[j]);
						jPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			case 11:
				i=0;
				for (int j=0; i<4 && j<3; j++) {
					while (temp[j] > 0) {
						kPegs.get(i).setIcon(pegs[j]);
						kPegs.get(i).setText("");
						i++;
						temp[j]--;
					}
				}
				break;
			default:
				messageBox.setText("Oops! Something went wrong.");
		}
		
	}
	
}
