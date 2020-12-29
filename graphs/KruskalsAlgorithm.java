package graphs;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgorithm {
	public static void main(String[] args) {

		Graph13 graph = new Graph13(6, 11);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 5);
		graph.addEdge(2, 3, 10);
		graph.addEdge(0, 3, 4);
		graph.addEdge(1, 3, 3);
		graph.addEdge(1, 2, 6);
		graph.addEdge(3, 4, 7);
		graph.addEdge(2, 4, 8);
		graph.addEdge(4, 5, 2);
		graph.addEdge(2, 5, 9);
		graph.addEdge(3, 5, 6);

		graph.printEdges();

	}
}

class Graph13 {
	int v; // no. of vertices
	int e; // no. of edges

	class Edge {
		int source, dest, weight;
	}

	Edge edges[];
	int index;

	public Graph13(int v, int e) {
		this.v = v;
		this.e = e;
		edges = new Edge[e];
		index = 0;
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge();
		}
	}

	public void addEdge(int source, int dest, int weight) {
		edges[index].source = source;
		edges[index].dest = dest;
		edges[index].weight = weight;
		index++;
	}

	public void printEdges() {
// Arrays.sort(edges); // Using Comparable

// Arrays.sort(edges, new SortByWeight()); //Using class SortByWeight which implements Comparator

		for (Edge e : edges) {
			System.out.println(e.source + "-" + e.dest + ": " + e.weight);
		}
	}

	public void krushalAlgo() {
		// Sort the edges acc to weight
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});

		// Select v-1 edges for MST
		Edge selectedEdges[] = new Edge[v-1];
		int count = 0;
		
		while(count < v-1) {
			
		}
	}

}