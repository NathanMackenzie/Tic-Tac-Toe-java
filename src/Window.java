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
	private boolean gameOver = false;
	private String crossOut;
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
		
		if(gameOver){
			paintTiles(g);
			crossOut(g);
		}else{
			paintSelected(g);
			paintTiles(g);
		}
		
		
	}
	
	private void crossOut(Graphics g){
		g.setColor(Color.RED);
		
		if(crossOut.startsWith("v")){
			System.out.println(Integer.valueOf(crossOut.charAt(1)));
			System.out.println(crossOut);
			g.fillRect(Integer.valueOf(crossOut.charAt(1)), 10, 20, 100);
			
		}else if(crossOut.startsWith("h")){
			
		}else if(crossOut.equals("dr")){
			
		}else if(crossOut.equals("dl")){
			
		}
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
		
		if(computer){
			ComputerPlayer.nextMove();
		}else{
			if(player == 0){
				player = 1;
			}else{
				player = 0;
			}
		}
		
	}
	
	private void threeInARow(){
		checkVertical();
		
		checkHorizontal();
		
		checkDiagonal();
	}
	
	private void checkVertical(){
		String suit = "Empty"; //Set to value empty to avoid null pointer exception within .equals() epression
		for(int c = 0; c < 3; c++){
			for(int r = 0; r < 3; r++){
				
				if(r == 0 && XO[c][r] != null){
					suit = XO[c][r];
				}
				
				if(suit.equals(XO[c][r])){
					if(r == 2){
						gameOver = true;
						crossOut = "v" + c;
						return;
					}
				}else{
					break;
				}
				
			}
		}
		return;
	}
	
	private void checkHorizontal(){
		String suit = "Empty"; //Set to value empty to avoid null pointer exception within .equals() epression
		for(int r = 0; r < 3; r++){
			for(int c = 0; c < 3; c++){
				
				if(c == 0 && XO[c][r] != null){
					suit = XO[c][r];
				}
				
				if(suit.equals(XO[c][r])){
					if(c == 2){
						gameOver = true;
						crossOut = "h" + r;
						return;
					}
				}else{
					break;
				}
				
			}
		}
		return;
	}
	
	private void checkDiagonal(){
		String suit = "Empty";
		
		for(int i = 0; i < 3; i++){
			if(i == 0 && XO[i][i] != null){
				suit = XO[i][i];
			}
			
			if(suit.equals(XO[i][i])){
				if(i == 2){
					gameOver = true;
					crossOut = "dr";
					return;
				}
			}else{
				break;
			}
		}
		
		suit = "Empty";
		
		for(int i = 0; i < 3; i++){
			if(i == 0 && XO[2-i][i] != null){
				suit = XO[2-i][i];
			}
			
			if(suit.equals(XO[2-i][i])){
				if(i == 2){
					gameOver = true;
					crossOut = "dl";
					return;
				}
			}else{
				break;
			}
		}
		
		return;
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
			repaint();
			changePlayer();
		}
		threeInARow();
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
