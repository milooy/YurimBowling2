import java.util.ArrayList;


public class PointStack {
	
	static ArrayList<Integer> pointStack= new ArrayList<Integer>();
	int point;
	static int finalPoint;

	
	
	public void putPoint(int rolledPin, int frameNum){
		pointStack.add(rolledPin);	//굴릴때마다 포인트스택에 점수를 넣어준다.
		
		while(frameNum==10 && pointStack.size()==2){
			if(pointStack.get(0) + pointStack.get(1) <10){
				finalPoint+=pointStack.get(0) + pointStack.get(1);
				Display.scores.append(finalPoint + " ");	
			}
			break;
		}
		
		System.out.println("FrameNum: " + frameNum);
		
		
		if(pointStack.size()==3){
			
			int point0 = pointStack.get(0);
			int point1 = pointStack.get(1);
			int point2 = pointStack.get(2);
			
			
			
			if(pointStack.get(0)==10){	//젤 아래꺼가 10일때 
				point = pointStack.get(0) + pointStack.get(1) + pointStack.get(2);
				pointStack.remove(0);
			} else if((pointStack.get(0) + pointStack.get(1))==10){	//아래꺼 두개 합이 10일때
				point = pointStack.get(0) + pointStack.get(1) + pointStack.get(2);
				pointStack.remove(0);
				pointStack.remove(0);
			} else{
				point = pointStack.get(0) + pointStack.get(1);
				pointStack.remove(0);
				pointStack.remove(0);
			}
			
			
			System.out.println("It is full~~~~~");
			System.out.println("This is Point: " + point);
			System.out.println("This is size: " + pointStack.size());
			
			finalPoint+=point;
			Display.scores.append(finalPoint + " ");	//받은 포인트를 맞는 부분에 넣어준다.
		}
		
	}
}

