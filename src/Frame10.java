import java.util.ArrayList;


public class Frame10 extends Frame{

	public boolean isFirstFrameStrike=false;
	public boolean isSecondFrameStrike=false;
	
	int frame10Points;
	
	Frame10(int frameNum) {
		super(frameNum);
	}
	
	//Override
	public ArrayList<Integer> pointList = new ArrayList<Integer>();

	int myRolledPin;
	
//	public void runrun(){
//		rollDisplayFrame();
//		
//		Display.statusArray[9] = status;	//상태 배열 .
//		Display.startNum[9] = rollNum+1;	//프레임을 빠져나갈때마다 그 프레임 시작위치를 저장해놓는다.
//		display.getScore(9);
//
//		
//		frame10Points +=rolledPin;
//		System.out.println("~~~~frame10Points1: " + frame10Points);
//		System.out.println(Display.scores);
//		
//		for(int i=0; i<2; i++){
//			System.out.println("@status: " + status);
//			System.out.println("@framePart: " + framePart);
//			if(framePart==2 && status=="DEFAULT"){
//
//				System.out.println(Display.scores);
//				System.out.println("~~~~rolledPin: " + rolledPin);
//
//				break;
//			}
//
//			if(leftPins==0)
//				leftPins=10;
//			
//			frame10Points +=rolledPin;
//			rollDisplayFrame();
//
//			System.out.println("~~~~frame10Points2: " + frame10Points);
//			Display.scores.append(frame10Points+ " ");
//			System.out.println(Display.scores);
//			
//		}
//	}
	
	
	public boolean frameAliveStatus(){
		if(framePart==1 && leftPins ==0){
			isFirstFrameStrike = true;
			status = "STRIKE";
			leftPins = 10;
			return true;
		} else if(framePart==2 && rolledPin==10){
			isSecondFrameStrike = true;
			status = "STRIKE";
			leftPins=10;
			return true;
		} else if(framePart==2 && leftPins!=0){
			if(!isFirstFrameStrike)
				return false;
		}else if(framePart==3){
			return false;
		} 
		
		return true;
		
	}

	
	
	
	
	
//	Override
//	public boolean frameAliveStatus(){
//		if(framePart==1 && leftPins==0){	//첫번째 투구에 0이 남았을때 
//			isFirstFrameStrike = true;
//			status = "STRIKE";
//			leftPins=10;
//			return true;}
//		} else if(framePart==2 && leftPins==0){	//두번째 투구에 0이 남았을때 
//			if(isFirstFrameStrike==true){	//첫번째 투구가 스트라이크였으면 스트라이크 
//				isSecondFrameStrike=true;
//				status = "STRIKE";
//				leftPins=10;
//				System.out.println("2");
//				return true;
//			} else{							//첫번째 투구가 스트라이크가 아니었으면 스페어 
//				status = "SPARE";
//				leftPins = 10;
//				System.out.println("3");
//				return true;
//			}	
//		} else if(framePart==2){	//두번째 투구가 0이 아니고 첫번째 투구에서 스트라이크나 스페어가 아닌거 			
//			return false;
//		} else if(framePart==3 && leftPins==0){	//세번째 투구에 0이 남았을때 
//			if(isSecondFrameStrike==true){	//두번째 투구가 스트라이크였으면 스트라이크 
//				status = "STRIKE";
//				leftPins=10;
//				System.out.println("4");
//			} else{							//첫번째 투구가 스트라이크가 아니었으면 스페어 
//				status = "SPARE";
//				leftPins = 10;
//				System.out.println("5");
//
//			}
//			return false;
//		} else if(framePart==3){			//그도저도 아니고 세번째 투구가 되면 return false 
//			System.out.println("6");
//			return false;
//		}
//		System.out.println("7");
//		return true;
//	}

}
