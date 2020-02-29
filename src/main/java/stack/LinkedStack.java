package stack;

import java.util.Iterator;

/**
 * 链表栈的实现
 *
 * @author rhzhou
 */
public class LinkedStack<T> implements Stack<T>, Iterable<T>{
    private Node first;

    private int n = 0;

    public LinkedStack(){
    }

    LinkedStack(T item){
        first = new Node(item);
        n = 1;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() { /* not supported */ }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    class Node {
        T item;
        Node next;
        Node(){
        }

        Node(T item){
            this.item = item;
        }
    }

    @Override
    public void push(T item) {
        Node node = new Node(item);
        node.next = first;
        first = node;
        n++;
    }

    @Override
    public T pop() throws Exception {
        if(n == 0){
            throw new Exception("Empty stack can't pop!");
        }
        Node tempNode = first;
        first = first.next;
        n--;
        return tempNode.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public T top() throws Exception {
        if(!isEmpty()){
            return first.item;
        } else {
            throw new Exception("Empty Stack has no top!");
        }
    }
}
