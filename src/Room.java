import java.util.ArrayList;

public class Room {
	
	public String name;
	public double weight;
	public int x,y;
	
	boolean isTested = false;
	boolean isExpanded = false;
	int depth = -1;
	double distanceToGoal = 0.0;
	Room parent = null;
	
	public ArrayList<Link> links = new ArrayList<>();
	
	public Room(String name) {
		this.name = name;
	}
	
	public Room(String name, double w) {
		this(name);
		this.weight = w;
	}

	public Room(String name,int x,int y) {
		this(name);
		this.x = x;
		this.y = y;
	}
	
	public void reset() {
		this.isExpanded = false;
		this.isTested = false;
		this.depth = -1;
		this.distanceToGoal = 0.0;
		this.parent = null;
	}
	
	
	
	
	
	
	
	
}
