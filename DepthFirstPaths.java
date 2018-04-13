public class DepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    
    public DepthFirstPaths(Graph G, int s)
    {
	this.s = s;
	edgeTo = new int[G.V()];
	marked = new boolean[G.V()];
	dfs(G, s);
    }

    private void dfs(Graph G, int v)
    {
	marked[v] = true;
	for (int w : G.adj(v))
	    if (!marked[w])
		{
		    dfs(G, w);
		    edgeTo[w] = v;
		}
    }

    public boolean hasPathTo(int v)
    { return marked[v]; }

    public Iterable<Integer> pathTo(int v)
    {
	if (!hasPathTo(v)) return null;
	Stack<Integer> path = new Stack<Integer>();
	for (int x = v; x != s; x = edgeTo[x])
	    path.push(x);
	path.push(s);
	return path;
    }

    public static void main(String[] args)
    {
	int V, E;
	Graph G;
	DepthFirstPaths dfsPath;

	V = StdIn.readInt();
	StdOut.println("Vertex read from file is: " + V);
	E = StdIn.readInt();
	StdOut.println("Edge read from file is: " + E);
	G = new Graph(V);
	
	while (!StdIn.isEmpty())
	    {
		int v = StdIn.readInt();
		int w = StdIn.readInt();
		G.addEdge(v, w);
	    }

	for (int v = 0; v < G.V(); v++)
	    for (int w : G.adj(v))
		StdOut.println(v + "--" + w);

	StdOut.println("Print DFS paths");

	int s = 0;
	dfsPath = new DepthFirstPaths(G, s);
	for (int v = 0; v < G.V(); v++)
	    if (dfsPath.hasPathTo(v))
		StdOut.println(v);
    }
}
