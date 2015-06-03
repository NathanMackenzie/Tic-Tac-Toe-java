import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Window extends JPanel implements MouseListener, MouseMotionListener{
	private static int x;
	private static int y;
	private boolean pressed = false;
	public static String[][] XO = new String[3][3];
	
	public Window(){
		setSize(235, 235);
		addMouseMotionListener(this);
		addMouseListener(this);
		setBackground(new Color(255, 255, 255));
		x = 1000;
		y = 1000;
	}

	/**
	 * 
	 */
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintGameBoard(g);
		paintSelected(g);
		paintTiles(g);
	}
	
	/**
	 * Paints game board outline
	 * 
	 * @param g
	 */
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
		
	}
	
	private void addTile(){
		
		
		if(x <= 75 && y <= 75){
			
		}else if(x >= 80 && x <= 155 && y <= 75){
			
		}else if(x >= 160 && y <= 75){
			
		}else if(x <= 75 && y >= 80 && y <= 155){
			
		}else if(x >= 80 && x <= 155 && y >= 80 && y <= 155){
			
		}else if(x >= 160 && y >= 80 && y <= 155){
			
		}else if(x <= 75 && y >= 160){
			
		}else if(x >= 80 && x <= 155 && y >= 160){
			
		}else if(x >= 160 && y >= 160){
			
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
		addTile();
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
