package queue;

/**
 * 队列接口
 *
 * @param <T>
 * @author rhzhou
 */
public interface Queue<T> {
    /**
     * 给队列添加元素
     *
     * @param item
     */
    void enqueue(T item);

    /**
     * 从队列中获取元素
     *
     * @return
     */
    T dequeue() throws Exception;

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队列长度
     *
     * @return
     */
    int size();
}
