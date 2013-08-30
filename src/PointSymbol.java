
public class PointSymbol {
	int point;
	String status;
	String symbol;
	
	
	PointSymbol(int point, String status){
		this.point = point;
		this.status = status; 
	}
	
	public String getSymbol(){
		if(status=="SPARE")
			return "/";
		else if(status == "STRIKE")
			return "X";
		else if(point == 0)
			return "-";
		else
			return Integer.toString(point);
	}
}
