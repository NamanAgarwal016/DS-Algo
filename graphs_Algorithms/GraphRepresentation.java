package graphs_Algorithms;

//Java code to demonstrate Graph representation 
//using ArrayList in Java 

import java.util.*;

public class GraphRepresentation {
	// Driver Code
	public static void main(String[] args) {
		// Creating a graph with 5 vertices
		Graph2 graph = new Graph2(5);
		// Adding edges one by one
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();
	}
}

class Graph2 {
	// A utility function to add an edge in an undirected graph
	private final List<List<Integer>> adj;

	public Graph2(int V) {
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// A utility function to print the adjacency list
	// representation of graph
	public void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			
			System.out.println("\nAdjacency list of vertex" + i);
			System.out.print("head");
			
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

}