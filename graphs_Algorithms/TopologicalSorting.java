package graphs_Algorithms;

// https://www.youtube.com/watch?v=qe_pQCh09yU&feature=youtu.be&ab_channel=TECHDOSE

import java.util.LinkedList;
import java.util.Stack;

// Toposort is only for Directed Acyclic Graph DAG.
// It is a linear order of vertices s.t. for every directed edge u->v , vetex U comes before vertex V. 
// Time Complexity: O(V+E).

public class TopologicalSorting {
	public static void main(String[] args) {
		Graph11 graph = new Graph11(4);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);

		graph.topologicalSort();
	}
}

class Graph11 {
	int v;
	LinkedList<Integer> adj[];

	public Graph11(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}

	public void topologicalSort() {
		
		// Detect cycle first.. if present then return "Can't sort"
		// -- this part code remaining --
		
		boolean visited[] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public void dfs(int i, boolean visited[], Stack<Integer> stack) {
		visited[i] = true;
		// Exploring neighbor
		for (int j = 0; j < adj[i].size(); j++) {
			int neighbor = adj[i].get(j);
			if (!visited[neighbor]) {
				dfs(neighbor, visited, stack);
			}
		}
		// Backtracking then push it into stack
		stack.push(i);
		return;
	}
}