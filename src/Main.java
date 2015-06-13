import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	static JLabel playerLabel = new JLabel("Just a test");
	
	public Main(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		playerLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(playerLabel);
		newGame();
		setVisible(true);
	}
	
	public static void main(String [] args){
		new StartGameDialog();
	}
	
	public void newGame(){
		Window window = new Window(this, true);
		add(window);
		pack();
		setSize(235, 300);
	}
	
	public void endGame(){
		Component[] comp = getContentPane().getComponents();
		remove(comp[1]);
		newGame();
		repaint();
	}
	
	public void quit(){
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
}
