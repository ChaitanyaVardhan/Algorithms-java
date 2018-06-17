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

    public static void main(String[] args) {
	RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
	for (int i = 0; !StdIn.isEmpty(); i++) {
	    String key = StdIn.readString();
	    StdOut.println("Root address :" + st.root);
	    st.put(key, i);
	}
	StdOut.println("Min key is: "+ st.min());
	StdOut.println("Max key is: "+ st.max());
    }
}
