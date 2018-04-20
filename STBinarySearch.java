public class STBinarySearch<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public STBinarySearch() {
	this(INIT_CAPACITY);
    }

    public STBinarySearch(int capacity) {
	keys = (Key[]) new Comparable[capacity];
	vals = (Value[]) new Comparable[capacity];
    }

    private void resize(int capacity) {
	assert capacity >= n;
	Key[] tempk = (Key[]) new Comparable[capacity];
	Value[] tempv = (Value[]) new Comparable[capacity];

	for (int i = 0; i < n; i++) {
	    tempk[i] = keys[i];
	    tempv[i] = vals[i];
	}

	vals = tempv;
	keys = tempk;
    }

    public int size() {
	return n;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public boolean contains(Key key) {
	if (key == null) throw new IllegalArgumentException("argument to contains() is null");
	return get(key) != null;
    }

    public int rank(Key key) {
	if (key == null) throw new IllegalArgumentException("Argument to rank is null");

	int lo = 0, hi = n - 1;
	while (lo <= hi) {
	    int mid = lo + (hi - lo)/2;
	    int cmp = key.compareTo(keys[mid]);
	    if (cmp < 0) hi = mid - 1;
	    else if (cmp > 0) lo = mid + 1;
	    else return mid;
	}
	return lo;
    }

    public void put(Key key, Value val) {
	if (key == null) throw new IllegalArgumentException("Argument to put is null");

	int i = rank(key);

	// key already in the table
	if (i < n && keys[i].compareTo(key) == 0) {
	    vals[i] = val;
	    return;
	}

	//insert new key value pair
	//double the size of array
	if (n == keys.length) resize(2*keys.length);

	//shift keys and values one position right
	for (int j = n; j > i; j--) {
	    keys[j] = keys[j-1];
	    vals[j] = vals[j-1];
	}

	//insert the key and value at correct position
	keys[i] = key;
	vals[i] = val;
	n++;
    }

    public Value get(Key key) {
	if (key == null) new IllegalArgumentException("Argument to get is null");
	if (isEmpty()) return null;
	int i = rank(key);
	if (i < n && keys[i].compareTo(key) == 0) return vals[i];
	return null;
    }

    public Key max() {
	if (isEmpty()) throw new IllegalArgumentException("called max() with empty symbol table");
	return keys[0];
    }

    public Key min() {
	if (isEmpty()) throw new IllegalArgumentException("called min() with empty symbol table");
	return keys[n-1];
    }

    public Iterable<Key> keys() {
	return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
	if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
	if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

	Queue<Key> queue = new Queue<Key>();
	if (lo.compareTo(hi) > 0) return queue;
	for (int i = rank(lo); i < rank(hi); i++)
	    queue.enqueue(keys[i]);
	if (contains(hi)) queue.enqueue(keys[rank(hi)]);
	return queue;
    }
	    
    public static void main(String[] args) {
	STBinarySearch<String, Integer> st = new STBinarySearch<String, Integer>();
	for (int i = 0; !StdIn.isEmpty(); i++) {
	    String key = StdIn.readString();
	    st.put(key, i);
	}

	for (String s : st.keys())
	    StdOut.println(s + " " + st.get(s));
    }

}
