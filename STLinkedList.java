public class STLinkedList<Key, Value>
{
    private STNode<Key, Value> current;
    private int n;

    private class STNode<Key, Value>
	{
	    Key key;
	    Value value;
	    STNode<Key, Value> next;
	}

    public STLinkedList()
	{
	    current = null;
	    n = 0;
	}

    public void put(Key key, Value value)
    {
	STNode<Key, Value> oldcurrent = current;
	current = new STNode<Key, Value>();
	current.key = key;
	current.value = value;
	current.next = oldcurrent;
	n++;
    }

    public Value get(Key key)
    {
	return null;
    }

    public void delete(Key key)
    {
    }

    public boolean contains(Key key)
    {
	return get(key) != null;
    }

    public boolean isEmpty()
    {
	return current == null;
    }

    public int size()
    {
	return n;
    }

    //    public Iterable<Key> keys()
    //    {
    //    }

    public static void main(String[] args)
    {
	STLinkedList<String, Integer> st = new STLinkedList<String, Integer>();

	for (int i = 0; !StdIn.isEmpty(); i++)
	    {
		String key = StdIn.readString();
		st.put(key, i);
	    }

	StdOut.println("Size of ST is :" + st.size());

	//	for (String s : st.keys())
	//	    StdOut.println(s + " " + st.get(s));
    }
}
