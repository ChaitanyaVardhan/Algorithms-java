public class Digraph {
    private final int V;
    private final Bag<Integer>[] adj;

    public Digraph(int V) {
	this.V = V;
	adj = (Bag<Integer>[]) new Bag[V];
	for (int v = 0; v < V; v++)
	    adj[v] = new Bag<Integer>();
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
	int V, v, w;
	V = StdIn.readInt();
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
    }
}
