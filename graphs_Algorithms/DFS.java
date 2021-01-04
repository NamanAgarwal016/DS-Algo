package graphs_Algorithms;

import java.io.*;
import java.util.*;

public class DFS {
	// Driver Code
	public static void main(String args[]) {
		Graph4 g = new Graph4(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}

//This class represents a directed graph using adjacency list representation
class Graph4 {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	Graph4(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// The function to do DFS traversal.
	// It uses recursive DFSUtil()
	void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		for (int i : adj[v]) {
			if (!visited[i]) {
				DFSUtil(i, visited);
			}
		}
	}

}
