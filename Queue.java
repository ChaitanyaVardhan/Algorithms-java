import java.util.NoSuchElementException;
import java.util.Iterator;


public class Queue<Item> implements Iterable<Item> {
    private Node first, last;
    private int n;

    private class Node {
	Item item;
	Node next;

	public Node(Node last, Item item) {
	    Node oldlast = last;
	    this.item = item;
	    this.next = null;
	    if (isEmpty()) first = last;
	    else           oldlast.next = this;
	}

    }

    public Queue() {
	first = null;
	last = null;
	n = 0;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public int size() {
	return n;
    }

    public void enqueue(Item item) {
	last = new Node(last, item);
	n++;
    }
    
    public Item dequeue() {
	if (isEmpty()) throw new NoSuchElementException("Queue is empty");
	Item item = first.item;
	first = first.next;
	n--;
	if (isEmpty()) last = null;
	return item;
    }

    public Iterator<Item> iterator() {
	return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<Item> {
        Node current;

	public QueueIterator(Node first){
	    current = first;
	}

	public boolean hasNext() {
	    return current != null;
	}

	public Item next() {
	    if (!hasNext()) throw new NoSuchElementException();
	    Item item = current.item;
	    current = current.next;
	    return item;
	}

	public void remove() {throw new UnsupportedOperationException();}
    }

    public static void main(String[] args) {
	Queue<String> queue = new Queue<String>();
	String item;

	while (!StdIn.isEmpty()) {
	    item = StdIn.readString();
	    if (!item.equals("-"))
		queue.enqueue(item);
	    else if (!queue.isEmpty())
		StdOut.print(queue.dequeue() + " ");
	}
	StdOut.println("(" + queue.size() + " items left on the queue)");

        StdOut.println("Iterator");
	for (String s : queue)
	    StdOut.print(s + " ");
    }
}
