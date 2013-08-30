
public class Display {
	
	static StringBuffer frames = new StringBuffer("| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10  |");
	static StringBuffer points = new StringBuffer("|   |   |   |   |   |   |   |   |   |     |");
	static StringBuffer scores = new StringBuffer("|   |   |   |   |   |   |   |   |   |     |");

	static int finalScore;
	int thisFramePoints;
	int nextFramePoints;
	static int frameScore;
	static int[] startNum = new int[10];
	
	
	
	public void myStatus(int frameNum, int framePart, String symbol){
		if(framePart==1){
			points.replace(4*frameNum-3, 4*frameNum-2, symbol);	//받은 포인트를 맞는 부분에 넣어준다.  
		} else{
			points.replace(4*frameNum-1, 4*frameNum, symbol);	
		}
		System.out.println(frames);
		System.out.println(points);
		System.out.println(scores);
		
		System.out.println("____This is pointStack");
		for(int i : Frame.pointStack)
			System.out.print(i + " ");
		System.out.println();
		for(int i : startNum)
			System.out.print(i + " ");
		System.out.println();
		
	}
	
	public void getScore(String status, int frameNum){
		if(frameNum==1)
			return;
		if(status=="DEFAULT"){
			for(int i=startNum[frameNum]; i<startNum[frameNum]+2; i++){
				frameScore+=Frame.pointStack[i];
			}
		} else if(status=="STRIKE" || status=="SPARE"){
			for(int i=startNum[frameNum]; i<startNum[frameNum]+3; i++)
				frameScore+=Frame.pointStack[i];
		}
		System.out.println("@@frameScore : " + frameScore);
	}
}
	



