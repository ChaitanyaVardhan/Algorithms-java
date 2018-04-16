public class ST<Key, Value>
{
    public ST()
	{
	}

    public void put(Key key, Value value)
    {
    }

    public Value get(Key key)
    {
    }

    public void delete(Key key)
    {
    }

    public boolean contains(Key key)
    {
    }

    public boolean isEmpty()
    {
    }

    public int size()
    {
    }

    Public Iterable<Key> keys()
    {
    }

    public static void main(String[] args)
    {
	ST<String, int> st = new ST<String, int>();

	for (int i = 0; !StdIn.isempty(); i++)
	    {
		String key = StdIn.readString();
		st.put(key, i);
	    }

	for (String s : st.keys())
	    StdOut.println(s + " " + st.get(s));
    }
}
