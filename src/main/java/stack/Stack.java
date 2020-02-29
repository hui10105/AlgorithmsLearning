package stack;

/**
 * 栈接口
 * @param <T>
 */
public interface Stack<T> {
    /**
     * 向栈压入T元素
     * @param item
     */
    public void push(T item);

    /**
     * 退出栈顶元素
     * @return
     * @throws Exception
     */
    public T pop() throws Exception;

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 返回栈内元素数量
     * @return
     */
    public int size();

    /**
     * 查看栈顶元素
     * @return
     * @throws Exception
     */
    public T top() throws Exception;
}
