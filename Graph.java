public class Graph
{
    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V)
    {
	this.V = V;
	adj = (Bag<Integer>[]) new Bag[V];

	for (int v = 0; v < V; v++)
	    adj[v] = new Bag<Integer>();
    }

    public void addEdge(int v, int w)
    {
	adj[v].add(w);
	adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public int V()
    { return this.V; }

    public static void main(String[] args)
    {
	int V = StdIn.readInt();
	int E = StdIn.readInt();
	Graph G = new Graph(V);
	
	while (!StdIn.isEmpty())
	    {
		int v = StdIn.readInt();
		int w = StdIn.readInt();
		G.addEdge(v, w);
	    }

	for (int v = 0; v < V; v++)
	    for (int w : G.adj(v))
		StdOut.println(v + "-" + w);
    }
}
