public class Queue<Item> implements Iterable<Item> {
    private class Node<Item> {
	Item item;
	Node next;

	public Node(Item item, Node last) {
	    this.item = item;
	    Node<Item> oldlast = last;
	    this.next = null;
	    oldlast.next = this;
	}

    }

    public Queue() {
	n = 0;
    }

    public enqueue(Item item) {
	last = new Node<Item>(item, last);
    }
	    
}
