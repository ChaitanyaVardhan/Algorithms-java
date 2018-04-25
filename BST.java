/* BST class implements a Symbol Table using an unbalanced
 *Binary Search Tree
 * The key value pairs in the symbol table are generic
 *methods support are put(), get(), delete(), contains(),
 *size() and isEmpty(). The class also supports additional
 *ordered methods minimum(), maximum(), floor(), select()
 *and ceiling(). The keys() method of the class allows
 *iterating over all the keys
 */

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
	private Key key;
	private Value val;
	private Node left, right;
	private int size;

	public Node(Key key, Value val, int size) {
	    this.key = key;
	    this.val = val;
	    this.size = 1;
	}
    }

    public void put(Key key, Value val) {
	root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
	if (x == null) return new Node(key, val, 1);
	int cmp = key.compareTo(x.key);
	if (cmp < 0)      x.left = put(x.left, key, val);
	else if (cmp > 0) x.right = put(x.right, key, val);
	else              x.val = val;
	x.size = 1 + size(x.left) + size(x.right);
	return x;
    }

    public Value get(Key key) {
	return get(root, key);
    }

    private Value get(Node x, Key key) {
	if (key == null) throw new IllegalArgumentException("get() called with a null key");
	if (x == null) return null;
	int cmp = key.compareTo(x.key);
	if (cmp < 0)      return get(x.left, key);
	else if (cmp > 0) return get(x.right, key);
	else              return x.val;
    }

    public void delete(Key key) {
	if (key == null) throw new IllegalArgumentException("delete() called with a null key");
	root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
	if (x == null) return null;

	int cmp = key.compareTo(x.key);
	if (cmp < 0) x.left = delete(x.left, key);
	else if (cmp > 0) x.right = delete(x.right, key);
	else {
	    if (x.right == null) return x.left;
	    if (x.left == null) return x.right;
	    Node t = x;
	    x = min(t.right);
	    x.right = deleteMin(t.right);
	    x.left = t.left;
	}
	x.size = size(x.left) + size(x.right) + 1;
	return x;
    }

    public Key min() {
	if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
	return min(root).key;
    }

    private Node min(Node x) {
	if (x.left == null) return x;
	else return min(x.left);
    }

    public Key max() {
	if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
	return max(root).key;
    }

    private Node max(Node x) {
	if (x.right == null) return x;
	else return max(x.right);
    }

    public void deleteMin() {
	if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
	root = deleteMin(root);
    }
    
    private Node deleteMin(Node x) {
	if (x.left == null) return x.right;
	x.left = deleteMin(x.left);
	x.size = size(x.left) + size(x.right) + 1;
	return x;
    }
    
    public boolean contains(Key key) {
	if (key == null) throw new IllegalArgumentException("argument to contains() is null");
	return get(key) != null;
    }

    public int size() {
	return size(root);
    }

    private int size(Node x) {
	if (x == null) return 0;
	else return x.size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public Iterable<Key> keys() {
	if (isEmpty()) return new Queue<Key>();
	return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
	if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
	if (hi == null) throw new IllegalArgumentException("Second argument to keys() is null");

	Queue<Key> queue = new Queue<Key>();
	keys(root, queue, lo, hi);
	return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
	if (x == null) return;
	int cmplo = lo.compareTo(x.key);
	int cmphi = hi.compareTo(x.key);
	if (cmplo < 0) keys(x.left, queue, lo, hi);
	if (cmphi > 0) keys(x.right, queue, lo, hi);
	if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
    }
    public static void main(String[] args) {
	BST<String, Integer> bst = new BST<String, Integer>();
	String key;
	int value;

	while (!StdIn.isEmpty()) {
	    key = StdIn.readString();
	    value = StdIn.readInt();
	    StdOut.println(key + " " + value);
	    bst.put(key, value);
	}

	StdOut.println("Root: " + bst.root.key);
	StdOut.println("Root left: " + bst.root.left.key);
	StdOut.println("Root right: " + bst.root.right.key);

	StdOut.println("B: " + bst.get("B"));
	StdOut.println("A: " + bst.get("A"));
	StdOut.println("I: " + bst.get("I"));
	StdOut.println("E: " + bst.get("E"));
	StdOut.println("C: " + bst.get("C"));
	StdOut.println("H: " + bst.get("H"));
	StdOut.println("N: " + bst.get("N"));
	StdOut.println("R: " + bst.get("R"));
	StdOut.println("Y: " + bst.get("Y"));
	StdOut.println("S: " + bst.get("S"));
	StdOut.println("T: " + bst.get("T"));
	//	for (String s : bst.keys())
	//	    StdOut.println(s + " " + bst.get(s));
    }
}
