package graphs;

// https://www.youtube.com/watch?v=mqKPgW3C5ps&ab_channel=CodingNinjasIndia
// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

import java.util.LinkedList;

public class PrimsAlgorithm {
	public static void main(String[] args) {
		Graph12 graph = new Graph12(5);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 8);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 6);
		graph.addEdge(2, 3, 3);
		graph.addEdge(2, 4, 9);
		graph.addEdge(3, 4, 5);

		graph.primsAlgo(0);

		// GFG problem
//		graph.addEdge(0, 1, 4);
//		graph.addEdge(0, 7, 8);
//		graph.addEdge(1, 7, 11);
//		graph.addEdge(1, 2, 8);
//		graph.addEdge(7, 6, 1);
//		graph.addEdge(7, 8, 7);
//		graph.addEdge(2, 8, 2);
//		graph.addEdge(8, 6, 6);
//		graph.addEdge(2, 3, 7);
//		graph.addEdge(2, 5, 4);
//		graph.addEdge(6, 5, 2);
//		graph.addEdge(3, 5, 14);
//		graph.addEdge(3, 4, 9);
//		graph.addEdge(5, 4, 10);
//
//		graph.primsAlgo(0);

	}
}

class Graph12 {
	private int v;
	private LinkedList<Edge> adj[];

	private class Edge {
		int source, dest, weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public Graph12(int v) {
		this.v = v;
		this.adj = new LinkedList[v];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	public void addEdge(int source, int dest, int dist) {
		adj[source].add(new Edge(source, dest, dist));
		adj[dest].add(new Edge(dest, source, dist));
	}

	public void primsAlgo(int source) {

		// Initilization steps:
		boolean visited[] = new boolean[v];
		int parent[] = new int[v];
		parent[source] = -1;
		int nodeWeight[] = new int[v];
		int INF = Integer.MAX_VALUE;
		for (int i = 0; i < v; i++) {
			nodeWeight[i] = INF;
		}
		nodeWeight[source] = 0;

		// Start the algo with min nodeWeight index
		for (int i = 0; i < v; i++) {

			int node = findMinNodeIndex(nodeWeight, visited);

			// Explore it's neighbors and update their weights using relaxation
			for (int j = 0; j < adj[node].size(); j++) {
				int neighbor = adj[node].get(j).dest;
				if (!visited[neighbor] && nodeWeight[neighbor] > adj[node].get(j).weight) {
					nodeWeight[neighbor] = adj[node].get(j).weight;
					parent[neighbor] = node;
				}
			}
		}

		// print parent array
		for (int i = 0; i < v; i++)
			System.out.println(i + " : " + parent[i]);

		// Print cost of MST:
		int cost = 0;
		for (int i = 1; i < v; i++) {
			int src = i;
			int dest = parent[src];
			for (int j = 0; j < adj[src].size(); j++) {
				if (dest == adj[src].get(j).dest) {
					cost += adj[src].get(j).weight;
					break;
				}
			}
		}
		System.out.println("\nMinimum cost for MST is: " + cost);
	}

	private int findMinNodeIndex(int nodeWeight[], boolean visited[]) {
		int minVertex = -1;
		for (int i = 0; i < nodeWeight.length; i++) {
			if (!visited[i] && (minVertex == -1 || nodeWeight[i] <= nodeWeight[minVertex])) { // Here order in OR
																								// condition
				minVertex = i;
			}
		}
		visited[minVertex] = true;
		return minVertex;
	}
}