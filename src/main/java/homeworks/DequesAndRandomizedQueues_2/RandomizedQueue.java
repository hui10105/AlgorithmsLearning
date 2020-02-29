package homeworks.DequesAndRandomizedQueues_2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int arraySize;
    private int size;
    private final static int N = 2;
    private final static double SUB = 0.25;
    private final static int minSize = 4;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        size = 0;
        arraySize = minSize;
        items = (Item[]) new Object[arraySize];
        //items = (Item[]) Array.newInstance(ArrayList.class, 4);
    }

    /**
     * is the randomized queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the randomized queue
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     *
     * @param item
     */
    //
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null not accepted!");
        }
        if (size < arraySize) {
            items[size] = item;
            size++;
        } else {
            arraySize = arraySize * N;
            Item[] newItems = (Item[]) new Object[arraySize];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            newItems[size] = item;
            items = newItems;
            size++;
        }
    }

    /**
     * remove and return a random item
     *
     * @return
     */
    //
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Empty queue can't dequeue!");
        }
        int randomIndex = randomIndex();
        Item popItem = items[randomIndex];
        items[randomIndex] = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size > minSize && size < (arraySize * SUB)) {
            arraySize = (int) (arraySize * SUB);
            Item[] newItems = (Item[]) new Object[arraySize];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        return popItem;

    }

    /**
     * return a random item (but do not remove it)
     *
     * @return
     */
    //
    public Item sample() {
        if (!isEmpty()) {
            return items[randomIndex()];
        } else {
            throw new NoSuchElementException("Empty queue has no sample!");
        }
    }

    private int randomIndex() {
        return StdRandom.uniform(size);
    }

    /**
     * return an independent iterator over items in random order
     *
     * @return Iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {
        private int i = size;
        private final int[] randomIndexs = new int[size];

        RandomArrayIterator() {
            for (int i = 0; i < size; i++) {
                randomIndexs[i] = i;
            }
            StdRandom.shuffle(randomIndexs);
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        /*@Override
        public void remove() { *//* not supported *//* }*/

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No Element anymore!");
            }
            return items[randomIndexs[--i]];
        }
    }

    /**
     * unit testing (optional)
     *
     * @param args
     */
    //
    public static void main(String[] args) {
        //
    }

}