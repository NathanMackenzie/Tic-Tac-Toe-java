import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverDialog extends JDialog implements ActionListener {
	Main parent;
	
	JButton newGame = new JButton("New Game"); 
    JButton quit = new JButton("Quit"); 
	
  public GameOverDialog(Main parent, String winner) {
    this.parent = parent;
	  
    if (parent != null) {
    	
      Dimension parentSize = parent.getSize(); 
      Point p = parent.getLocation(); 
      setLocation(p.x + 20, p.y + 100);
    }
    
    
    JPanel messagePane = new JPanel();
    messagePane.add(new JLabel("Game Over"));
    messagePane.add(new JLabel(winner + " Wins!"));
    getContentPane().add(messagePane);
    JPanel buttonPane = new JPanel();
    buttonPane.add(quit); 
    buttonPane.add(newGame);
    quit.addActionListener(this);
    newGame.addActionListener(this);
    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack(); 
    setResizable(false);
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
	setVisible(false); 
	dispose(); 
	
	if(e.getSource() == newGame){
		parent.playAgain();
	}else if(e.getSource() == quit){
		parent.quit();
	}
  }
  
}