public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;
    
    public UnorderedMaxPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity]; }

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    { pq[N++] = x; }

    public int size()
    { return N; }

    public Key delMax()
    {
	int max = 0;
	for (int i = 0; i < N; i++) 
	    if (less(max, i)) max = i;
	exch(max, N-1);
	return pq[--N];
    }

    private boolean less(int max, int i)
    { return pq[max].compareTo(pq[i]) < 0; }

    private void exch(int max, int last)
    {
	Object temp = pq[max];
	pq[max] = pq[last];
	pq[last] = pq[max];
    }

    public static void main(String[] args)
    {
	int capacity = StdIn.readInt();	
	UnorderedMaxPQ<String> pq = new UnorderedMaxPQ<String>(capacity);
	while (!StdIn.isEmpty()) {
	    String item = StdIn.readString();
	    if (!item.equals("-")) pq.insert(item);
	    else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
	}
	StdOut.println("(" + pq.size() + " items left on the queue )");
    }
    
}
