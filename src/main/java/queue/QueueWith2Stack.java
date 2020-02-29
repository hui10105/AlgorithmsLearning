package queue;

import stack.Stack;

public class QueueWith2Stack<T> implements Queue<T>{
    private Stack<T> tail;
    private Stack<T> head;


    @Override
    public void enqueue(T item) {
        tail.push(item);
    }

    @Override
    public T dequeue() throws Exception {
        if(head.isEmpty()){
            if(tail.isEmpty()){
                throw new Exception("Empty queue can't dequeue!");
            }
            while(!tail.isEmpty()){
                head.push(tail.pop());
            }
        }
        return head.pop();
    }

    @Override
    public boolean isEmpty() {
        return tail.isEmpty() && head.isEmpty();
    }

    @Override
    public int size() {
        return tail.size() + head.size();
    }
}
