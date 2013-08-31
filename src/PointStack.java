import java.util.ArrayList;


public class PointStack {
	
	static ArrayList<Integer> pointStack= new ArrayList<Integer>();	//포인트스택 
	int point;
	static int finalPoint;

	public void putPoint(int rolledPin, int frameNum){
		pointStack.add(rolledPin);	//굴릴때마다 포인트스택에 점수를 넣어준다.
		
		while(frameNum==10 && pointStack.size()==2){	//프레임10에서 default일때 예외처리 
			if(pointStack.get(0) + pointStack.get(1) <10){
				finalPoint+=pointStack.get(0) + pointStack.get(1);
				Display.scores.append(finalPoint + " ");	
			}
			break;
		}
		
		if(pointStack.size()==3){	//스택이 3으로 꽉 찼을때 
			int point0 = pointStack.get(0);
			int point1 = pointStack.get(1);
			int point2 = pointStack.get(2);
			
			if(point0==10){	//젤 아래꺼가 10일때 
				point = point0 + point1 + point2;
				pointStack.remove(0);
			} else if((point0 + point1)==10){	//아래꺼 두개 합이 10일때
				point = point0 + point1 + point2;
				pointStack.remove(0);
				pointStack.remove(0);
			} else{
				point = point0 + point1;
				pointStack.remove(0);
				pointStack.remove(0);
			}
			
			finalPoint+=point;
			Display.scores.append(finalPoint + " ");	//스코어를 넣어준다.
		}
	}
}

