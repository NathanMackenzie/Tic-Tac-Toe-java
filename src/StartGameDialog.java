import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StartGameDialog extends JDialog implements ActionListener, ItemListener{
	JButton start = new JButton("Start"); 
	JRadioButton singlePlayer = new JRadioButton("Single Player");
	JRadioButton doublePlayer = new JRadioButton("Double Player");
	
	public StartGameDialog(){

		JPanel messagePane = new JPanel();
	    messagePane.add(singlePlayer);
	    messagePane.add(doublePlayer);
	    singlePlayer.addItemListener(this);
	    
	    
	    getContentPane().add(messagePane);
	    JPanel buttonPane = new JPanel(); 
	    buttonPane.add(start);
	    start.addActionListener(this);
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack(); 
	    setResizable(false);
	    setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == doublePlayer && doublePlayer.isSelected()){
			singlePlayer.setSelected(false);
		}else if(e.getSource() == singlePlayer && singlePlayer.isSelected()){
			doublePlayer.setSelected(false);
		}
	}

	public void actionPerformed(ActionEvent e){
		dispose();
		if(singlePlayer.isSelected()){
			new Main(true);
		}else if(doublePlayer.isSelected()){
			new Main(false);
		}
	}
}
