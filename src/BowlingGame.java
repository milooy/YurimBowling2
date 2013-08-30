
public class BowlingGame {
	BowlingGame bowlingGame;
	
	int rolledPin;

	
	public void start(){
		bowlingGame = new BowlingGame();
		
		for(int i=1; i<=10; i++){
			Frame frame = new Frame(i, bowlingGame);
			frame.runrun();	//false까지 돈다. 
		}
	}



}
