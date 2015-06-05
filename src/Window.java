import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Window extends JPanel implements MouseListener, MouseMotionListener{
	private static int x;
	private static int y;
	private boolean pressed = false;
	private static int player = 1;
	public static String[][] XO = new String[3][3];
	public boolean computer;
	Main main;
	
	public Window(Main main, boolean vsComput){
		this.main = main;
		setSize(235, 235);
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(new Color(255, 255, 255));
		x = 1000;
		y = 1000;
		
		
		computer = vsComput;
	}

	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintGameBoard(g);
		paintSelected(g);
		paintTiles(g);
	}
	
	private void paintGameBoard(Graphics g){
		g.fillRect(75, 0, 5, 235);
		g.fillRect(155, 0, 5, 235);
		g.fillRect(0, 75, 235, 5);
		g.fillRect(0, 155, 235, 5);	
	}
	
	
	private void paintSelected(Graphics g){
		
		if(pressed){
			g.setColor(new Color(237, 237, 237));
		}else{
			g.setColor(Color.gray);
		}
		
		if(x <= 75 && y <= 75){
			g.fillRect(0, 0, 75, 75);
		}else if(x >= 80 && x <= 155 && y <= 75){
			g.fillRect(80, 0, 75, 75);
		}else if(x >= 160 && y <= 75){
			g.fillRect(160, 0, 75, 75);
		}else if(x <= 75 && y >= 80 && y <= 155){
			g.fillRect(0, 80, 75, 75);
		}else if(x >= 80 && x <= 155 && y >= 80 && y <= 155){
			g.fillRect(80, 80, 75, 75);
		}else if(x >= 160 && y >= 80 && y <= 155){
			g.fillRect(160, 80, 75, 75);
		}else if(x <= 75 && y >= 160){
			g.fillRect(0, 160, 75, 75);
		}else if(x >= 80 && x <= 155 && y >= 160){
			g.fillRect(80, 160, 75, 75);
		}else if(x >= 160 && y >= 160){
			g.fillRect(160, 160, 75, 75);
		}
	}
	
	private void paintTiles(Graphics g){
		g.setColor(Color.BLACK);
		int style = Font.BOLD;
		g.setFont(new Font ("Ariel", style , 75));
		for(int r = 0; r < 3; r++){
			for(int c = 0; c < 3; c++){
				if(XO[c][r] != null){
					g.drawString(XO[c][r], (8 + c*80), (70 + r*80));
				}
			}
		}
	}
	
	private boolean addTile(){
		String tile;
		
		
		switch (player){
		case 0: tile = "X";
			break;
		case 1: tile = "O";
			break;
		default: tile = null;
		}
		
		
		if(x <= 75 && y <= 75){
			if(XO[0][0] == null){
				XO[0][0] = tile; return true;
			}
		}else if(x >= 80 && x <= 155 && y <= 75){
			if(XO[1][0] == null){
				XO[1][0] = tile; return true;
			}
		}else if(x >= 160 && y <= 75){
			if(XO[2][0] == null){
				XO[2][0] = tile; return true;
			}
		}else if(x <= 75 && y >= 80 && y <= 155){
			if(XO[0][1] == null){
				XO[0][1] = tile; return true;
			}
		}else if(x >= 80 && x <= 155 && y >= 80 && y <= 155){
			if(XO[1][1] == null){
				XO[1][1] = tile; return true;
			}
		}else if(x >= 160 && y >= 80 && y <= 155){
			if(XO[2][1] == null){
				XO[2][1] = tile; return true;
			}
		}else if(x <= 75 && y >= 160){
			if(XO[0][2] == null){
				XO[0][2] = tile; return true;
			}
		}else if(x >= 80 && x <= 155 && y >= 160){
			if(XO[1][2] == null){
				XO[1][2] = tile; return true;
			}
		}else if(x >= 160 && y >= 160){
			if(XO[2][2] == null){
				XO[2][2] = tile; return true;
			}
		}
		return false;
	}
	
	private void changePlayer(){
		
		if(computer == false){
			if(player == 0){
				player = 1;
			}else{
				player = 0;
			}
		}
		
	}
	
	
	public void mouseMoved(MouseEvent e) {
	      x = e.getX();
	      y = e.getY();
	      repaint();
	}

	public void mouseDragged(MouseEvent e) {
	      
	}
	
	public void mousePressed(MouseEvent e) {
		pressed = true;
		if(addTile()){
			changePlayer();
		}
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		x = 76;
		y = 76;
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		
	}
}
