package interviewPrep;


import java.util.*;


// [ [A,B,1] [B,C,4] [A,C,2] ]
// return [ [A,B,1] [A,C,2] ]
//[ [A,B,1] [B,C,4] [A,C,2] [D,E,5] ]
// return empty list
// return empty list if we cannot visit all warehouses
public class BFS_warehouses {

	public static class Connection{
		String source;
		String dest;
		int dist;
		
		Connection(String source, String dest, int dist){
			this.source = source;
			this.dest = dest;
			this.dist = dist;
		}
		
		void print() {
			System.out.print("[ " + this.source + ", " + this.dest + ", " + this.dist + "], ");
		}
	}
	
	public static List<Connection> minDistance(List<Connection> connections){
		
		List<Connection> Results = new ArrayList<Connection>();
		//Map<String,Integer> visited = new HashMap<String,Integer>();
	//	Map<String,String> sourceToDest = new HashMap<String,String>();
		Queue<Connection> q = new LinkedList<Connection>();
		Map<String,Integer> costToHere = new HashMap<String,Integer>();   // destination, cost
		Map<String,String> destToSource = new HashMap<String,String>();   // b/c a dest can have @ most one connection
																		 // but a source can have multiple conections
		Map<String,LinkedList<Connection>> adjList = new HashMap<String,LinkedList<Connection>>();
		
		// ==========adjList========================================================================
		for(Connection pairs : connections) {
			if(adjList.containsKey(pairs.source)) {
				LinkedList<Connection> currList = adjList.get(pairs.source);
				currList.add(pairs);
				adjList.put(pairs.source, currList);
			}else {
				LinkedList<Connection> newList = new LinkedList<Connection>();
				newList.add(pairs);
				adjList.put(pairs.source, newList);
			}
		}
		
		for(Map.Entry<String, LinkedList<Connection>> entry : adjList.entrySet()) {
			System.out.print("Source : " + entry.getKey() + " Connections : ");
			LinkedList<Connection> list = entry.getValue();
			for(Connection connected : list) {
				connected.print();
			}
			System.out.println();
		}
		
		// using adj list, push source node [first string in connections list]
		// adjList architecture <Source Warehouse, [Connections from Source]>
		
		
		
		
		
		// ============== NON-ADJ LIST, MULTIPLE MAPS ====================================================================
		for(Connection pairs : connections) {
			q.add(pairs);
			costToHere.put(pairs.dest, Integer.MAX_VALUE);
		}
		
		while(!q.isEmpty()) {
			Connection currentWarehouse = q.poll();

			if(currentWarehouse.dist < costToHere.get(currentWarehouse.dest)) {
				System.out.println("current dist to " + currentWarehouse.dest + " =" + costToHere.get(currentWarehouse.dest));
				costToHere.put(currentWarehouse.dest, currentWarehouse.dist);
				System.out.println("new dist to " + currentWarehouse.dest + " =" + currentWarehouse.dist);
				//sourceToDest.put(currentWarehouse.source, currentWarehouse.dest); 	// only allows for one value per Source
				// [A,B,1], [A,C,4], [A,C,2]
				// want [A,B,1],[A,C,2] = 3  we replaced A,B with A,C b/c 2 > 1
				destToSource.put(currentWarehouse.dest, currentWarehouse.source);
			}	
		}
		
		for(Map.Entry<String,String> entry : destToSource.entrySet()) {
			String source = entry.getValue();
			String dest = entry.getKey();
			int cost = costToHere.get(dest);
			Connection newConnection = new Connection(source,dest,cost);
			Results.add(newConnection);
		}
		

		
		
		// add all connections to q
		// compare polled->dest->cost to curr dest cost
		return Results;
	}
	public static void main(String[] args) {
		
		Connection one = new Connection("A","B",1);
		Connection two = new Connection("B","C",4);
		Connection three = new Connection("A","C",2);
		
		List<Connection> warehouses = new ArrayList<Connection>();
		warehouses.add(one);
		warehouses.add(two);
		warehouses.add(three);
		
		
		List<Connection> res = minDistance(warehouses);
		
		for(Connection ans : res ) {
			ans.print();
		}
		
	}
	
	
	
}
