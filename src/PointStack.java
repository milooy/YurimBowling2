import java.util.ArrayList;


public class PointStack {
	
	static ArrayList<Integer> pointStack= new ArrayList<Integer>();
	int point;
	static int finalPoint;

	
	
	public void putPoint(int rolledPin){
		pointStack.add(rolledPin);
		
		System.out.println("This is pointStack----");
		for(int i : pointStack)
			System.out.print(i + " ");
		System.out.println();
		
		
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
	
//	public boolean isFull(){
//		if(pointStack.size()==3)
//			return true;
//		else
//			return false;
//	}


}
