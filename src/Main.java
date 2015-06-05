import java.awt.Component;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main(){
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		newGame();
	}
	
	public static void main(String [] args){
		new Main();
	}
	
	public void newGame(){
		Window window = new Window(this, false);
		window.setLocation(100, 100);
		add(window);
	}
	
	public void endGame(){
		Component[] comp = getContentPane().getComponents();
		remove(comp[0]);
		repaint();
	}
	
}
