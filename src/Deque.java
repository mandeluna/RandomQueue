import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int count;

    @SuppressWarnings("hiding")
    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }

    // construct an empty deque
    public Deque() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the deque
    public int size() {
        return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node<Item> oldHead = head;
        head = new Node<Item>();
        head.item = item;
        head.next = oldHead;
        if (tail == null) {
            tail = head;
        }
        else {
            oldHead.prev = head;
        }
        count++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        Node<Item> oldTail = tail;
        tail = new Node<Item>();
        tail.item = item;
        tail.prev = oldTail;
        if (head == null) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        count++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = head.item;
        --count;
        // there is only one item in the deque
        if (head.next == null) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = tail.item;
        --count;
        // there is only one item in the deque
        if (tail.prev == null) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> curr = head;

            @Override
            public boolean hasNext() {
                return curr  != null;
            }

            @Override
            public void remove() {
            	throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {
            	if (curr == null) {
            		throw new java.util.NoSuchElementException();
            	}
                Item item = curr.item;
                curr = curr.next;
                return item;
            }
        };
    }

    // unit testing
    public static void main(String[] args) {
    }
}
