
public class BowlingGame {
	BowlingGame bowlingGame;
	
	int rolledPin;

	
	public void start(){
		for(int i=0; i<21; i++)			//Strike가 연속해서 나왔을때 오류 방지하기 위한 꼼수 
			Frame.pointStack[i] = 10;
		
		for(int i=1; i<=10; i++){
			Frame frame;
			if(i==10){
				frame = new Frame10(10);
				frame.runrun();
			}
			
			frame = new Frame(i);
			frame.runrun();	//false까지 돈다. 
		}
//		System.out.println("~~~~~frame 9 end~~~~~~~");
//		Frame frame= new Frame10(10);
//		frame.runrun();
		
		System.out.printf("						Game Over ^o^~ You got %d points!", Display.finalScore);
	}



}
