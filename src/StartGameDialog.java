import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StartGameDialog extends JDialog implements ActionListener, ItemListener{
	int height = 130;
	int width = 260;
	JButton start = new JButton("Start"); 
	JRadioButton singlePlayer = new JRadioButton("Single Player");
	JRadioButton doublePlayer = new JRadioButton("Double Player");
	
	JRadioButton playerX = new JRadioButton("X");
	JRadioButton playerO = new JRadioButton("O");
	
	JLabel suitMessage = new JLabel("First Players Suit: ");
	
	public StartGameDialog(){
		JPanel messagePane = new JPanel();
		
	    messagePane.add(singlePlayer);
	    messagePane.add(doublePlayer);
	    messagePane.add(suitMessage);
	    messagePane.add(playerX);
	    messagePane.add(playerO);
	    singlePlayer.addItemListener(this);
	    doublePlayer.addItemListener(this);
	    playerX.addItemListener(this);
		playerO.addItemListener(this);
		
	    add(messagePane);
	    JPanel buttonPane = new JPanel(); 
	    buttonPane.add(start);
	    start.addActionListener(this);
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setSize(width, height);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == doublePlayer && doublePlayer.isSelected()){
			singlePlayer.setSelected(false);
		}else if(e.getSource() == singlePlayer && singlePlayer.isSelected()){
			doublePlayer.setSelected(false);
		}else if(e.getSource() == playerX && playerX.isSelected()){
			playerO.setSelected(false);
		}else if(e.getSource() == playerO && playerO.isSelected()){
			playerX.setSelected(false);
		}
	}

	public void actionPerformed(ActionEvent e){
		
		if(singlePlayer.isSelected() && playerX.isSelected()){
			dispose();
			new Main(true, Main.FIRST_PLAYER_X);
			ComputerPlayer.computerSuit = "O";
		}else if(doublePlayer.isSelected() && playerX.isSelected()){
			dispose();
			new Main(false, Main.FIRST_PLAYER_X);
			ComputerPlayer.computerSuit = "O";
		}else if(singlePlayer.isSelected() && playerO.isSelected()){
			dispose();
			new Main(true, Main.FIRST_PLAYER_O);
			ComputerPlayer.computerSuit = "X";
		}else if(doublePlayer.isSelected() && playerO.isSelected()){
			dispose();
			new Main(false, Main.FIRST_PLAYER_O);
			ComputerPlayer.computerSuit = "X";
		}
	}
}
