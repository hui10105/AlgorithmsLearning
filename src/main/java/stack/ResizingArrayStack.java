package stack;

import java.util.Iterator;

/**
 * 可变长数组泛型栈
 *
 * @author rh
 */
public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {
    private T items[];
    private int arraySize = 4;
    private int size = 0;
    private final int N = 2;
    private final float SUB = 0.25f;

    ResizingArrayStack() {
        // 由于java不能声明下面这样的泛型数组，所以只能使用比较丑陋的转型
        // items = new T[];
        items = (T[]) new Object[arraySize];
    }

    ResizingArrayStack(T item) {
        // 由于java不能声明下面这样的泛型数组，所以只能使用比较丑陋的转型
        // items = new T[];
        items = (T[]) new Object[arraySize];
        items[size] = item;
        size++;
    }

    @Override
    public void push(T item) {
        if (size < arraySize) {
            items[size] = item;
            size++;
        } else {
            arraySize = arraySize * N;
            T[] newItems = (T[]) new Object[arraySize];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            newItems[size] = item;
            items = newItems;
            size++;
        }
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack can't pop!");
        }
        T popItem = items[size - 1];
        items[size - 1] = null;
        size--;
        if (size < (arraySize * SUB)) {
            arraySize = (int) (arraySize * SUB);
            T[] newItems = (T[]) new Object[arraySize];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        return popItem;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T top() throws Exception {
        if(!isEmpty()){
            return items[size - 1];
        } else {
            throw new Exception("Empty Stack has no top!");
        }
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public void remove() { /* not supported */ }

        @Override
        public T next() {
            return items[--i];
        }
    }
}
