/********************************************************
 * A directed graph implemented using an array of lists.
 * The input file has number of vertices on line1 followed by
 * the number of edges on line 2. The lines after that have
 * 2 integers v w that represent and edge v-->w
 * 
 */

import java.util.NoSuchElementException;

public class Digraph {
    private final int V;
    private int E;
    private final Bag<Integer>[] adj;
    private int[] indegree;

    public Digraph(int V) {
	this.V = V;
	this.E = 0;
	adj = (Bag<Integer>[]) new Bag[V];
	for (int v = 0; v < V; v++)
	    adj[v] = new Bag<Integer>();
    }

    public Digraph(In in) {
	try {
	    this.V = in.readInt();
	    if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be negative");
	    indegree = new int[V];
	    adj = (Bag<Integer>[]) new Bag[V];
	    for (int v = 0; v < V; v++) {
		adj[v] = new Bag<Integer>();
	    }
	    E = in.readInt();
	    if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
	    for (int i= 0; i < E; i++) {
		int v = in.readInt();
		int w = in.readInt();
		addEdge(v, w);
	    }
	}
	catch (NoSuchElementException e) {
	    throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
	}
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
    }

    public int V() {
	return V;
    }

    public int E() {
	int edges = 0;
	for (int v = 0; v < V; v++)
	    edges += adj[v].size();
	return edges;
    }

    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    public static void main(String[] args) {
	StdOut.println("Create an empty Digraph and add edges from input file");
	int V, E, v, w;
	V = StdIn.readInt();
	E = StdIn.readInt();
	Digraph digraph = new Digraph(V);

	while (!StdIn.isEmpty()) {
	    v = StdIn.readInt();
	    w = StdIn.readInt();
	    digraph.addEdge(v, w);
	}

	for (int i = 0; i < digraph.V(); i++) {
	    for (int j : digraph.adj(i))
		StdOut.println(i + "->" + j);
	}

	StdOut.println("No. of vertices: " + digraph.V());
	StdOut.println("No. of edges: " + digraph.E());

	StdOut.println("Create an Directed Graph from input file");

	In in = new In(args[0]);
	Digraph G = new Digraph(in);
	StdOut.println(G);
    }
}
