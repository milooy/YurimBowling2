import java.util.ArrayList;
import java.util.Scanner;

public class Frame {
	public ArrayList<Integer> pointList = new ArrayList<Integer>();

	int frameNum=0;	//프레임 번호
	int framePart=0;	//몇번째 투구 
	int framePoint=0;	//프레임 총 포인트 
	int leftPins = 10;
	String symbol;	//심볼 
	BowlingGame bowlingGame;
	Display display = new Display();
	
	String status;	//Strike, Spare, default 

	static int[] pointStack = new int[21];	//매 굴린 포인트들이 하나씩 담기는 배열 
	static int rollNum = -1;	//몇번 굴렸냐 

	
	Frame(int frameNum, BowlingGame bowlingGame){
		this.frameNum = frameNum;
		this.bowlingGame = bowlingGame;
	}
	
	public void runrun(){
		while(frameAliveStatus()){		//프레임이 죽을때까지(false가 될때까지) 돈다. 
			rollDisplayFrame();
			frameAliveStatus();
			if(frameAliveStatus()==false){
				System.out.println("---where to start?: " + rollNum);
				System.out.println(status);
				display.startNum[frameNum] = rollNum;
				display.getScore(status, frameNum);		//어디에놔야지..
				return;
			}
		}
		
	}
	
	public void rollDisplayFrame(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________________________________");
		System.out.printf("<Frame %d의 %d번째 투구입니다.>\n", frameNum, framePart+1);
		System.out.printf("현재 서있는 핀 수 : %d \n" , leftPins);
		System.out.print("넘어뜨릴 핀 입력: ");
		String rolledPin = scanner.nextLine();	//rolledPin에 넘어뜨릴 핀갯수 전달 
		
		System.out.println("before framePoint: "+ framePoint);

		roll(rolledPin); 	//핀 넘어뜨림
		
		for(int i : pointList){
			System.out.println(i);
		}
		
		System.out.println("after framePoint: "+framePoint);
		System.out.println("frameAlive(): " + frameAliveStatus());
		System.out.println("leftPins: " + leftPins);
		System.out.println("framePart : " + framePart);
		System.out.println("status: " + status);
		
		PointSymbol pointSymbol = new PointSymbol(pointList.get(framePart-1), status);
		pointSymbol.getSymbol();
		
		display.myStatus(frameNum, framePart, pointSymbol.getSymbol());	//화면을 보여줌.
	}
	
	public void getFramePoint(){
		if(pointList.isEmpty())
			framePoint = 0;
		
		framePoint=0;
		for(int i : pointList){
			framePoint+=i;
		}
	}
	
	public boolean frameAliveStatus(){
		if(framePart==1 && leftPins==0){
			status = "STRIKE";
			return false;
		} else if(framePart!=1 && leftPins==0){
			status = "SPARE";
			return false;
		} else if(framePart==2){					//frame10은 상속받아서 이걸 오버라이드. 아님 인터페이스로 모드를 바꾸든가. 
			status = "DEFAULT";
			return false;
		}
		return true;
	}
	
	public void roll(String rolledPin) {
		System.out.println("----roll start----");
		framePart++;
		
		rollNum++;
		
		pointList.add(Integer.parseInt(rolledPin));
		getFramePoint();
		System.out.println("framePoint in roll: " + framePoint);
		leftPins = 10-framePoint;
		System.out.println("leftPins in roll: " + leftPins);
		frameAliveStatus();
		
		pointStack[rollNum] = Integer.parseInt(rolledPin);			//될까?? 
		
		System.out.println("----roll end----");
		
	}
	

	
	
}
