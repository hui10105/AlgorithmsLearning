package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * ResizingArrayList
 *
 * @author rhzhou
 * @date 2018/12/25 21:00
 */
public class ResizingArrayList<E> implements List<E>, Iterable<E> {
    private E items[];
    private int arraySize = 4;
    private int size = 0;
    private final int N = 2;
    private final float SUB = 0.25f;

    /**
     * 默认构造函数
     */
    ResizingArrayList() {
        items = (E[]) new Object[arraySize];
    }

    ResizingArrayList(Supplier<E> constr) {
        //items
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * @param e     所要插入的元素
     * @param index 要插入的位置
     */
    @Override
    public void insert(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Wrong insert index!");
        }
        //ArrayList
    }

    @Override
    public void add(E e) {

    }


}
