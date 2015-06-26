import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * This is a simple Tic-Tac-Teo GUI game written using the java core SWING and AWT 
 * libraries.
 * 
 * @author natemackenzie
 * @version 1.0
 */

public class Main extends JFrame{
	// A header label indicating which players turn it is.
	static JLabel playerLabel = new JLabel();
	
	// Boolean used to represent if the second player is human or the computer.
	private boolean computer;
	// String describing the suit of the first player.
	private String firstPlayer;
	// String constants to be used for describing the first players suit.
	static final String FIRST_PLAYER_X = "X";
	static final String FIRST_PLAYER_O = "O";
	
	/**
	 * This constructor initiates the main JFrame which will contain the game board and header label.
	 * 
	 * @param computer is the second player
	 */
	public Main(boolean computer, String firstPlayer){
		// Set global variables to equal the given arguments.
		this.computer = computer;
		this.firstPlayer = firstPlayer;
		
		/* Initiate the JLabel that shows which players turn it is */
		playerLabel.setText("Player " + firstPlayer);
		playerLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		/* Set the windows layout and add the header label */
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(playerLabel);
		
		/* Call to function to create a new game */
		newGame(computer, firstPlayer); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * This method creats a new start dialog box to gather pre-game prefrences and information. 
	 * 
	 * @param args passed in by command line
	 */
	public static void main(String [] args){
		new StartGameDialog();
	}
	
	/**
	 * This method creates a new game board and adds it to the main window.
	 * 
	 * @param computer is second player
	 * @param firstPlayer suit
	 */
	public void newGame(boolean computer, String firstPlayer){
		
		/* Create a new game window and add it to the main JFrame window */
		Board window = new Board(this, computer, firstPlayer);
		add(window);
		pack();
		setSize(235, 293);
		
	}
	
	/**
	 * Method removes current game board and starts a new game. 
	 */
	public void playAgain(){
		
		/* 
		 * Finds current game board component, delete it, replace it with a new game board,
		 * and repaint the window.
		 */
		Component[] comp = getContentPane().getComponents();
		remove(comp[1]);
		newGame(computer, firstPlayer);
		repaint();
	}
	
	/**
	 * Quits game
	 */
	public void quit(){
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
}
