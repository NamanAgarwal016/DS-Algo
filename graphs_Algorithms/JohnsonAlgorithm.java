package graphs_Algorithms;

// https://www.youtube.com/watch?v=wCjEP8TYi-E&feature=youtu.be&ab_channel=Harshitjain
// https://www.geeksforgeeks.org/johnsons-algorithm/

import java.util.LinkedList;

// Combination of Dijkstra and Bellman Ford. 
// Time complexity of Bellman Ford is O(VE) and time complexity of Dijkstra is O(VLogV). 
// The main steps in algorithm are Bellman Ford Algorithm called once and Dijkstra called V times
// So overall time complexity is O(V^2log V + VE).

public class JohnsonAlgorithm {
	public static void main(String[] args) {
		Graph10 graph = new Graph10(4);
		graph.addEdge(0, 1, -5);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 3, 3);
		graph.addEdge(1, 2, 4);
		graph.addEdge(2, 3, 1);

		System.out.println("Original Graph Problem: ");
		graph.printGraph();

		graph.johnson();

	}
}

class Graph10 {
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

	public Graph10(int v) {
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
		System.out.println("source -> destination = distance");

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int source = i;
				int dest = adj[i].get(j).dest;
				int dist = adj[i].get(j).weight;

				System.out.println(source + " -> " + dest + " = " + dist);
			}
		}
	}

	void johnson() {

		// creating modified adj list with additional vertex
		LinkedList<Edge> modifiedAdj[] = new LinkedList[v + 1];
		for (int i = 0; i < v; i++) {
			modifiedAdj[i] = adj[i];
		}
		modifiedAdj[v] = new LinkedList<Edge>();
		for (int i = 0; i < v; i++) {
			Edge newEdge = new Edge(v, i, 0);
			modifiedAdj[v].add(newEdge);
		}

		// Printing new graph
		System.out.println("\nPrinting modified graph: ");
		System.out.println("source -> destination = distance");
		for (int i = 0; i < modifiedAdj.length; i++) {
			for (int j = 0; j < modifiedAdj[i].size(); j++) {
				int source = i;
				int dest = modifiedAdj[i].get(j).dest;
				int dist = modifiedAdj[i].get(j).weight;

				System.out.println(source + " -> " + dest + " = " + dist);
			}
		}

// Now apply BellmanFord to find shortest dist from newly added vertex to all vertices.
		int source = v;
		int runTimeOfAlgo = modifiedAdj.length - 1;
		int nodeDist[] = new int[v + 1];
		for (int node = 0; node < nodeDist.length; node++) {
			nodeDist[node] = Integer.MAX_VALUE;
		}
		nodeDist[source] = 0;

		for (int i = 0; i < runTimeOfAlgo; i++) {
			for (int j = 0; j < modifiedAdj.length; j++) {
				for (int edge = 0; edge < modifiedAdj[j].size(); edge++) {
					int src = modifiedAdj[j].get(edge).source;
					int dest = modifiedAdj[j].get(edge).dest;
					int weight = modifiedAdj[j].get(edge).weight;

					// Relaxation
					if (nodeDist[dest] > nodeDist[src] + weight && nodeDist[src] != Integer.MAX_VALUE) {
						nodeDist[dest] = nodeDist[src] + weight;
					}
				}
			}
		}

		// Check for negative weight cycle:
		for (int j = 0; j < modifiedAdj.length; j++) {
			for (int edge = 0; edge < modifiedAdj[j].size(); edge++) {
				int src = modifiedAdj[j].get(edge).source;
				int dest = modifiedAdj[j].get(edge).dest;
				int weight = modifiedAdj[j].get(edge).weight;

				if (nodeDist[dest] > nodeDist[src] + weight && nodeDist[src] != Integer.MAX_VALUE) {
					System.out.println("\nGraph contains negative weight cycle");
					return;
				}
			}
		}
//Printing modified distance array 
		System.out.println("\nDistance of all nodes from newly added vertex by applying BellmanFord:");
		for (int node = 0; node < nodeDist.length; node++) {
			System.out.println(node + " : " + nodeDist[node]);
		}

// Now applying Johnson's Formula for all the original edges:
		for (int i = 0; i < adj.length; i++) {
			for (int edge = 0; edge < adj[i].size(); edge++) {
				int weight = adj[i].get(edge).weight;
				int sourceDist = nodeDist[adj[i].get(edge).source];
				int destDist = nodeDist[adj[i].get(edge).dest];

				// Johnson's Formula
				adj[i].get(edge).weight = weight + sourceDist - destDist;
			}
		}
// Printing graph with new edge weights
		System.out.println("\nPrinting graph with new edge weights: ");
		System.out.println("source -> destination = distance");
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int src = i;
				int dest = adj[i].get(j).dest;
				int dist = adj[i].get(j).weight;

				System.out.println(src + " -> " + dest + " = " + dist);
			}
		}

// Now finally apply dijkstra for all pair of vertices.
		// dijkstra will be applied for = no. of vertices
		for (int i = 0; i < v; i++) {
			System.out.println("Shortest dist from Source: " + i + " using Dijkstra");
			dijkstra(i);
		}

	}

	void dijkstra(int source) {
		boolean visited[] = new boolean[v];

		int nodeDist[] = new int[v];
		for (int node = 0; node < nodeDist.length; node++) {
			nodeDist[node] = Integer.MAX_VALUE;
		}
		nodeDist[source] = 0;

		for (int node = 0; node < adj.length - 1; node++) {
			// find vertex with min dist and also not visited
			int minNodeIndex = findMinNodeIndex(nodeDist, visited);

			// Now explore its neighbors
			for (int i = 0; i < adj[minNodeIndex].size(); i++) {
				int nextNode = adj[minNodeIndex].get(i).dest;
				int dist = adj[minNodeIndex].get(i).weight;

				if (nodeDist[nextNode] > nodeDist[minNodeIndex] + dist && nodeDist[minNodeIndex] != Integer.MAX_VALUE) {
					nodeDist[nextNode] = nodeDist[minNodeIndex] + dist;
				}
			}
		}

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
