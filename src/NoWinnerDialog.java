import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;


public class NoWinnerDialog extends JDialog implements ActionListener{
	Main parent;
	
	public NoWinnerDialog(Main parent){
		this.parent = parent;
		
		Dimension parentSize = parent.getSize(); 
	    Point p = parent.getLocation(); 
	    setLocation(p.x + 20, p.y + 100);
	      
	    JLabel message = new JLabel("No One Wins");
	    add(message);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack();
	    setResizable(false);
	    setVisible(true);
	    
	      
	}
	
	public void actionPerformed(ActionEvent e){
		setVisible(false); 
		dispose(); 
		
	}
}
