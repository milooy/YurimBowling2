import java.util.ArrayList;
import java.util.Scanner;

public class Frame {
	public ArrayList<Integer> pointList = new ArrayList<Integer>();

	int frameNum;	//프레임 번호
	int framePart;	//몇번째 투구 
	int framePoint;	//프레임 총 포인트 
	int leftPins = 10;
	BowlingGame bowlingGame;
	
	String status;	//Strike, Spare, default 

	
	Frame(int frameNum, BowlingGame bowlingGame){
		this.frameNum = frameNum;
		this.bowlingGame = bowlingGame;
	}
	
	public void runrun(){
		for(int i=0; i<2; i++){
			rollDisplayFrame();
			frameAlive();
			if(frameAlive()==false)
				return;
			
		}
	}
	
	
	
	public int getFramePoint(){
		if(pointList.isEmpty())
			return 0;
		
		for(int i : pointList)
			framePoint+=i;
		return framePoint;
	}
	
	public boolean frameAlive(){
		if(framePart==1 && leftPins==0){
			status = "STRIKE";
			return false;
		} else if(framePart!=1 && leftPins==0){
			status = "SPARE";
			return false;
		} else if(framePart==2){
			status = "DEFAULT";
			return false;
		}
		return true;
	}
	
	public void roll(String rolledPin) {
		framePart++;
		pointList.add(Integer.parseInt(rolledPin));
		leftPins = 10-getFramePoint();
		frameAlive();
		
	}
	
	public void rollDisplayFrame(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________________________________");
		
		System.out.printf("<Frame %d의 %d번째 투구입니다.>\n", frameNum, framePart+1);
		System.out.printf("현재 서있는 핀 수 : %d \n" , leftPins);
		
//		if(frameNum==1)
//			System.out.printf("현재 서있는 핀 수 : %d \n" , 10);
//		
//		else{
//			this.leftPins-=getFramePoint();
//			System.out.printf("현재 서있는 핀 수 : %d \n" , leftPins);
//		}
		
		System.out.print("넘어뜨릴 핀 입력: ");
		String rolledPin = scanner.nextLine();	//rolledPin에 넘어뜨릴 핀갯수 전달 
		roll(rolledPin); 	//핀 넘어뜨림
		System.out.println("getFramePoint() : " + getFramePoint());
		System.out.println("frameAlive(): " + frameAlive());
		System.out.println("leftPins: " + leftPins);
		System.out.println("framePart : " + framePart);
		System.out.println("status: " + status);
//		bowlingGame.judge(leftPins-Integer.valueOf(rolledPin));	//Strike, Spare 판단 
//		bowlingGame.display();	//화면을 보여줌.
	}
	
	
}
