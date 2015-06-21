import java.util.Random;


public class ComputerPlayer {
	static Random rand = new Random();
	static String computerSuit;
	
	static void nextMove(){
		if(isFull()){
			return;
		}else{
			while(true){
				int c = rand.nextInt(3);
				int r = rand.nextInt(3);
			
				if(Board.XO[c][r] == null){;
					Board.XO[c][r] = computerSuit;
					break;
				}
			}
		}
	}
	
	private static boolean isFull(){
		for(int c = 0; c < 3; c++){
			for(int r = 0; r < 3; r++){
				if(Board.XO[c][r] == null)
					return false;
			}
		}
		return true;
	}

}
