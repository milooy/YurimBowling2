
public class BowlingGame {
	BowlingGame bowlingGame;

	//프레임을 10번 생성해준다. 
	public void start(){
		for(int i=1; i<=10; i++){
			if(i==10){
				new Frame10(10);
				break;
			}
			new Frame(i);
		}
		System.out.printf("						Game Over ^o^~ You got %d points!", PointStack.finalPoint);
	}
}
