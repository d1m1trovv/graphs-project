import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Graph {
	
	public HashMap<String, Room> myGraph = new HashMap<>();
	Comparator<Room> byWeight = (Room n1,Room n2)
			-> Double.compare(n1.weight, n2.weight);
	Comparator<Room> byName = (Room n1, Room n2)
					-> n1.name.compareTo(n2.name);	
	Comparator<Room> byDistance = (Room n1,Room n2)
					-> Double.compare(n1.distanceToGoal, n2.distanceToGoal);				
	
	public void addRoom(Room node) {
		
		if(node == null || myGraph.containsKey(node.name)) {
			System.err.println("Node name already exists");
			return;
		}
		myGraph.put(node.name, node);
	}
	
	public void createLink(String startName,String endName, boolean isBiDirectional, double l) {
		if(myGraph.containsKey(startName) && myGraph.containsKey(endName)) {
			Room startNode = myGraph.get(startName);
			Room endNode = myGraph.get(endName);
			startNode.links.add(new Link(endName,l));
			
			if(isBiDirectional) {
				endNode.links.add(new Link(startName,l));
			}
		}else {
			System.err.println("Wrong or missing node names");
		}
	}
	
	public Room getNode(String name) {
		return myGraph.get(name);
	}
	
	public boolean containsNode(String name) {
		return myGraph.containsKey(name);
	}
	
	public ArrayList<Room> getLinkedNodes(String name){
		ArrayList<Room> linkedNodes = new ArrayList<>();
		Room node = myGraph.get(name);
		for(Link l : node.links) {
			linkedNodes.add(myGraph.get(l.toNodeName));
		}
		return linkedNodes;
	}

	public void resetAllNodes() {
		myGraph.forEach((k,v) -> v.reset());
	}
	
	public void sortByWeight(ArrayList<Room> list) {
		
		list.sort(byWeight.thenComparing(byName));
	}
	
	public void sortByDistance(ArrayList<Room> list) {
		
		list.sort(byDistance.thenComparing(byName));
	}
	
	public void setDepths(String name) {
		Room node = getNode(name);
		for(Room n : getLinkedNodes(name)) {
			if(n.depth == -1) {
				n.depth = node.depth +1;
			}
		}
	}
	
	public void printPath(Room current) {
		StringBuilder path = new StringBuilder();
		
		while(current.depth != 0) {
			path.append(current.name);
			
			for(Room node : getLinkedNodes(current.name)) {
				if(node.depth == current.depth - 1) {
					current = node;
					break;
				}
			}
		}
		
		path.append(current.name);
		
		
		System.out.println(path.reverse());
	}
	
	public double findDistance(String nameOne, String nameTwo) {
		
		Room nodeOne = getNode(nameOne);
		Room nodeTwo = getNode(nameTwo);
		
		double distance = Math.sqrt(Math.pow(nodeOne.x - nodeTwo.x, 2)
				+ Math.pow(nodeOne.y - nodeTwo.y, 2));
		return distance;
	}
	
	
	
}
