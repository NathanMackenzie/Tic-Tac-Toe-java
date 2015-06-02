import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Window extends JPanel implements MouseListener, MouseMotionListener{
	private static int x;
	private static int y;
	
	public Window(){
		setSize(235, 235);
		setBackground(new Color(255, 255, 255));
		x = 0;
		y = 0;
	}

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
		
	}
	
	private void paintTiles(Graphics g){
		
	}
	
	public void mouseMoved(MouseEvent e) {
	      x = e.getX();
	      y = e.getY();
	      repaint();
	}

	public void mouseDragged(MouseEvent e) {
	      
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}
}
