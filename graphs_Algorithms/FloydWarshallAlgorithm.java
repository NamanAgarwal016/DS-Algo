package graphs_Algorithms;
//https://www.youtube.com/watch?v=oNI0rf2P9gE&t=370s&ab_channel=AbdulBari


// Time complexity = O[V^3]   ; space = O[V^2]
// floyd Warshall can detect -ve edge weight cycle: by checking if the dist from vertex to itself is negative or not. 


// Works well with the -ve edges.
// Dynamic Prog approach

// "So Basically checking for every pair of vertices, do we get a shorter dist b going through K(th) Vertex"

// For getting the path matrix for shortest dist : https://www.youtube.com/watch?v=LwJdNfdLF9s&ab_channel=TusharRoy-CodingMadeSimple

public class FloydWarshallAlgorithm {
	public static void main(String[] args) {
		int inf = Integer.MAX_VALUE;
		int adj[][] = { 
				
				{0, 3, inf, 7}, 
				{8, 0, 2, inf}, 
				{5, inf, 0, 1}, 
				{2, inf, inf, 0} 
					
		};
		
//		// -ve edge weight cycle
//		int adj1[][] = { 
//				
//				{0, 2, inf}, 
//				{inf, 0, 3}, 
//				{-6, inf, 0} 
//					
//		};

		Graph9 graph = new Graph9(4, adj);
		graph.floydWarshall();
	}
}

class Graph9 {
	// using Adjacency matrix here
	int adj[][];
	int v;

	public Graph9(int v, int adj[][]) {
		this.v = v;
		this.adj = adj;
	}

	public void floydWarshall() {

		for (int k = 0; k < v; k++) {
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					
					if (!(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE)) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}

				}
			}
		}
		
		for (int i = 0; i < v; i++) {
			if(adj[i][i] < 0) {
				System.out.println("Negative cycle detected!!");
				return;
			}
		}

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
}
