package homeworks.DequesAndRandomizedQueues_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node front;
    private Node end;
    private int size = 0;

    private class Node {
        Item item;
        Node previous;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    public Deque() {

    }                           // construct an empty deque

    public boolean isEmpty() {
        // is the deque empty?
        return size == 0;
    }

    public int size() {
        // return the number of items on the deque
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null not acceptable!");
        }
        size++;
        Node node = new Node(item);
        if (front == null) {
            front = node;
            end = node;
        } else {
            front.previous = node;
            node.next = front;
            front = node;
        }
    }

    /**
     * add the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null not acceptable!");
        }
        size++;
        Node node = new Node(item);
        if (end == null) {
            front = node;
            end = node;
        } else {
            end.next = node;
            node.previous = end;
            end = node;
        }
    }

    /**
     * remove and return the item from the front
     *
     * @return item
     */
    public Item removeFirst() {
        if (front == null) {
            throw new NoSuchElementException("Empty Deque can't remove first!");
        } else {
            size--;
            Item firstItem = front.item;
            if(front.next != null){
                front.next.previous = null;
            } else {
                end = null;
            }
            front = front.next;
            return firstItem;
        }
    }

    /**
     * remove and return the item from the end
     *
     * @return item
     */
    public Item removeLast() {
        if (end == null) {
            throw new NoSuchElementException("Empty Deque can't remove end!");
        } else {
            size--;
            Item endItem = end.item;
            if(end.previous != null){
                end.previous.next = null;
            } else {
                front = null;
            }
            end = end.previous;
            return endItem;
        }
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("No Element anymore!");
            }
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }
}