package graphs;

// https://www.youtube.com/watch?v=rbKcTM3RREw&feature=youtu.be&ab_channel=CodingNinjasIndia
// https://www.youtube.com/watch?v=wU6udHRIkcc&ab_channel=AbdulBari

import java.util.*;

// Union and find algo used
// Weighted union also shown in comments
// Collapsing find algo remaining

public class KruskalsAlgorithm {
	public static void main(String[] args) {

		Graph13 graph = new Graph13(6, 11);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(2, 4, 9);
		graph.addEdge(4, 5, 5);
		graph.addEdge(3, 5, 7);
		graph.addEdge(4, 3, 11);
		graph.addEdge(2, 5, 10);
		graph.addEdge(0, 3, 3);
		graph.addEdge(2, 1, 8);
		graph.addEdge(2, 3, 6);

		graph.printEdges();

		System.out.println("\nEdges included in MST using krushkal: ");
		graph.krushalAlgo();

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
		Edge selectedEdges[] = new Edge[v - 1];
		int count = 0;

		int parent[] = new int[v];
		for (int i = 0; i < v; i++)
			parent[i] = -1;

		for (int i = 0; i < e && count < v - 1; i++) {
			Edge currentEdge = edges[i];
			int node1 = currentEdge.source;
			int node2 = currentEdge.dest;

			// check if edge doesn't form a cycle; check if both nodes are in same set
			int parent1 = findParent(node1, parent); // find Algo
			int parent2 = findParent(node2, parent);

			if (parent1 != parent2) {
				parent[parent1] = parent2; // Union operation

// Acc to Bari Sir( timestamp @17:10 ), Weighted Union
//				if(parent[parent1] <= parent[parent2]) {
//					int weight = parent[parent2];
//					parent[parent2] = parent1;
//					parent[parent1] = parent[parent1] + weight ;
//				} else {
//					int weight = parent[parent1];
//					parent[parent1] = parent2;
//					parent[parent2] = parent[parent2] + weight;
//				}

				selectedEdges[count] = currentEdge;
				count++;
			} else // cycle detected
				continue;
		}

		int cost = 0;
		for (Edge e : selectedEdges) {
			cost += e.weight;
			System.out.println(e.source + "-" + e.dest + ": " + e.weight);
		}
		System.out.println("MST cost is: " + cost);

	}

	private int findParent(int node, int[] parent) {
		int parentNode = parent[node];

		if (parentNode < 0) // or parentNode == -1
			return node;

		return findParent(parentNode, parent);

	}

}