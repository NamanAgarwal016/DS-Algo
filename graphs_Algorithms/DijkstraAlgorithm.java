package graphs_Algorithms;

import java.util.*;

/*
Dijkstra's Algorithm on : 
Undirected/ Directed Weighted Graph

To find shortest path b/w src & every other node


#Without using Heaps
Logic: For each node, 
1st find non-visited minDistNode, and mark it visited
then traverse all it's neighbors and relax their edges
Relaxing means: nodeDist[nextNode] > nodeDist[minNodeIndex] + dist
finally nodeDist[] will have the shortest dist from source

Drawback : dosen't work properly For Negative weighted edge graphs

Time Complexity now : O[V*V]

Optimization : using Binary Heap Priority Queue implementation for findMinNodeIndex
Opti Time Complexity : O((E+V)*LogV) = O(ELogV) 
Time complexity can be further reduced to O(E + VLogV) using Fibonacci Heap. The reason is, Fibonacci Heap takes O(1) time for decrease-key operation while Binary Heap takes O(Logn) time.

#With using Heaps
Logic:
Here adj[] array of List of class Edge(node, dist)

Make nodeDist[], initialize all to inf, make nodeDist[src] = 0;
Make PQ<Edge> pq with Custom Comparator
We will store node and its best min dist from src in PQ.
insert src in pq with dist = 0.  pq.add(new Edge(src, 0))

Now similar to bfs, run while loop till pq is empty
remove node. That will automatically have minDist from src (as they are stored in min Heap)
traverse all its neighs
If possible to relax the neigh, then only add that neigh to pq, after relaxing it.
Relax means: nodeDist[neigh] > nodeDist[curr] + dist

Finally, all min dist will be stored in nodeDist[]

 */


public class DijkstraAlgorithm {

	public static void main(String[] args) {
		
		// Using Min Heap: Only this code is sufficient
//https://youtu.be/jbhuqIASjoM
		
		Graph7a graph3 = new Graph7a(5);
		graph3.addEdge(0, 1, 4);
		graph3.addEdge(0, 2, 8);
		graph3.addEdge(1, 2, 2);
		graph3.addEdge(1, 3, 5);
		graph3.addEdge(2, 3, 5);
		graph3.addEdge(2, 4, 9);
		graph3.addEdge(3, 4, 4);

		graph3.dijkstra(3);


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

		graph1.dijkstra(3);

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

// Using Min Heap
class Graph7a{
	private int v;

	private class Edge implements Comparator<Edge>{
		int dest, dist;

		public Edge(int dest, int dist) {
			this.dest = dest;
			this.dist = dist;
		}

		// Now for using custom comparator in PQ
		public Edge() {
		}
		public int compare(Edge o1, Edge o2) {
			return o1.dist - o2.dist;
		}
	}


	private List<Edge> adj[];

	public Graph7a(int v){
		this.v = v;
		adj = new List[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int source, int dest, int dist) {
		adj[source].add(new Edge(dest, dist));
		adj[dest].add(new Edge(source, dist));
	}

	void dijkstra(int src) {

		int nodeDist[] = new int[v];
		for(int i = 0; i < v; i++)
			nodeDist[i] = Integer.MAX_VALUE;
		nodeDist[src] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(new Edge());
		pq.add(new Edge(src, 0));

		while(!pq.isEmpty()) {
			int curr = pq.peek().dest;  //curr node from PQ will give minDistNode
			pq.poll();

			for(Edge edge: adj[curr]) {
				int neigh = edge.dest;
				int dist = edge.dist;		//dist b/w curr & neigh

				if(nodeDist[neigh] > nodeDist[curr] + dist) {
					nodeDist[neigh] = nodeDist[curr] + dist;
					pq.add(new Edge(neigh, nodeDist[neigh]));
				}
			}
		}

		System.out.println("\nDistance of nodes from source :");
		for (int node = 0; node < nodeDist.length; node++) {
			System.out.println(node + " : " + nodeDist[node]);
		}
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

		int parent[] = new int[v];
		parent[source] = -1;

		for (int node = 0; node < adj.length - 1; node++) { 
			// last node ke liye uske neighbrs already calculate kar diye

			// find vertex with min dist and also not visited
			int minNodeIndex = findMinNodeIndex(nodeDist, visited);

			// Now explore its neighbors
			for (int i = 0; i < adj[minNodeIndex].size(); i++) {
				int nextNode = adj[minNodeIndex].get(i).dest;
				int dist = adj[minNodeIndex].get(i).weight;

				if (nodeDist[nextNode] > nodeDist[minNodeIndex] + dist && nodeDist[minNodeIndex] != Integer.MAX_VALUE) {
					// 2nd condition bcoz: MAX_VALUE + any +ve = becomes negative and then this will be true : MAX_VALUE > MAX_VALUE + weight
					nodeDist[nextNode] = nodeDist[minNodeIndex] + dist;
					parent[nextNode] = minNodeIndex;
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

	private int findMinNodeIndex(int nodeDist[], boolean visited[]) {
		int minVertex = -1;			//to catch 1st non-visited, won't be possible with minVertex=0
		for (int i = 0; i < nodeDist.length; i++) {
			// Here order in OR condition is IMP, otherwise it will be indexOutOfBound = -1
			if (!visited[i] && (minVertex == -1 || nodeDist[i] < nodeDist[minVertex])) {		
				minVertex = i;
			}
		}

		visited[minVertex] = true;
		return minVertex;
	}
}