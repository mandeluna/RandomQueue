import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int count = 0;
    private Item[] items;

    // construct an empty randomized queue
    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
       items = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return count == 0;
    }

    // return the number of items on the queue
    public int size() {
        return count;
    }
    
    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Item[] copy = (Item[]) new Object[capacity];
        for (int i=0; i < count; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        if (count == items.length) {
            resize(count * 2);
        }
        items[count++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(count);
        Item item = items[index];
        // swap removed item and index at end of queue
        items[index] = items[count - 1];
        --count;
        if (count > 0 && count == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(count);
        return items[index];
    }

    // return an independent iterator over items in random order
    @SuppressWarnings("unchecked")
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            int index = 0;
            int num_items = count;
            Item[] shuffled;
            {
                shuffled = (Item[]) new Object[count];
                for (int i=0; i < count; i++) {
                	shuffled[i] = items[i];
                }
                StdRandom.shuffle(shuffled);
            }

            @Override
            public boolean hasNext() {
                return index < num_items;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {
                if (index > num_items) {
                    throw new java.util.NoSuchElementException();
                }
                return shuffled[index++];
            }
        };
    }

    // unit testing
    public static void main(String[] args) {
        
    }

}
