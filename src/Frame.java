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
	
	int rolledPin;
	
	String status;	//Strike, Spare, default 

	static int[] pointStack = new int[21];	//매 굴린 포인트들이 하나씩 담기는 배열
	static int rollNum = -1;	//몇번 굴렸냐 

	
	Frame(int frameNum){
		this.frameNum = frameNum;
	}
	
	public void runrun(){
		while(frameAliveStatus()){		//프레임이 죽을때까지(false가 될때까지) 돈다. 
			rollDisplayFrame();
			frameAliveStatus();
//			System.out.println(Display.scores);
			
			if(frameAliveStatus()==false){
				Display.statusArray[frameNum] = status;	//상태 배열 .
				Display.startNum[frameNum] = rollNum+1;	//프레임을 빠져나갈때마다 그 프레임 시작위치를 저장해놓는다.
				if(frameNum!=1){
					display.getScore(frameNum-1);		
					System.out.println(Display.scores);	//scoreBoard 출력 
				}
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
		roll(rolledPin); 	//핀 넘어뜨림
		this.rolledPin = Integer.valueOf(rolledPin);
		

		PointSymbol pointSymbol = new PointSymbol(pointList.get(framePart-1), status);
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
		} else if(framePart==2){				
			status = "DEFAULT";
			return false;
		}
		return true;
	}
	
	public void roll(String rolledPin) {
		framePart++;
		rollNum++;	//한번씩 굴릴때마다 롤넘버 증가. 

		pointList.add(Integer.parseInt(rolledPin));
		getFramePoint();
		
		if(framePart==3){											//맞나?
			leftPins = 10-Integer.valueOf(rolledPin);
		}else{
			leftPins = 10-framePoint;
		}
		frameAliveStatus();
		
		pointStack[rollNum] = Integer.parseInt(rolledPin);	//포인트스택에 차곡차곡 포인트들을 집어넣는다. 
	}
	

	
	
}
