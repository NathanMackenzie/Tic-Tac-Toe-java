import javax.swing.JFrame;

public class Main extends JFrame{
	public Main(){
		Window window = new Window();
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(window);
		setVisible(true);
	}
	
	public static void main(String [] args){
		new Main();
	}
}
