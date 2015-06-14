import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	static JLabel playerLabel = new JLabel();
	private boolean computer;
	static String firstPlayer = "X";
	
	public Main(boolean computer){
		/*
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		*/
		this.computer = computer;
		
		playerLabel.setText("Player " + firstPlayer);
		playerLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(playerLabel);
		newGame(computer);
		setVisible(true);
	}
	
	public static void main(String [] args){
		new StartGameDialog();
	}
	
	public void newGame(boolean computer){
		Window window = new Window(this, computer, firstPlayer);
		add(window);
		pack();
		setSize(235, 300);
	}
	
	public void endGame(){
		Component[] comp = getContentPane().getComponents();
		remove(comp[1]);
		newGame(computer);
		repaint();
	}
	
	public void quit(){
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
}
