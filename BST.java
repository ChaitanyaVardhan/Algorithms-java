/* BST class implements a Symbol Table using an unbalanced
 *Binary Search Tree
 * The key value pairs in the symbol table are generic
 *methods support are put(), get(), delete(), contains(),
 *size() and isEmpty(). The class also supports additional
 *ordered methods minimum(), maximum(), floor(), select()
 *and ceiling(). The keys() method of the class allows
 *iterating over all the keys
 */

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
    }

    public boolean contains(Key key) {
	return false;
    }

    public int size() {
	return 999;
    }

    public boolean isEmpty(Key key) {
	return true;
    }

    public Iterable<Key> keys() {
	Queue<Key> queue = new Queue<Key>();
	queue.enqueue("Testing BST");
	return queue;
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

	//	for (String s : bst.keys())
	//	    StdOut.println(s + " " + bst.get(s));
    }
}
