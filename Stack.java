import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private int n;

    private static class Node<Item>
    {
	private Item item;
	private Node<Item> next;
    }

    public Stack()
	{
	    first = null;
	    n = 0;
	}

    public int size()
    { return n; }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
	Node<Item> oldfirst = first;
	first = new Node<Item>();
	first.item = item;
	first.next = oldfirst;
	n++;
    }

    public Item pop()
    {
	if (isEmpty())
	    throw new NoSuchElementException("Stack Underflow");
	Item item = first.item;
	first = first.next;
	n--;
	return item;
    }

    public Iterator<Item> iterator()
    { return new ListIterator<Item>(first); }

    private class ListIterator<Item> implements Iterator<Item>
    {
	Node<Item> current;

	public ListIterator(Node<Item> first)
	    { current = first; }

	public void remove()
	{ throw new UnsupportedOperationException(); }

	public boolean hasNext()
	{ return current != null; }

	public Item next()
	{
	    if (!hasNext())
		throw new NoSuchElementException();

	    Item item = current.item;
	    current = current.next;
	    return item;
	}
    }	

    public static void main(String[] args)
    {
	Stack<String> stack = new Stack<String>();
	while (!StdIn.isEmpty())
	    {
		String item = StdIn.readString();
		if (!item.equals("-"))
		    stack.push(item);
		else if (!stack.isEmpty())
		    StdOut.print(stack.pop() + " ");
	    }
	StdOut.println("Items left on the stack: " + stack.size());
    }
}
