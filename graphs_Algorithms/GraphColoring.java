package graphs_Algorithms;

// https://www.youtube.com/watch?v=oikZlz1GNbo&feature=youtu.be&ab_channel=FitCoder

import java.util.*;

// Applications: making schedule/ timetable ; Map Coloring ; Bipatite graph checking

public class GraphColoring {
	public static void main(String[] args) {

		int colors[] = { 9, 8, 7 };
		Graph14 graph = new Graph14(4, colors);

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(3, 1);

		// m-coloring decision problem
// Find if the graph can be colored using provided color set
		int m = 3;
		int startingVertex = 0;
		boolean possibleToColor = graph.mColorDecision(m, startingVertex);
		if (!possibleToColor)
			System.out.println("Graph can't be colored, Increase the number of colors");
		else
			System.out.println("Graph can be colored!!");

		// m-coloring permutation problem
// Find no. of ways to color the graph using provided color set
		System.out.println("\n\nAll possible color combinations: ");
		graph.mColorpermutation(m, startingVertex);

		// m-coloring Optimization problem
// Find minimum no. of colors required to color the graph : chromatic number
		System.out.println("\n\nMinimum No. of colors required: " + graph.mColorOptimization());
		graph.printColoredArray();

	}
}

class Graph14 {
	int V;
	LinkedList<Integer> adj[];

	int colors[];
	int coloredVertex[];

	public Graph14(int v, int colors[]) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		coloredVertex = new int[v];
		this.colors = colors;
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public boolean mColorDecision(int m, int v) {
		if (v == V) { // if all vertices are colored
			return true;
		}

		for (int color = 1; color <= m; color++) {
			if (canUseColor(color, v)) {

				coloredVertex[v] = color;

				if (mColorDecision(m, v + 1)) {
					return true;
				}

				coloredVertex[v] = 0; // backtracking
			}
		}

		return false;
	}

	public void mColorpermutation(int m, int v) {
		if (v == V) { // if all vertices are colored
			printColoredArray();
			return;
		}

		for (int color = 1; color <= m; color++) {
			if (canUseColor(color, v)) {

				coloredVertex[v] = color;

				mColorpermutation(m, v + 1);

				coloredVertex[v] = 0; // backtracking
			}
		}
	}

	public int mColorOptimization() {
		int color = 1;

		for (int v = 0; v < V; v++) {

			if (canUseColor(color, v)) {
				coloredVertex[v] = color;
				color = 1;
				continue;
			} else {
				v--;
				color++;
			}
		}

		int max = 0;
		for (int count : coloredVertex) {
			if (count > max)
				max = count;
		}
		return max;
	}

	public boolean canUseColor(int color, int node) {
		for(int neigh: adj[node])
			if(color == coloredVertex[neigh])
				return false;
		return true;
	}

	public void printColoredArray() {
		for (int i = 0; i < V; i++) {
			System.out.print(coloredVertex[i] + " ");
		}
		System.out.println();
	}

}