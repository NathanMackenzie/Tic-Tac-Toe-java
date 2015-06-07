import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	static JLabel playerLabel = new JLabel("Just a test");
	
	public Main(){
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(playerLabel);
		newGame();
		pack();
		setSize(235, 500);
		setVisible(true);
	}
	
	public static void main(String [] args){
		new Main();
	}
	
	public void newGame(){
		Window window = new Window(this, true);
		//window.setLocation(100, 100);
		add(window);
	}
	
	public void endGame(){
		Component[] comp = getContentPane().getComponents();
		remove(comp[1]);
		repaint();
	}
	
}
