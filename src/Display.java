
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
}
	



