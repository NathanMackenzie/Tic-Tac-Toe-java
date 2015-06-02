import javax.swing.JFrame;

public class Main extends JFrame{
	public Main(){
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		Window window = new Window();
		window.setLocation(100, 100);
		add(window);
		
		
	}
	
	public static void main(String [] args){
		new Main();
	}
}
