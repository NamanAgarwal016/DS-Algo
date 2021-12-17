package graphs_Algorithms;

// https://youtu.be/joqmqvHC_Bo

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Logic: If a vertex is reached that is already in the recursion stack, then there is a cycle in the tree

public class CycleInDirectedGraph {
	// Driver code
	public static void main(String[] args) {
		Graph1 graph = new Graph1(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}
}

class Graph1 {

	private final int V;
	private final List<List<Integer>> adj;

	public Graph1(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	public void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	
	// This function is a variation of DFS()
	public boolean isCyclic() {

		// Mark all the vertices as not visited and not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to detect cycle in different DFS trees
		// This for-loop also takes care of the unconnected graph case.
		for (int node = 0; node < V; node++)
			if(!visited[node])
				if (isCyclicUtil(node, visited, recStack))
					return true;

		return false;
	}

	// This function is a variation of DFSUtil()
	private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack) {

		visited[node] = true;
		recStack[node] = true;

		for (int neigh : adj.get(node)) {
			if(!visited[neigh]) {
				if (isCyclicUtil(neigh, visited, recStack))
					return true;
			}
			else if(recStack[neigh])
				return true;
		}

		recStack[node] = false;

		return false;
	}
}
