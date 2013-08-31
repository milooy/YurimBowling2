//Frame을 상속받은 클래스. 
public class Frame10 extends Frame{
	public boolean isFirstFrameStrike=false;
	
	Frame10(int frameNum) {
		super(frameNum);
	}
	
	//Override. status 표기 방식을 바꿔준다. 
	public boolean frameAliveStatus(){
		if(framePart==1 && leftPins ==0){
			isFirstFrameStrike = true;
			status = "STRIKE";
			leftPins = 10;
			return true;
		} else if(framePart==2 && rolledPin==10){
			status = "STRIKE";
			leftPins=10;
			return true;
		} else if(framePart==2 && leftPins!=0){
			if(!isFirstFrameStrike)
				return false;
		}else if(framePart==3)
			return false;
		return true;
		
	}
}
