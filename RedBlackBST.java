/************************************************************************
 * Compilation: javac RedBlackBST.java
 * Execution: java RedBlackBST < input.txt
 * Dependencies: StdIn.java, StdOut.java
 * 
 * This code implements a symbol table using a left-leaning Red-Black BST
 *************************************************************************/

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
	private Key key;
	private Value val;
	private Node left, right;
	private boolean color;
	private int size;

	public Node(Key key, Value val, boolean color, int size) {
	    this.key = key;
	    this.val = val;
	    this.color = color;
	    this.size = size;
	}
    }

    public RedBlackBST() {
    }

    public void put(Key key, Value val) {
	root = put(root, key, val);
    }

    public Key min() {
	return min(root).key;
    }

    public Key max() {
	return max(root).key;
    }

    public Iterable<Key> keys() {
	return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
	Queue<Key> queue = new Queue<Key>();
	keys(root, queue, lo, hi);
	return queue;
    }

    private Node put(Node h, Key key, Value val) {
	if (h == null) return new Node(key, val, RED, 1);

	int cmp = key.compareTo(h.key);
	if (cmp < 0) h.left = put(h.left, key, val);
	else if (cmp > 0) h.right = put(h.right, key, val);
	else h.val = val;

	return h;
    }


    private Node min(Node x){
	if (x.left == null) return x;
	else return min(x.left);
    }

    private Node max(Node x) {
	if (x.right == null) return x;
	else return max(x.right);
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
	if (x == null) return;
	int cmplo = lo.compareTo(x.key);
	int cmphi = hi.compareTo(x.key);
	StdOut.print("key :"+ x.key + " cmplo :" + cmplo + " cmphi :" + cmphi + "\n");
	if (cmplo < 0) keys(x.left, queue, lo, hi);
	if (cmplo <= 0 && cmphi >= 0) {
	    StdOut.println("Enqueing : " + x.key);
	    queue.enqueue(x.key);
	}
	if (cmphi > 0) keys(x.right, queue, lo, hi);

    }

    public static void main(String[] args) {
	RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
	for (int i = 0; !StdIn.isEmpty(); i++) {
	    String key = StdIn.readString();
	    StdOut.println("Root address :" + st.root);
	    st.put(key, i);
	}
	StdOut.println("Min key is: "+ st.min());
	StdOut.println("Max key is: "+ st.max());
	StdOut.print("Iterable :" + st.keys());
	for (String key : st.keys())
	    StdOut.println("Key :" + key);
    }
}
