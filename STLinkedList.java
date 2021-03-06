import java.util.Iterator;
import java.util.NoSuchElementException;

public class STLinkedList<Key, Value> implements Iterable<Key>
{
    private STNode current;
    private int n;

    private class STNode
	{
	    Key key;
	    Value value;
	    STNode next;

	    public STNode(Key key, Value value, STNode next)
	    {
		this.key = key;
		this.value = value;
		this.next = next;
	    }
	}

    public STLinkedList()
	{
	}

    public void put(Key key, Value value)
    {
	if (key == null) throw new IllegalArgumentException("No key supplied");
	
	for (STNode x = current; x != null; x = x.next)
	    {
		if(key.equals(x.key))
		    {
			x.value = value;
			return;
		    }
	    }
	current = new STNode(key, value, current);
	n++;
    }

    public Value get(Key key)
    {
	if (key == null) throw new IllegalArgumentException("No key supplied");
	for ( STNode x = current; x != null; x = x.next)
	    {
		if (key.equals(x.key))
		    return x.value;
	    }
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

    public Iterator<Key> iterator()
    {
	return new ListIterator(current);
    }


    public class ListIterator implements Iterator<Key>
    {
	STNode pos;

	public ListIterator(STNode current)
	    {
		pos = current;
	    }

	public boolean hasNext()
	{
	    return pos != null;
	}

	public Key next()
	{
	    if (!hasNext())
		throw new NoSuchElementException();

	    Key key = pos.key;
	    pos = pos.next;
	    return key;
	}

	public void remove()
	{
	    throw new UnsupportedOperationException();
	}
    }

    public static void main(String[] args)
    {
	STLinkedList<String, Integer> st = new STLinkedList<String, Integer>();

	for (int i = 0; !StdIn.isEmpty(); i++)
	    {
		String key = StdIn.readString();
		st.put(key, i);
	    }

	StdOut.println("Size of ST is :" + st.size());

	
	for (String s : st)
	    StdOut.println(s + " " + st.get(s));

    }
}
