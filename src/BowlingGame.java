import java.util.Scanner;


public class BowlingGame {
	BowlingGame bowlingGame;
	Display display = new Display(bowlingGame);
	
	int rolledPin;
	
	
//	public void roll(String rolledPin) {
//		this.rolledPin = Integer.parseInt(rolledPin);
//		
//	}
	
	public void start(){
		bowlingGame = new BowlingGame();
		
		for(int i=1; i<=10; i++){
			Frame frame = new Frame(i, bowlingGame);
			frame.runrun();	//두번 돈다. 
		}
	}



}
