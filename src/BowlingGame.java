
public class BowlingGame {
	BowlingGame bowlingGame;
	
	int rolledPin;

	
	public void start(){
		bowlingGame = new BowlingGame();
		
		for(int i=1; i<=10; i++){
			Frame frame = new Frame(i, bowlingGame);
			
			if(i==10)
				frame= new Frame10(i, bowlingGame);
			
			frame.runrun();	//false까지 돈다. 
//			System.out.println("---where to start?: " + Frame.rollNum);

		}
	}



}
