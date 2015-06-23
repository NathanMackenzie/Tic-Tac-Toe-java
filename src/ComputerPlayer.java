import java.util.Random;


public class ComputerPlayer implements Runnable{
	static Random rand = new Random();
	static String computerSuit;
	private Board board;
	
	public ComputerPlayer(Board parent){
		board = parent;
	}
	
	public void run(){
		
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		nextMove();
		board.repaint();
		board.threeInARow();
	}
	
	public void start(){
		Thread t = new Thread(this, "Computer Player");
		t.start();
	}
	
	
	private void nextMove(){
		
		if(isFull()){
			return;
		}else{
			while(true){
				int c = rand.nextInt(3);
				int r = rand.nextInt(3);
			
				if(board.XO[c][r] == null){;
					board.XO[c][r] = computerSuit;
					break;
				}
			}
		}
	}
	
	private boolean isFull(){
		for(int c = 0; c < 3; c++){
			for(int r = 0; r < 3; r++){
				if(board.XO[c][r] == null)
					return false;
			}
		}
		return true;
	}

}
