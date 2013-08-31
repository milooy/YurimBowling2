import java.util.ArrayList;
import java.util.Scanner;

public class Frame {
	PointStack pointStack = new PointStack();
	Display display = new Display();
	public ArrayList<Integer> pointList = new ArrayList<Integer>();	//프레임 하나당 구한 포인트들 리스트 

	int frameNum=0;	//<Frame frameNum의 framePart번째 투구입니다.>
	int framePart=0;	 
	int framePoint=0;	//프레임 총 포인트 
	int leftPins = 10;
	int rolledPin;
	static int rollNum = -1;	//몇번 굴렸냐 
	String status;	//Strike, Spare, default 
	String symbol;	//심볼 
	
	//생성할 때 프레임번호 전달  
	Frame(int frameNum){
		this.frameNum = frameNum;
		runrun();
	}
	
	
	//프레임이 죽을때까지(false가 될때까지) 달리는 메서드. 프레임을 생성할 때 실행된다. 
	public void runrun(){
		while(frameAliveStatus()){		 
			rollDisplayFrame();	//굴리고 입력보여주고 
			frameAliveStatus();	//strike인지 spare인지 확인하고 
			System.out.println(Display.scores);	//스코어판을 보여준다.
			
			if(frameAliveStatus()==false){
				Display.statusArray[frameNum] = status;	//상태 배열 .
				Display.startNum[frameNum] = rollNum+1;	//프레임을 빠져나갈때마다 그 프레임 시작위치를 저장해놓는다.
				return;
			}
		}
	}
	
	//키보드로 굴리고 입력보여주는 메서드 
	public void rollDisplayFrame(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________________________________");
		System.out.printf("<Frame %d의 %d번째 투구입니다.>\n", frameNum, framePart+1);
		System.out.printf("현재 서있는 핀 수 : %d \n" , leftPins);
		System.out.print("넘어뜨릴 핀 입력: ");
		String rolledPin = scanner.nextLine();	
		roll(rolledPin); 	
		this.rolledPin = Integer.valueOf(rolledPin);
		pointStack.putPoint(this.rolledPin, frameNum);

		PointSymbol pointSymbol = new PointSymbol(pointList.get(framePart-1), status);
		display.myStatus(frameNum, framePart, pointSymbol.getSymbol());	//화면을 보여줌.
	}
	
	//프레임별 총 포인트 
	public void getFramePoint(){
		framePoint=0;
		for(int i : pointList){
			framePoint+=i;
		}
	}
	
	//스트라이크나 스페어나 디폴트면 false, 아니면 true를 반환 
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
	
	//굴리는 메서드 
	public void roll(String rolledPin) {
		framePart++;
		rollNum++;	//한번씩 굴릴때마다 롤넘버 증가. 

		pointList.add(Integer.parseInt(rolledPin));
		getFramePoint();
		
		if(framePart==3)				//10프레임에서 0이되면 남은핀 10으로 다시 올려주기 
			leftPins = 10-Integer.valueOf(rolledPin);
		else
			leftPins = 10-framePoint;

		frameAliveStatus();
	}
}
