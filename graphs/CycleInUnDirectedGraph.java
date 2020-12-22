package graphs;

//A Java Program to detect cycle in an undirected graph 
import java.util.*;

public class CycleInUnDirectedGraph {
	public static void main(String args[]) {
		Graph6 g1 = new Graph6(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		Graph6 g2 = new Graph6(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
//This class represents a directed graph using adjacency list representation

class Graph6 {
	private int V;
	private LinkedList<Integer> adj[];

	Graph6(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	boolean isCyclic() {
		boolean visited[] = new boolean[V];

		// Call the recursive helper
		// function to detect cycle in different DFS trees
		for (int u = 0; u < V; u++) {
			if (!visited[u])
				if (isCyclicUtil(u, visited, -1))
					return true;
		}

		return false;
	}

	// A recursive function that uses visited[] and parent to detect cycle in
	// subgraph reachable from vertex v.

	boolean isCyclicUtil(int v, boolean visited[], int parent) {
		// Mark the current node as visited
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		for (int i : adj[v]) {
			// If an adjacent is not visited, then recur for that adjacent
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			// If an adjacent is visited and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

}
