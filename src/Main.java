import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * @author Nate Mackenzie
 *
 * A simple Tic-Tac-Toe game written in java using the Swing and AWT graphic libraries 
 */
public class Main extends JFrame{
	static JLabel playerLabel = new JLabel();
	private boolean computer;
	private String firstPlayer;
	static String FIRST_PLAYER_X = "X";
	static String FIRST_PLAYER_O = "O";
	
	/**
	 * Constructor initiates the main JFrame which will contain the game board.
	 * @param computer for whether the second player is human or computer
	 */
	public Main(boolean computer, String firstPlayer){
		
		this.computer = computer;
		this.firstPlayer = firstPlayer;
		
		/* Initiate JLabel that shows which players turn it is */
		playerLabel.setText("Player " + firstPlayer);
		playerLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		/* Set the windows layout and add label */
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(playerLabel);
		
		/* Call function to create a new game */
		newGame(computer, firstPlayer); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * This method opens a new start dialog box
	 * @param args
	 */
	public static void main(String [] args){
		new StartGameDialog();
	}
	
	/**
	 * Method creates and adds new game board to JFrame.
	 * @param computer
	 */
	public void newGame(boolean computer, String firstPlayer){
		
		/* Create a new game window and add it to the JFrame */
		Board window = new Board(this, computer, firstPlayer);
		add(window);
		pack();
		setSize(235, 300);
		
	}
	
	/**
	 * Method removes current game board and starts a new game. 
	 */
	public void playAgain(){
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
