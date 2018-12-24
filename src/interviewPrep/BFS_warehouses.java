package interviewPrep;


import java.util.*;
/*
 * Problem : Given a list of connections in the form of [ Source, Destination, Cost] 
 *			 find the path that returns the minimum cost to all destinations. 
 * 			 Assume every destination is reachable, and costs are non-negative
 */

// Test-Case
// [ [A,B,1] [B,C,4] [A,C,2] ]
// return [ [A,B,1] [A,C,2] ]



// USING ADJ LIST
//	- Allows us to visit all warehouses adjacent to current warehouse
//	- Avoids going back and forth through all nodes in graph
//	- Need to create adjList map
//	- Need to maintain a visited map
//	- Along w/ visited map, we need to maintain a map that has warehouse that are sources
//	- Queue pushes destination warehouses and checks the adjacencyList of said dest warehouse

// NOT USING ADJ LIST
//	- We push all connections into the queue and don't care if the current warehouse has been visited or not
//	- we just compare the cost to the destination warehouse currently vs the new cost from the current source warehouse

// Both methods utilize
//	- QUEUE for "BFS-esque" approach
//	- Map to maintain current cost to destination warehouse
//	- Map to maintain which path to take (source to dest)



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
	
	public static void printAdjList(Map<String,LinkedList<Connection>> adjList) {
		
		for(Map.Entry<String, LinkedList<Connection>> entry : adjList.entrySet()) {
			System.out.print("Source : " + entry.getKey() + " Connections : ");
			LinkedList<Connection> list = entry.getValue();
			for(Connection connected : list) {
				connected.print();
			}
			System.out.println();		
			System.out.println();
		}
		
	}
	
	public static List<Connection> minDistance(List<Connection> connections){		
		// ==========adjList========================================================================
		// using adj list, push source node [first string in connections list]
		// adjList architecture <Source (String), [Connections from Source](Connection)>
		
		Map<String,LinkedList<Connection>> adjList = new HashMap<String,LinkedList<Connection>>();
		Map<String,Integer> existingSource = new HashMap<String,Integer>();
		Map<String,Integer> visited = new HashMap<String,Integer>();
		Map<String,Integer> costToDest = new HashMap<String,Integer>();
		Map<String, String> destToSource = new HashMap<String,String>();	
		Queue<String> adjQueue = new LinkedList<String>();

		
		// create adj list
		for(Connection pairs : connections) {
			if(adjList.containsKey(pairs.source)) {
				LinkedList<Connection> currList = adjList.get(pairs.source);
				currList.add(pairs);
				adjList.put(pairs.source, currList);
			}else {
				LinkedList<Connection> newList = new LinkedList<Connection>();
				newList.add(pairs);
				adjList.put(pairs.source, newList);
				existingSource.put(pairs.source, 1);
			}
		}
		
		// print out adjList
		printAdjList(adjList);
		
		// set cost of all destinations to +infinity in maintained map
		for(Connection pairs : connections) {
			costToDest.put(pairs.dest, Integer.MAX_VALUE);
		}
		
		// begin "BFS"
		adjQueue.add("A");
		while(!adjQueue.isEmpty()) {
			String source_warehouse = adjQueue.poll();
			if(visited.containsKey(source_warehouse) || !existingSource.containsKey(source_warehouse)) {
				continue;
			}else {
				visited.put(source_warehouse,1);	// visit source
			}
			
			// look @ adjacency list for destinations, add these destinations to queue
			// update cost to destination node if cheaper
			for(Connection adjWarehouse : adjList.get(source_warehouse)) {
				adjQueue.add(adjWarehouse.dest);
				int currCost = costToDest.get(adjWarehouse.dest);
				int newCost = adjWarehouse.dist;
				if(currCost > newCost) {
					costToDest.put(adjWarehouse.dest, newCost);
					destToSource.put(adjWarehouse.dest,adjWarehouse.source);
				}
			}
		}
		
		// Print out results from ADJ List
		System.out.println("=====================ADJ LIST RESULTS ========================");
		for(Map.Entry<String, String> entry : destToSource.entrySet()) {
			int cost = costToDest.get(entry.getKey());
			System.out.print("[ " + entry.getValue() + ", " + entry.getKey() + ", " + cost + "] , ");
		}
		System.out.println();
		System.out.println("==============================================================");
		
		
		
		
		
		// ============== NON-ADJ LIST, MULTIPLE MAPS ====================================================================
		List<Connection> Results = new ArrayList<Connection>();		
	    Queue<Connection> q = new LinkedList<Connection>();
		costToDest = new HashMap<String,Integer>();   // destination, cost
		destToSource = new HashMap<String,String>();  // b/c a dest can have @ most one minimum cost connection
													  // but a source can have multiple conections [A , B] and [A , C]
		
		// add all connections to queue
		for(Connection pairs : connections) {
			q.add(pairs);
			costToDest.put(pairs.dest, Integer.MAX_VALUE);
		}
		
		// go through cost for all connections in queue
		// not necessarily a BFS, b/c we don't care about adjacent nodes and instead just go through all connections from input
		while(!q.isEmpty()) {
			Connection currentWarehouse = q.poll();
			
			if(currentWarehouse.dist < costToDest.get(currentWarehouse.dest)) {
				costToDest.put(currentWarehouse.dest, currentWarehouse.dist);
				destToSource.put(currentWarehouse.dest, currentWarehouse.source);
			}	
		}
		
		// Add the min cost paths to Result
		for(Map.Entry<String,String> entry : destToSource.entrySet()) {
			String source = entry.getValue();
			String dest = entry.getKey();
			int cost = costToDest.get(dest);
			Connection newConnection = new Connection(source,dest,cost);
			Results.add(newConnection);
		}
		

		System.out.println();
		System.out.println("=====================NO ADJ LIST RESULTS ===========================");
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
		
		// print non-adj list results
		for(Connection ans : res ) {
			ans.print();
		}
		
	}
}
