import java.util.ArrayList;


public class Display {
	
	static StringBuffer frames = new StringBuffer("| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10  |");
	static StringBuffer points = new StringBuffer("|   |   |   |   |   |   |   |   |   |     |");
	static StringBuffer scores = new StringBuffer("ScoreBoard: ");

	static int finalScore;
	int thisFramePoints;
	int nextFramePoints;
	int frameScore;
	static int[] startNum = new int[11];
	static String[] statusArray = new String[11];
	
	//새로짜는코드 
	static ArrayList<Integer> stackList= new ArrayList<Integer>();
	
	public void getScore2(int frameNum, int rollNum){
		int start = startNum[frameNum]; 
		System.out.println("@start: " + start);
		System.out.println("@stackstack: " + Frame.pointStack[start]);
		while(true){
			stackList.add(Frame.pointStack[start]);
			start++;
			
			System.out.println("@@stackList: ");
			for(int i : stackList)
				System.out.println(i);

			if(Display.stackList.size()==3){
				if(Display.stackList.get(0) == 10 || (Display.stackList.get(0) + Display.stackList.get(1)) == 10){
					frameScore = Display.stackList.get(0) + Display.stackList.get(1) + Display.stackList.get(2);
					
				} else
					frameScore = Display.stackList.get(0) + Display.stackList.get(1);
				stackList.clear();
				finalScore+=frameScore;
				scores.append(finalScore + " ");	//받은 포인트를 맞는 부분에 넣어준다.
				
				return;
			}
		}
	}
	
	//새로짜는코드end 
	
	
	
	
	public void myStatus(int frameNum, int framePart, String symbol){
		if(framePart==1){
			points.replace(4*frameNum-3, 4*frameNum-2, symbol);	//받은 포인트를 맞는 부분에 넣어준다.  
		} else if(framePart==3 && frameNum==10){
			points.replace(4*frameNum+1, 4*frameNum+2, symbol);	
			
		} else{
			points.replace(4*frameNum-1, 4*frameNum, symbol);	
		}
		System.out.println(frames);
		System.out.println(points);

	}
	
//	public void getScore(int frameNum){	//score 배열 만들기 
//		
//		if(statusArray[frameNum]=="STRIKE" || statusArray[frameNum-1]=="STRIKE"){	//strike나 spare면 스타트넘버부터 3개 더해주기
//			System.out.println("You've take the Trap card...");
//			for(int i=startNum[frameNum-1]; i<startNum[frameNum-1]+3; i++){
//				frameScore+=Frame.pointStack[i];
//			}
//			finalScore+=frameScore;
//				
//		} else{
//			if(statusArray[frameNum]=="DEFAULT"){	//default면 스타트넘버부터 2개 더해주기 
//				for(int i=startNum[frameNum-1]; i<startNum[frameNum-1]+2; i++){
//					frameScore+=Frame.pointStack[i];
//				}
//			} else if(statusArray[frameNum]=="SPARE" || statusArray[frameNum]=="STRIKE"){	//strike나 spare면 스타트넘버부터 3개 더해주기 
//				for(int i=startNum[frameNum-1]; i<startNum[frameNum-1]+3; i++)
//					frameScore+=Frame.pointStack[i];
//			}
//			
//			 
//			
//		}
//		
//	}
}
	



