package graphs;

// Dijkstra's Algorithm on : 
// Undirected/ Directed Weighted Graph

// Drawback : dosen't work properly For Negative weighted edge graphs

// Time Complexity now : O[V*V]
// Optimization : using Binary Heap Priority Queue implementation for findMinNodeIndex
// Opti Time Comlexity : O((E+V)*LogV) = O(ELogV) 
//Time complexity can be further reduced to O(E + VLogV) using Fibonacci Heap. The reason is, Fibonacci Heap takes O(1) time for decrease-key operation while Binary Heap takes O(Logn) time.

import java.util.LinkedList;

public class DijkstraAlgorithm {

	public static void main(String[] args) {

		// Undirected Graph
// https://www.youtube.com/watch?v=bImvsFNym9I&ab_channel=CodingNinjasIndia
		Graph7 graph1 = new Graph7(5);
		graph1.addEdge(0, 1, 4);
		graph1.addEdge(0, 2, 8);
		graph1.addEdge(1, 2, 2);
		graph1.addEdge(1, 3, 5);
		graph1.addEdge(2, 3, 5);
		graph1.addEdge(2, 4, 9);
		graph1.addEdge(3, 4, 4);

		graph1.printGraph();

		graph1.dijkstra(0);

		// Directed Graph
// https://www.youtube.com/watch?v=XB4MIexjvY0&ab_channel=AbdulBari
		Graph7 graph2 = new Graph7(7);
		graph2.addEdge(1, 2, 2);
		graph2.addEdge(1, 3, 4);
		graph2.addEdge(2, 3, 1);
		graph2.addEdge(2, 4, 7);
		graph2.addEdge(3, 5, 3);
		graph2.addEdge(5, 4, 2);
		graph2.addEdge(4, 6, 1);
		graph2.addEdge(5, 6, 5);

		graph2.printGraph();

		graph2.dijkstra(1);
	}
}

class Graph7 {
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

	public Graph7(int v) {
		this.v = v;
		this.adj = new LinkedList[v];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int source, int dest, int dist) {
		adj[source].add(new Edge(source, dest, dist));
		adj[dest].add(new Edge(dest, source, dist));
	}

	void printGraph() {
		System.out.println("\n\nsource -> destination = distance");

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int source = i;
				int dest = adj[i].get(j).dest;
				int dist = adj[i].get(j).weight;

				System.out.println(source + " -> " + dest + " = " + dist);
			}
		}
	}

	void dijkstra(int source) {
		boolean visited[] = new boolean[v];

		int nodeDist[] = new int[v];
		for (int node = 0; node < nodeDist.length; node++) {
			nodeDist[node] = Integer.MAX_VALUE;
		}
		nodeDist[source] = 0;

		for (int node = 0; node < adj.length - 1; node++) { // last node ke liye uske neighbrs already calculate kar
															// diye

			// find vertex with min dist and also not visited
			int minNodeIndex = findMinNodeIndex(nodeDist, visited);

			// Now explore its neighbors
			for (int i = 0; i < adj[minNodeIndex].size(); i++) {
				int nextNode = adj[minNodeIndex].get(i).dest;
				int dist = adj[minNodeIndex].get(i).weight;

				if (nodeDist[nextNode] > nodeDist[minNodeIndex] + dist && nodeDist[minNodeIndex] != Integer.MAX_VALUE) {
// 2nd condition bcoz: MAX_VALUE + any +ve = becomes negative and then this will be true : MAX_VALUE > MAX_VALUE + weight
					nodeDist[nextNode] = nodeDist[minNodeIndex] + dist;
				}
			}
		}

		System.out.println("\nDistance of nodes from source :");
		for (int node = 0; node < nodeDist.length; node++) {
			System.out.println(node + " : " + nodeDist[node]);
		}

	}

	private int findMinNodeIndex(int nodeDist[], boolean visited[]) {
		int minNodeIndex = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				minNodeIndex = i;
				break;
			}
		}
		for (int i = 0; i < nodeDist.length; i++) {
			if (nodeDist[i] < nodeDist[minNodeIndex] && !visited[i])
				minNodeIndex = i;
		}

//		// Instead of above 2 for loop :
//		int minVertex = -1;
//		for (int i = 0; i < nodeDist.length; i++) {
//			if (!visited[i] && (minVertex == -1 || nodeDist[i] < nodeDist[minVertex])) {		// Here order in OR condition is IMP, otherwise it will be indexOutOfBound = -1
//				minVertex = i;
//			}
//		}

		visited[minNodeIndex] = true;
		return minNodeIndex;
	}

}
