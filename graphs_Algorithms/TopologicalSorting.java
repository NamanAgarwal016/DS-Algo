package graphs_Algorithms;

// dfs : https://www.youtube.com/watch?v=qe_pQCh09yU&feature=youtu.be&ab_channel=TECHDOSE

// bfs/ Kahn's Algo : https://youtu.be/tggiFvaxjrY

import java.util.*;
/*
Toposort is only for Directed Acyclic Graph DAG.
It is a linear order of vertices s.t. for every directed edge u->v , vetex U comes before vertex V.

Logic: Use dfs and Stack to get the sorting.
Visit a node, then visit it's all neighbors
before going to next node, push it in stack(backtracking)
do this for all nodes

Time Complexity: O(V+E).

Topological sort BFS = Kahn's Algorithm = Least In-degree Node Approach :
	Step1 : find in-degree for all vertices
    Step2 : Push all nodes with indegree = 0 in q
    Step3 : apply bfs & process (remove nodes and decrease indgree og neighbors)
    Step4 : push indegree = 0 nodes & maintain a count of processed nodes

    finally if count != no. of nodes then graph is not DAG, has cycle, no toposort

    Time Complexit : O [V + E]
 */
public class TopologicalSorting {
	public static void main(String[] args) {
		Graph11 graph = new Graph11(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);

		graph.topologicalSort();
		System.out.println();
		graph.bfs();
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
		// -- this part code remaining --	simply insert cycle detection in directed graph code 

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


	//  Kahn's Algo - bfs
	public void bfs(){
		int ans[] = new int[v];

		int inDeg[] = new int[v];   // in-degree array
		for(int i = 0; i < v; i++)
			for(int e: adj[i])
				inDeg[e]++;

		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < v; i++)              // first pushing inDegree = 0 nodes
			if(inDeg[i] == 0)
				q.add(i);

		int count = 0;          // for detecting cyclic/ non-DAG graph
		// keeps count of how many nodes processed

		while(!q.isEmpty()){
			int curr = q.poll();
			ans[count] = curr;   // using count as index also
			count++;                

			for(int ng: adj[curr]){
				inDeg[ng]--;        // breaking curr node from graph, affects neigbors
				if(inDeg[ng] == 0)
					q.add(ng);
			}
		}

		if(count != v)              // cycle detected
			System.out.println(" Graph is not DAG, has a cycle");

		for(int e: ans)
			System.out.print(e + " ");
	}  
}