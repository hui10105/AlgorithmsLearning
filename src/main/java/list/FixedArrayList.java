package list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * FixedArrayList
 *
 * @author rhzhou
 * @date 2018/12/25 20:49
 */
public class FixedArrayList<E> implements List<E> ,Iterable<E> {
    private E items[];
    private int maxSize = 10;
    private int size = 0;
    private final int N = 2;
    private final float SUB = 0.25f;

    FixedArrayList(){
        items = (E[]) new Object[maxSize];
    }

    FixedArrayList(int maxSize){
        items = (E[]) new Object[maxSize];
        this.maxSize = maxSize;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void insert(E e, int index) throws Exception {
        if(index <0 || index > size){
            throw new IllegalArgumentException("Wrong insert index!");
        }
        if(size >= maxSize){
            throw new Exception("List is full!");
        }
        for(int i = size - 1; i > index; i--){
            items[i] = items[i -1];
        }
        items[index] = e;
        size++;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public String toString(){
        return getClass()+":"+ Arrays.toString(items);
    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new FixedArrayList<>(5);
        //list.insert(1, -1);
        list.insert(1,0);
        list.insert(2,0);
        list.insert(3,0);
        list.insert(4,0);
        list.insert(5,0);
        System.out.println(list.toString());
        list.insert(6,0);
    }
}
