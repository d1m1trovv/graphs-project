
public class MainClass {
	
	static Graph graph = new Graph();
	
	public static void findPath(String startName, String endName,
			Searchable searcher) {
		graph.resetAllNodes();
		if(searcher.search(startName, endName)) {
			System.out.println("HAVE A PATH");
		}else {
			System.out.println("THERE IS NO PATH");
		}
	}
	
	public static void init() {
		/*graph.addNode(new Room("A",2,4));
		graph.addNode(new Room("B",1,2));
		graph.addNode(new Room("C",4,2));
		graph.addNode(new Room("D",0,0));
		graph.addNode(new Room("E",2,0));
		graph.addNode(new Room("F",5,0));
		
		graph.addLink("A", "B", true,2);
		graph.addLink("A", "C", true,1);
		graph.addLink("D", "B", true,3);
		graph.addLink("E", "B", true,10);
		graph.addLink("C", "E", true,4);
		graph.addLink("C", "F", true,17);
		graph.addLink("E", "F", true,3);
		graph.addLink("B", "C", true,1);
		graph.addLink("E", "D", true,4);*/
		
		graph.addRoom(new Room("A", 1, 5));
        graph.addRoom(new Room("B", 2, 5));
        graph.addRoom(new Room("C", 10, 5));
        graph.addRoom(new Room("D", 16, 5));
        graph.addRoom(new Room("E", 18, 5));

        graph.addRoom(new Room("F", 1, 7));
        graph.addRoom(new Room("G", 5, 7));
        graph.addRoom(new Room("H", 6, 7));


        graph.addRoom(new Room("J", 1, 9));
        graph.addRoom(new Room("K", 2, 9));
        graph.addRoom(new Room("L", 5, 9));
        graph.addRoom(new Room("O", 7, 9));
        graph.addRoom(new Room("M", 8, 9));
        graph.addRoom(new Room("N", 9, 9));
        graph.addRoom(new Room("P", 11, 9));
        graph.addRoom(new Room("S", 12, 9));

        graph.createLink("C", "G", true, 1);
        graph.createLink("G", "L", true, 1);

        graph.createLink("A", "B", true, 1);
       // graph.createLink("A", "C", true, 4);
        //graph.createLink("A", "D", true, 5);
        //graph.createLink("A", "E", true, 2);
        graph.createLink("A", "F", true, 1);

        graph.createLink("B", "C", true, 1);
        //graph.createLink("B", "D", true, 19);
        //graph.createLink("B", "E", true, 11);

        graph.createLink("C", "E", true, 1);
        //graph.createLink("C", "D", true, 12);

        //graph.createLink("D", "E", true, 4);

        graph.createLink("F", "G", true, 1);
        //graph.createLink("F", "H", true, 8);

        graph.createLink("G", "H", true, 1);

        graph.createLink("J", "K", true, 1);
        /*graph.createLink("J", "L", true, 9);
        graph.createLink("J", "N", true, 55);
        graph.createLink("J", "M", true, 2);
        graph.createLink("J", "O", true, 1);
        graph.createLink("J", "P", true, 3);
        graph.createLink("J", "S", true, 4);*/
        graph.createLink("J", "F", true, 1);

        graph.createLink("K", "L", true, 1);
        /*graph.createLink("K", "N", true, 8);
        graph.createLink("K", "M", true, 15);
        graph.createLink("K", "O", true, 14);
        graph.createLink("K", "P", true, 7);
        graph.createLink("K", "S", true, 8);*/

        graph.createLink("L", "O", true, 1);
       /* graph.createLink("L", "M", true, 19);
        graph.createLink("L", "N", true, 14);
        graph.createLink("L", "P", true, 2);
        graph.createLink("L", "S", true, 3);*/

        graph.createLink("O", "M", true, 1);
        /*graph.createLink("O", "N", true, 5);
        graph.createLink("O", "P", true, 7);
        graph.createLink("O", "S", true, 9);*/

        graph.createLink("N", "M", true, 1);
        graph.createLink("N", "P", true, 1);
        //graph.createLink("N", "S", true, 13);

        //graph.createLink("M", "P", true, 12);
        //graph.createLink("M", "S", true, 8);

        graph.createLink("P", "S", true, 1);
	}

	public static void main(String[] args) {
		init();
		findPath("N", "B", new BreadthSearch(graph));
	}

}
