package graphs;

// Attention :  Here time complexity is going to V^3 bcoz of use of adjacency list. Instead if we simply use array of 
// edges then complexity reduces to V^2. See this: https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/

// For Negative weighted edge graphs 

//Drawback : not work for negative weight cycle, but can detect

import java.util.LinkedList;

// https://www.youtube.com/watch?v=FtN3BYH2Zes&ab_channel=AbdulBari

// time complexity = O[V*E]
// worst case when complete graph with n vertices : O[n^3]

public class BellmanFordAlgorithm {
	public static void main(String[] args) {

		// Directed Graph with negative edge weight
		Graph8 graph = new Graph8(7);
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 5);
		graph.addEdge(2, 1, -2);
		graph.addEdge(3, 2, -2);
		graph.addEdge(1, 4, -1);
		graph.addEdge(2, 4, 1);
// graph.addEdge(4, 2, 1); // uncomment for checking negative cycle, comment upper line
		graph.addEdge(3, 5, -1);
		graph.addEdge(4, 6, 3);
		graph.addEdge(5, 6, 3);

		graph.printGraph();

		graph.bellmanFord(0);
	}
}

class Graph8 {
	private int v;

	private class Edge {
		int source, dest, weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

	private LinkedList<Edge> adj[];

	public Graph8(int v) {
		this.v = v;
		this.adj = new LinkedList[v];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int source, int dest, int dist) {
		adj[source].add(new Edge(source, dest, dist));
	}

	void printGraph() {
		System.out.println("\nsource -> destination = distance");

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int source = i;
				int dest = adj[i].get(j).dest;
				int dist = adj[i].get(j).weight;

				System.out.println(source + " -> " + dest + " = " + dist);
			}
		}
	}

	void bellmanFord(int source) {

		int runTimeOfAlgo = adj.length - 1; // total no. of Edges = no. of vertices - 1

		int nodeDist[] = new int[v];
		for (int node = 0; node < nodeDist.length; node++) {
			nodeDist[node] = Integer.MAX_VALUE;
		}
		nodeDist[source] = 0;
		
		int parent[] = new int[v];
		parent[source] = -1;

		for (int i = 0; i < runTimeOfAlgo; i++) { // 3 for-loops bcoz of adj list, instead use simply array of edges to
													// get 2 for-loops

			for (int j = 0; j < adj.length; j++) {
				for (int edge = 0; edge < adj[j].size(); edge++) {
					int src = adj[j].get(edge).source;
					int dest = adj[j].get(edge).dest;
					int weight = adj[j].get(edge).weight;

					// Relaxation
					if (nodeDist[dest] > nodeDist[src] + weight && nodeDist[src] != Integer.MAX_VALUE) {
// 2nd condition bcoz: MAX_VALUE + any +ve = becomes negative and then this will be true : MAX_VALUE > MAX_VALUE + weight
						nodeDist[dest] = nodeDist[src] + weight;
						parent[dest] = src; 
					}
				}
			}
		}

		// Check for negative weight cycle : run the algo one more time, if get shorter
		// path any, then yes
		for (int j = 0; j < adj.length; j++) {
			for (int edge = 0; edge < adj[j].size(); edge++) {
				int src = adj[j].get(edge).source;
				int dest = adj[j].get(edge).dest;
				int weight = adj[j].get(edge).weight;

				if (nodeDist[dest] > nodeDist[src] + weight && nodeDist[src] != Integer.MAX_VALUE) {
					System.out.println("\nGraph contains negative weight cycle");
					return;
				}
			}
		}

		System.out.println("\nDistance of nodes from source :");
		for (int node = 0; node < nodeDist.length; node++) {
			System.out.println(node + " : " + nodeDist[node]);
		}
		
		System.out.println("\nParent of nodes for shortest path :");
		for (int node = 0; node < parent.length; node++) {
			System.out.println(node + " : " + parent[node]);
		}
	}

}
