import java.awt.Graphics;
import javax.swing.JPanel;


public class Window extends JPanel{

	@Override public void paintComponent(Graphics g){
		g.drawRect(100, 100, 10, 10);
	}
}
