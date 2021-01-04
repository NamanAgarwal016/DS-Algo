package graphs_Algorithms;

// Anuj Bhaiya Approaches of : Represenataion, shortest path using bfs, dfs

import java.util.*;

public class Graphs {
	
	private static LinkedList<Integer> adj[];	// array of linked lists
	
	public Graphs(int v) {
		adj = new LinkedList[v];			
											// just for initialization
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	// adding edge to the graph
	public void createEdge(int start, int end) {
		adj[start].add(end);
		adj[end].add(start);
	}
	
	// bfs to find shortest path
	public int bfs(int source, int destination) {
		boolean visited[] = new boolean[adj.length];
		
		int parent[] = new int[adj.length];   // use to tell who introduces whom
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(source);
		parent[source] = -1;  // no one introduces source
		visited[source] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			if (current == destination) break;
			
			for(int neighbour: adj[current]) {
				if(! visited[neighbour]) {
					visited[neighbour]  = true;
					q.add(neighbour);
					parent[neighbour] = current;
				}
			}
		}
		
		int current = destination;
		int distance = 0;
		while(parent[current] != -1) {
			System.out.print(current + "-> ");
			current = parent[current];
			distance++;
		}
		System.out.print(source);
		
		return distance;
	}
	
	// dfs recursive approach to find path exist or not
	private boolean dfsUtil(int source, int destination, boolean vis[]) {
		if(source == destination) 	return true;
		
		for(int neighbour: adj[source]) {
			if(! vis[neighbour]) {
				vis[neighbour] = true;
				boolean isConnected = dfsUtil(neighbour, destination, vis);
				if(isConnected) return true;
			}
		}
		return false;
	}
	
	
	public boolean dfs(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		
		return dfsUtil(source, destination, vis);
	}
	
// using stack and backtracking
	public boolean dfsStack(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(source);
		
		while(! stack.isEmpty()) {
			int current = stack.pop();
			
			if(current == destination) return true;
			
			for(int neighbour: adj[current]) {
				if(!vis[neighbour]) {
					vis[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices and edges");
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graphs graph = new Graphs(v);
		
		System.out.println("Enter " + e + " edges");
		for (int i = 0; i < e; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			graph.createEdge(start, end); 
		}
		
		System.out.println("Adjacency List: ");
		for(int i = 0; i < v; i++) {
			for(int a: adj[i]) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		System.out.println("Enter source and destination: ");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		int shortestDistance = graph.bfs(source, destination);
		System.out.println("\nShortest distance is:  " + shortestDistance);
		
		System.out.println("possible " + graph.dfs(source, destination));
		System.out.println("possible " + graph.dfsStack(source, destination));
		
		
	}
}
